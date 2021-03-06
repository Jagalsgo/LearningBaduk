$(document).ready(function() {

	boardId = $('#boardId').val();
	userId = $('#userId').val();
	boardUserId = $('#boardUserId').val();
	category = $('#category').val();
	categoryCt = $('#categoryCt').val();
	detailsPage = $('#detailsPage').val();
	rv = false;

	// comment login 필요
	$('#commentNeedLoginBtn').click(function() {
		var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
		if (goLoginPage) {
			location.href = '/user/login';
		}
	})
	// report login 필요
	$('#reportNeedLoginBtn').click(function() {
		var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
		if (goLoginPage) {
			location.href = '/user/login';
		}
	})

	if(localStorage.getItem('page')){
		getComments(localStorage.getItem('page'));
		localStorage.removeItem('page');
	}else{
		getComments(1);
	}

	getBoards(detailsPage);
	
})

// like 버튼 클릭
function likeBtnClick(id) {

	if (userId == -1) {
		var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
		if (goLoginPage) {
			location.href = '/user/login';
		}
	} else {
		$.ajax({
			url: "/detail/addLike",
			type: "POST",
			data: { "id": id },
			success: function(data) {
				if (data.addLikeResult == -2) {
					var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
					if (goLoginPage) {
						location.href = '/user/login';
					}
				} else if (data.addLikeResult == -1) {
					alert('본인의 글은 추천이나 비추천을 할 수 없습니다.');
				} else if (data.addLikeResult == 0) {
					alert('이미 추천이나 비추천을 누르셨습니다.');
				} else {
					$('#likeCount').text(data.likeCount);
				}
			},
			error: function(error) {
				alert('error : ' + error);
			}
		})
	}
}

// dislike 버튼 클릭
function dislikeBtnClick(id) {

	if (userId == -1) {
		var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
		if (goLoginPage) {
			location.href = '/user/login';
		}
	} else {
		$.ajax({
			url: "/detail/addDislike",
			type: "POST",
			data: { "id": id },
			success: function(data) {
				if (data.addDislikeResult == -2) {
					var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
					if (goLoginPage) {
						location.href = '/user/login';
					}
				} else if (data.addDislikeResult == -1) {
					alert('본인의 글은 추천이나 비추천을 할 수 없습니다.');
				} else if (data.addDislikeResult == 0) {
					alert('이미 추천이나 비추천을 누르셨습니다.');
				} else {
					$('#dislikeCount').text(data.dislikeCount);
				}
			},
			error: function(error) {
				alert('error : ' + error);
			}
		})
	}

}

// 댓글 등록
function postComment() {

	if ($('#commentContent').val() == '') {
		alert('댓글 내용을 입력하세요.');
		$('#commentContent').focus();
		return rv;
	}

	var data = {
		"boardId": boardId,
		"commentContent": $('#commentContent').val()
	};

	$.ajax({
		url: "/detail/postComment",
		type: "POST",
		data: data,
		success: function(data) {
			alert('댓글 등록 완료');
			var lastCommentPage = Math.ceil(data.commentCount / 10);
			getComments(lastCommentPage);
			$('#commentContent').val('');
			/*setTimeout(function() {
				$('#commentIdIs' + data.commentId).focus();
				console.log(data.commentId);
			}, 1000);*/

			// 웹소켓 알림 연결
			if (socket) {
				var socketMsg = {
					type: "comment",
					receiver: boardUserId,
					boardId: boardId,
					sender: userId
				}
				if (boardUserId != userId) {
					socket.send(JSON.stringify(socketMsg));
				} else {
				}
			}

		},
		error: function(error) {
			alert('error : ' + error);
		}
	})

}

// 댓글 삭제
function deleteComment(commentId) {

	$.ajax({
		url: "/detail/deleteComment",
		type: "POST",
		data: { "commentId": commentId },
		success: function(data) {
			if (data >= 1) {
				alert('댓글 삭제 완료');
			}
			getComments(1);
		},
		error: function(error) {
			alert('error : ' + error);
		}
	})

}

