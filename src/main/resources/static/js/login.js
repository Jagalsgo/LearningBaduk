$(document).ready(function(){
	
	$('#loginForm').submit(function(){
		
		// Need Insert Id
		if($('#userId').val() == ""){
			alert('아이디를 입력하세요.');
            $('#userId').focus();
            return false;
		}
		
		// Need Insert Password
		if($('#userPassword').val() == ""){
			alert('비밀번호를 입력하세요.');
            $('#userPassword').focus();
            return false;
		}
		
	})
	
})