$(document).ready(function() {

	boardId = $('#boardId').val();
	userId = $('#userId').val();
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

	// 전체 체크
	$("#allChk").click(function() {
		console.log('aaa');
		if ($("#allChk").is(":checked")) {
			$("input[name=chk]").prop("checked", true);
		} else {
			$("input[name=chk]").prop("checked", false);
		}
	})

	// 전체 체크 시 allChk 체크
	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;

		if (total != checked) {
			$("#allChk").prop("checked", false);
		} else {
			$("#allChk").prop("checked", true);
		}
	});

	getComments(1);
	getBoards(detailsPage);

})

// like 버튼 클릭
function likeBtnClick(id) {
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

// dislike 버튼 클릭
function dislikeBtnClick(id) {
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
			if (data >= 1) {
				alert('댓글 등록 완료');
			}
			getComments(1);
			$('#commentContent').val('');
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

	$('.commentPage').removeClass('text-warning');
	$('.cListPage' + commentPage).addClass('text-warning');

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

				str += "<div class='col-6 p-3 border-bottom border-top'><input type='checkbox' name='chk' value='" + this.commentId + "'>";

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
					+ "<div class='col-12 p-3'>"
					+ this.commentContent
					+ "</div>"
					+ "<div class='text-right col-12 my-4' id='deleteComment'><span class='fw-bold text-muted' id='deleteCommentBtn' onclick='deleteComment(" + this.commentId + ")'>삭제</span></div>";

			});

			$('#comments').html(str);

		},
		error: function(error) {
			alert("error : " + error);
		}

	});

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
					str += "<td class='boardTitle'><a class='text-primary fw-bold' href='/admin/adminDetail?ct=" + categoryCt + "&id=" + this.boardId + "'>" + this.boardTitle + "  <span class='text-muted'>(" + this.commentCount + ")</span></a></td>";
				} else {
					str += "<td class='boardTitle'><a href='/admin/adminDetail?ct=" + categoryCt + "&id=" + this.boardId + "'>" + this.boardTitle + "  <span class='text-muted'>(" + this.commentCount + ")</span></a></td>";
				}


				str += "<td class='boardWriter fw-bold text-center'>"
					+ this.userNickname
					+ "</div>"
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

// admin 댓글 삭제
function deleteComments() {

	chk_arr = $("input[name='chk']");
	chkArray = [];
	for (var i = 0; i < chk_arr.length; i++) {
		if (chk_arr[i].checked == true) {
			chkArray.push(chk_arr[i].value);
		}
	}

	if (chkArray.length == 0) {
		alert("삭제할 댓글을 선택하세요.");
	} else {
		var deleteCommentConfirm = confirm('체크된 댓글들을 삭제하시겠습니까?');
		if (deleteCommentConfirm) {
			$.ajax({
				url: "/admin/deleteComments",
				type: "POST",
				data: {
					"chkArray": chkArray
				},
				success: function() {
					alert('삭제 완료');
					window.location.reload();
				},
				error: function(error) {
					alert("error : " + error);
				}
			})
		}
	}

}