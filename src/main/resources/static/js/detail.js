$(document).ready(function(){
	
	boardId = $('#boardId').val();

	// comment login 필요
    $('#commentNeedLoginBtn').click(function(){
		var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
		if(goLoginPage){
			location.href='/user/login';
		}
	})
	
	// comment post btn 클릭 내용이 없을 시
    $('#postCommentBtn').click(function(){
		if($('#commentContent').val() == ''){
            alert('댓글 내용을 입력하세요.');
            $('#commentContent').focus();
            return false;
        }
	})
    
	getComments(boardId, 1);
	
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
			getComments(boardId, 1);
			$('#commentContent').val('');
		},
		error: function(error){
			alert('error : ' + error);
		}
	})

}

// 댓글 불러오기
function getComments(boardId, commentPage){
	
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
				
				
				str += "<div class='col-6 p-3 border-bottom border-top'>"
					 +	"<span class='userMenuPointerDetail'><img alt='baduk' src='/img/baduk.png' width='25' height='25'> "+this.userId+"</span>"
					 + "<div class='position-relative'>"
					 +		"<ul class='userMenuBoxDetail'>"
			         +     		"<li><a href='dd'><i class='fa fa-solid fa-envelope'></i> 쪽지 보내기</a></li>"
			         +     		"<li><a href='ss'><i class='fa fa-solid fa-flag'></i> 신고하기</a></li>"
			         +     "</ul>"
					 +	"</div>"
					 +	"</div>"
					 +	"<div class='col-6 p-3  border-bottom border-top text-muted text-right'>"+this.commentDate+"</div>"
					 +	"<div class='col-12 p-3'>"
					 +		this.commentContent	
					 +	"</div>"
					 +	"<c:if test='${c.userId == user.userId }'>"
					 +		"<div class='text-right col-12 my-4' id='deleteComment'><a class='fw-bold text-muted' href='/detail/deleteComment?cid=${c.commentId }&id=${boardView.boardId}&ct=endGameDetail'>삭제</a></div>"
					 +	"</c:if>";
				
			});
			
			$('#comments').html(str);
			
		},
		error: function(error){
			alert("error : " + error);
		}
		
	})
	
}