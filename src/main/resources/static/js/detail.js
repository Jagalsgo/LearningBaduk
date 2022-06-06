$(document).ready(function(){
	
	boardId = $('#boardId').val();
	userId = $('#userId').val();
	category = $('#category').val();
	detailsPage = $('#detailsPage').val();
	rv = false;

	// comment login 필요
    $('#commentNeedLoginBtn').click(function(){
		var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
		if(goLoginPage){
			location.href='/user/login';
		}
	})
	
	getComments(1);
	getBoards(detailsPage);
	
})

// like 버튼 클릭
function likeBtnClick(id){
    $.ajax({
		url:"/detail/addLike",
		type:"POST",
		data:{	"id":id},
		success: function(data){
			if(data.addLikeResult == -2){
				var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
				if(goLoginPage){
					location.href='/user/login';
				}
			}else if(data.addLikeResult == -1){
				alert('본인의 글은 추천이나 비추천을 할 수 없습니다.');
			}else if(data.addLikeResult == 0){
				alert('이미 추천이나 비추천을 누르셨습니다.');
			}else{
				$('#likeCount').text( data.likeCount);
			}
        },
        error: function(error){
            alert('error : ' + error);
        }
	})
}

// dislike 버튼 클릭
function dislikeBtnClick(id){
    $.ajax({
		url:"/detail/addDislike",
		type:"POST",
		data:{	"id":id},
		success: function(data){
			if(data.addDislikeResult == -2){
				var goLoginPage = confirm('로그인이 필요한 기능입니다 로그인 하시겠습니까?');
				if(goLoginPage){
					location.href='/user/login';
				}
			}else if(data.addDislikeResult == -1){
				alert('본인의 글은 추천이나 비추천을 할 수 없습니다.');
			}else if(data.addDislikeResult == 0){
				alert('이미 추천이나 비추천을 누르셨습니다.');
			}else{
				$('#dislikeCount').text(  data.dislikeCount);
			}
        },
        error: function(error){
            alert('error : ' + error);
        }
	})
}

// 댓글 등록
function postComment(){
	
	if($('#commentContent').val() == ''){
            alert('댓글 내용을 입력하세요.');
            $('#commentContent').focus();
            return rv;
    }
	
	var data = {
		"boardId": boardId,
		"commentContent": $('#commentContent').val()
	};
	
	$.ajax({
		url:"/detail/postComment",
		type:"POST",
		data:data,
		success: function(data){
			console.log(data);
			if(data >= 1){
				alert('댓글 등록 완료');
			}
			getComments(1);
			$('#commentContent').val('');
		},
		error: function(error){
			alert('error : ' + error);
		}
	})

}

// 댓글 삭제
function deleteComment(commentId){
	
	$.ajax({
		url:"/detail/deleteComment",
		type:"POST",
		data:{"commentId":commentId},
		success: function(data){
			console.log(data);
			if(data >= 1){
				alert('댓글 삭제 완료');
			}
			getComments(1);
		},
		error: function(error){
			alert('error : ' + error);
		}
	})
	
}

// 댓글 불러오기
function getComments(commentPage){
	
	var data = {
		"boardId": boardId,
		"commentPage": commentPage
	};
	
	$.ajax({
		url:"/detail/getComments",
		type:"POST",
		data: data,
		dataType: 'json',
		success: function(data){
			
			var str = "";
			
			$(data).each(function(){
				
				str += "<div class='col-6 p-3 border-bottom border-top'>";
				
				if(this.imgPath == null){
					str += "<span class='userMenuPointerDetail'><img alt='user' src='/img/user.png' width='25' height='25'> "+this.userNickname+"</span>";
				}else{
					str += "<span class='userMenuPointerDetail'><img alt='user' src='"+this.imgPath+"' width='25' height='25'> "+this.userNickname+"</span>";
				}
				
				str += "<div class='position-relative'>"
					 +		"<ul class='userMenuBoxDetail'>"
			         +     		"<li><a href='dd'><i class='fa fa-solid fa-envelope'></i> 쪽지 보내기</a></li>"
			         +     		"<li><a href='ss'><i class='fa fa-solid fa-flag'></i> 신고하기</a></li>"
			         +     "</ul>"
					 +	"</div>"
					 +	"</div>"
					 +	"<div class='col-6 p-3  border-bottom border-top text-muted text-right'>"+this.commentDate+"</div>"
					 +	"<div class='col-12 p-3'>"
					 +		this.commentContent	
					 +	"</div>";
					 
				if(userId == this.userId){
					str += "<div class='text-right col-12 my-4' id='deleteComment'><span class='fw-bold text-muted' id='deleteCommentBtn' onclick='deleteComment("+this.commentId+")'>삭제</span></div>"
				}
				
			});
			
			$('#comments').html(str);
			
		},
		error: function(error){
			alert("error : " + error);
		}
		
	});
	
}

// detail view 아래 list 불러오기
function getBoards(boardPage){
	
	var data = {
		"category": category,
		"boardPage": boardPage
	}
	
	$.ajax({
		url:"/detail/getBoards",
		type:"POST",
		data: data,
		dataType: 'json',
		success: function(data){
			
			var str = "";
			
			$(data).each(function(){
				
				str += "<tr>"
			                    +"<td class='boardDate text-muted text-center'>"+this.boardDate+"</td>"
			                    +"<td class='boardLike fw-bold'>"+(this.likeCount-this.dislikeCount)+"</td>";
			                    
                if(this.boardId == boardId){
					str += "<td class='boardTitle'><a class='text-primary fw-bold' href='/detail/endGameDetail?id="+this.boardId+"'>"+this.boardTitle+"  <span class='text-muted'>("+this.commentCount+")</span></a></td>";
				}else{
					str += "<td class='boardTitle'><a href='/detail/endGameDetail?id="+this.boardId+"'>"+this.boardTitle+"  <span class='text-muted'>("+this.commentCount+")</span></a></td>";
				}
			         
				            
			    str +=           "<td class='boardWriter fw-bold text-center'>"
			                    	+"<div class='position-relative userMenuPointer'>"+this.userNickname
			                    		+"<ul class='userMenuBox'>"
				                    		+"<li><a href='dd'><i class='fa fa-solid fa-envelope'></i> 쪽지 보내기</a></li>"
				                    		+"<li><a href='ss'><i class='fa fa-solid fa-flag'></i> 신고하기</a></li>"
				                    	+"</ul>"
			                    	+"</div>"
			                    +"</td>"
			                    +"<td class='boardHit text-muted text-center'>"+this.boardHit+"</td>"
		         	       +"</tr>";
	         	       
			});
			
			$('#boards').html(str);
			
		},
		error: function(error){
			alert("error : " + error);
		}
		
	});
	
}