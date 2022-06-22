$(document).ready(function(){
	
	// 회원 정보 클릭 시 박스 오픈
	$('#userInfoBtn, .headerProfileImg').click(function(){
		$('#openUserInfoBox').toggle();
	})
	
	// 다른 지역 클릭 시 회원 박스 숨기기
	$('html').click(function(e) { 
		if(!$('#userInfoFormBox').has(e.target).length) {
			$('#openUserInfoBox').hide();	
		}
	}); 

})