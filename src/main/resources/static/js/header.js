$(document).ready(function(){
	
	loginBoxOpend = 0;
	userInfoOpend = 0;
	
	// 로그인 버튼 클릭 시 박스 오픈
	$('#loginBtn').click(function(){
		if(loginBoxOpend == 0){			
			$('#openLoginBox').show();
			loginBoxOpend = 1;
			return false;
		}else{
			$('#openLoginBox').hide();
			loginBoxOpend = 0;
			return false;
		}
	})
	
	// 회원 정보 클릭 시 박스 오픈
	$('#userInfoBtn').click(function(){
		if(userInfoOpend == 0){
			$('#openUserInfoBox').show();
			userInfoOpend = 1;
			return false;
		}else{
			$('#openUserInfoBox').hide();
			userInfoOpend = 0;
			return false;
		}
	})
	
	/*$('html').click(function(e) { 
		if(!$('#loginFormBox').has(e.target).length) {
			$('#openLoginBox').hide();	
			loginBoxOpend = 0;
			return false;
		}
	});
	$('html').click(function(e) { 
		if(!$('#userInfoFormBox').has(e.target).length) {
			$('#openUserInfoBox').hide();	
			userInfoOpend = 0;
			return false;
		}
	});*/

})