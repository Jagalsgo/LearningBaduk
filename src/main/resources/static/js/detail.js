$(document).ready(function(){
	
	// comment post btn 클릭 내용이 없을 시
    $('#commentForm').submit(function(){
        if($('#commentContent').val() == ''){
            alert('댓글 내용을 입력하세요.');
            $('#commentContent').focus();
            return false;
        }
    })
    
    // comment login 필요
    $('#commentNeedLoginBtn').click(function(){
		var goLoginPage = confirm('로그인 필요한 기능입니다 로그인 하시겠습니까?');
		if(goLoginPage){
			location.href='/user/login';
		}
	})
	
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