// 댓글 불러오기
function getComments(commentPage) {

	var firstCommentPage = commentPage - (commentPage - 1) % 5;
	var lastCommentPage = Math.ceil($('#commentCountJs').val() / 10);

	var data = {
		"boardId": boardId,
		"commentPage": commentPage
	};

	$.ajax({
		url: "/detail/getComments",
		type: "POST",
		data: data,
		dataType: 'json',
		success: function(data) {

			var str = "";

			$(data).each(function() {

				// 모댓글
				if (this.commentDepth == 0) {

					str += "<div class='col-6 p-3 border-bottom border-top' id='commentIdIs" + this.commentId + "'>";

					if (this.imgPath == null) {
						str += "<span class='userMenuClick userMenuPointer mx-2'"
							+ "onclick = 'openUserMenuC(" + this.commentId + ", \"" + this.userId + "\")' >"
							+ "<img alt='user' src='/img/user.png' width='25' height='25'>"
							+ this.userNickname + "<span id='commentId" + this.commentId + "'"
							+ "class='commentIdAll position-relative'></span>"
							+ "</span >";
					} else {
						str += "<span class='userMenuClick userMenuPointer mx-2'"
							+ "onclick = 'openUserMenuC(" + this.commentId + ", \"" + this.userId + "\")' >"
							+ "<img alt='user' src='" + this.imgPath + "' width='25' height='25'>"
							+ this.userNickname + "<span id='commentId" + this.commentId + "'"
							+ "class='commentIdAll position-relative'></span>"
							+ "</span >";

					}

					str += "</div>"
						+ "<div class='col-6 p-3  border-bottom border-top text-muted text-right'>" + this.commentDate + "</div>"
						+ "<div class='col-12 p-3'>";
					// 답글이 달렸지만 삭제된 댓글
					if (this.deleted == true) {
						str += "(삭제된 댓글입니다)";
					} else {
						str += this.commentContent;
					}

					str += "</div>";

					// 답글 쓰기
					if (userId != -1) {
						str += "<a class='text-right col-12 my-3' id='postReCommentBox'><span class='fw-bold' id='postReCommentBoxBtn' onclick='clickPostReComment(" + this.commentId + ", \"" + this.userNickname + "\")'>댓글달기</span></a>";
					}
					// 댓글 삭제
					if (userId == this.userId) {
						str += "<div class='text-right col-12 mb-4' id='deleteComment'><span class='fw-bold text-muted' id='deleteCommentBtn' onclick='deleteComment(" + this.commentId + ")'>삭제</span></div>";
					}
					str += "<div class='reCommentIdAll' id='reCommentId" + this.commentId + "'></div>";

				} else if (this.commentDepth == 1) /*모댓글의 답글*/ {

					str += "<div class='col p-3 border-bottom border-top reCommentUser id='commentIdIs" + this.commentId + "'>";

					if (this.imgPath == null) {
						str += "<span class='userMenuClick userMenuPointer mx-2'"
							+ "onclick = 'openUserMenuC(" + this.commentId + ", \"" + this.userId + "\")' >"
							+ "ㄴ  <img alt='user' src='/img/user.png' width='25' height='25'>"
							+ this.userNickname + "<span id='commentId" + this.commentId + "'"
							+ "class='commentIdAll position-relative'></span>"
							+ "</span >";
					} else {
						str += "<span class='userMenuClick userMenuPointer mx-2'"
							+ "onclick = 'openUserMenuC(" + this.commentId + ", \"" + this.userId + "\")' >"
							+ "<img alt='user' src='" + this.imgPath + "' width='25' height='25'>"
							+ this.userNickname + "<span id='commentId" + this.commentId + "'"
							+ "class='commentIdAll position-relative'></span>"
							+ "</span >";
					}

					str += "</div>"
						+ "<div class='col p-3  border-bottom border-top text-muted text-right'>" + this.commentDate + "</div>"
						+ "<div class='col-12 p-3 reCommentContent'>"
						+ this.commentContent
						+ "</div>";

					// 댓글 삭제
					if (userId == this.userId) {
						str += "<div class='text-right col-12 mb-4' id='deleteComment'><span class='fw-bold text-muted' id='deleteCommentBtn' onclick='deleteComment(" + this.commentId + ")'>삭제</span></div>";
					}
					str += "<div class='reCommentIdAll' id='reCommentId" + this.commentId + "'></div>";

				}


			});

			// comment pagenation
			str += "<div aria-label='Page navigation example' class='mt-5 mb-3'>"
				+ "<ul class='pagination pagination-sm justify-content-center'>";
			// << 페이지
			if (firstCommentPage > 1) {
				str += "<li class='page-item'>"
					+ "<div class='page-link commentPage' onclick='getComments(" + (firstCommentPage - 5) + ")' aria-label='Previous'>"
					+ "<span aria-hidden='true'>&laquo;</span>"
					+ "</div>"
					+ "</li>";
			}
			// 중간 페이지
			for (var i = 0; i < 5; i++) {
				if ((firstCommentPage + i) <= lastCommentPage) {
					str += "<li class='page-item'><span "
					if (commentPage == (firstCommentPage + i)) {
						str += "class='page-link commentPage text-warning' ";
					} else {
						str += "class='page-link commentPage' ";
					}
					str += "onclick='getComments(" + (firstCommentPage + i) + ")'>" + (firstCommentPage + i) + "</span></li>";
				}
			}
			// >> 페이지	
			if (firstCommentPage + 4 < lastCommentPage) {
				str += "<li class='page-item'>"
					+ "<div class='page-link commetPage' onclick='getComments(" + (firstCommentPage + 5) + ")'"
					+ "aria-label='Next'>"
					+ "<span aria-hidden='true'>&raquo;</span>"
					+ "</div>"
					+ "</li>";
			}

			str += "</ul>"
				+ "</div>";

			$('#comments').html(str);

		},
		error: function(error) {
			alert("error : " + error);
		}

	});

}

