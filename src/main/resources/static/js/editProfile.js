$(document).ready(function(){
	
	// 로그인 폼 입력 시
	$('#loginForm').submit(function(){
		
		// 아이디 입력 안했을 시 
		if($('#userId').val() == ""){
			alert('아이디를 입력하세요.');
            $('#userId').focus();
            return false;
		}
		
		// 비밀번호 입력 안했을 시 
		if($('#userPassword').val() == ""){
			alert('비밀번호를 입력하세요.');
            $('#userPassword').focus();
            return false;
		}
		
	})
	
})