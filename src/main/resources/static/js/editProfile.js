$(document).ready(function(){
	
	editProfilePassword = $('#editProfilePassword');
	editProfilePasswordCheck = $('#editProfilePasswordCheck');
	editProfileNickname = $('#editProfileNickname');
	editProfileEmail = $('#editProfileEmail');
	nicknameCheckedText = $('#nicknameChekedText');
	nicknameCheckBtn = $("#nicknameCheckBtn");
	nicknameCheckResult = 0;
	
	// 정규표현식
    passwordExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#>&])[A-Za-z\d$@$!%*#>&]{8,}$/;
    emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
    nicknameExp = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
	
	// 닉네임 변경 시 nicknameCheck 초기화
	editProfileNickname.on("input", function(){
        nicknameCheckBtn.show();
        nicknameCheckedText.hide();
        nicknameCheckResult = 0;
    });
    
    $('#editProfileForm').submit(function(){
	
		var rv = false;
		
		if(editProfilePassword.val() != "" || editProfilePasswordCheck.val() != ""){
			
			if(!passwordExp.test(editProfilePassword.val())){
            alert('비밀번호 형식이 올바르지 않습니다. (8자 이상, 영어, 숫자, 특수문자 1개 이상');
            editProfilePassword.focus();
            return rv;
       		}
       		
       		if(editProfilePassword.val() != editProfilePasswordCheck.val()){
            alert('비밀번호가 check와 같지 않습니다.');
            editProfilePasswordCheck.focus();
            return rv;
     	   }
       		
		}	
		
		if(editProfileNickname.val() != ""){
			
			if(!nicknameExp.test(editProfileNickname.val())){
            alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
            editProfileNickname.focus();
            return rv;
        	}
			
			if(nicknameCheckResult != 1){
            alert('닉네임 중복 검사를 해주세요.');
            editProfileNickname.focus();
            return rv;
        	}
			
		}
		
		if(editProfileEmail.val() != ""){
			
			if(!emailExp.test(editProfileEmail.val())){
            alert('이메일 형식이 올바르지 않습니다.');
            editProfileEmail.focus();
            return rv;
        	}
			
		}
	
})
	
})

// 닉네임 중복 체크 함수
function nicknameOverlapCheck(){
	
	if(editProfileNickname.val() == ''){
		alert('닉네임를 입력하세요.');
		editProfileNickname.focus();
		return false;
	}
	
	if(!nicknameExp.test(editProfileNickname.val())){
        alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
        editProfileNickname.focus();
        return false;
	}
	
	$.ajax({
		type: "POST",
		url: "/user/nicknameOverlapCheck",
		data: {"editProfileNickname":editProfileNickname.val()},
		success: function(data){
			if(data.count == 0){
                alert('사용 가능한 닉네임입니다.');
                nicknameCheckBtn.hide();
                nicknameCheckedText.show();
                editProfileEmail.focus();
                nicknameCheckResult = 1;
                window.opener.location.reload();
            }else{
                alert('같은 닉네임이 존재합니다.');
                nicknameCheckBtn.show();
                nicknameCheckedText.hide();
                nicknameCheckResult = 0;
                editProfileNickname.focus();
            }
		},
		error: function(error){
            alert('error : ' + error);
        }
	});
	
}