// 답글 달기 폼 열기
function clickPostReComment(commentId, userNickname) {

	$('.reCommentIdAll').empty();
	var str = "";
	str += "<div class='container-md border p-3 my-5'>"
		+ "<div class='mt-2 mb-4'><span class='fw-bold' id='postReCommentText'>" + userNickname + " 님에게 댓글</span><a onclick='closeReCommentBox()' class='mx-3 mousePointer fw-bold' style='float:right; font-size:0.8rem;'>X 닫기</a></div>"
		+ "<div class='form-floating form-group'>"
		+ "<input type='text' class='form-control' id='reCommentContent' "
		+ "name='reCommentContent'> <label for='reCommentContent'>Comments</label>"
		+ "</div>"
		+ "<div class='text-right my-1'>"
		+ "<button class='btn btn-secondary mt-2' onclick='postReComment(" + commentId + ")' "
		+ "id='postReCommentBtn'>작성</button>"
		+ "</div>";

	$('#reCommentId' + commentId).html(str);

}

// 답글 달기 폼 닫기
function closeReCommentBox() {
	$('.reCommentIdAll').empty();
}

// 답글 등록
function postReComment(parentId) {

	if ($('#reCommentContent').val() == '') {
		alert('댓글 내용을 입력하세요.');
		$('#commentContent').focus();
		return rv;
	}

	var data = {
		"boardId": boardId,
		"reCommentContent": $('#reCommentContent').val(),
		"parentId": parentId
	};

	$.ajax({
		url: "/detail/postReComment",
		type: "POST",
		data: data,
		success: function(data) {
			alert('댓글 등록 완료');
			getComments(data.currentPage);
			$('#reCommentContent').val('');

			// 웹소켓 알림 연결
			if (socket) {
				var socketMsg = {
					type: "reComment",
					receiver: data.receiver,
					sender: userId
				}
				if (data.receiver != userId) {
					socket.send(JSON.stringify(socketMsg));
				}
			}

		},
		error: function(error) {
			alert('error : ' + error);
		}
	})

}

// detail view 아래 list 불러오기
function getBoards(boardPage) {

	$('.boardPage').removeClass('text-warning');
	$('.listPage' + boardPage).addClass('text-warning');

	var data = {
		"category": category,
		"boardPage": boardPage
	}

	$.ajax({
		url: "/detail/getBoards",
		type: "POST",
		data: data,
		dataType: 'json',
		success: function(data) {

			var str = "";

			$(data).each(function() {

				str += "<tr>"
					+ "<td class='boardDate text-muted text-center'>" + this.boardDate + "</td>"
					+ "<td class='boardLike fw-bold'>" + (this.likeCount - this.dislikeCount) + "</td>";

				if (this.boardId == boardId) {
					str += "<td class='boardTitle'><a class='text-primary fw-bold' href='/detail/detail?ct=" + categoryCt + "&id=" + this.boardId + "'>" + this.boardTitle + "  <span class='text-muted'>(" + this.commentCount + ")</span></a></td>";
				} else {
					str += "<td class='boardTitle'><a href='/detail/detail?ct=" + categoryCt + "&id=" + this.boardId + "'>" + this.boardTitle + "  <span class='text-muted'>(" + this.commentCount + ")</span></a></td>";
				}


				str += "<td class='boardWriter fw-bold text-center'>" + this.userNickname
					+ "</td>"
					+ "<td class='boardHit text-muted text-center'>" + this.boardHit + "</td>"
					+ "</tr>";

			});

			$('#boards').html(str);

		},
		error: function(error) {
			alert("error : " + error);
		}

	});

}

// 게시글 신고
function reportBoard(boardId) {

	$.ajax({
		url: "/detail/reportBoard",
		type: "POST",
		data: { "boardId": boardId },
		success: function(data) {
			if (data <= 0) {
				alert('이미 신고하셨습니다.');
			} else {
				alert('신고 완료');
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	})

}