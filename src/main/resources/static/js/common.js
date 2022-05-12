/*$(document).ready(function(){
	
	userMenuOpend = 0;
	userMenuOpendDetail = 0;
	
	// 유저 클릭 시 유저 메뉴
	$('.userMenuPointer').click(function(){
		if(userMenuOpend == 0){
			$('.userMenuBox').show();
			userMenuOpend = 1;
			return false;
		}else{
			$('.userMenuBox').hide();
			userMenuOpend = 0;
			return false;
		}
	})
	$('.userMenuPointerDetail').click(function(){
		if(userMenuOpendDetail == 0){
			$('.userMenuBoxDetail').show();
			userMenuOpendDetail = 1;
			return false;
		}else{
			$('.userMenuBoxDetail').hide();
			userMenuOpendDetail = 0;
			return false;
		}
	})
	
	$('html').click(function(e) { 
		if(!$('.userMenuBox').has(e.target).length) {
			$('.userMenuBox').hide();
			userMenuOpend = 0;
			return false;
		}
	});
	$('html').click(function(e) { 
		if(!$('.userMenuBoxDetail').has(e.target).length) {
			$('.userMenuBoxDetail').hide();	
			userMenuOpendDetail = 0;
			return false;
		}
	});
	
})*/