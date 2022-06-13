$(document).ready(function(){
	
	/*chkArray = new Array();
	$("input[name='chk']:checked").each(function(){
		chkArray.push(this.value);
		console.log(this.value);
	})*/
	
	/*chk_arr = $("input[name='chk']");
	console.log(chk_arr.length);
    chkArray = [];
    for( var i=0; i<chk_arr.length; i++ ) {
        if( chk_arr[i].checked == true ) {
            chkArray.push(chk_arr[i].value);
            console.log(chk_arr[i].value);
        }
    }*/
	
	// 전체 체크
	$("#allChk").click(function() {
		if($("#allChk").is(":checked")){
			$("input[name=chk]").prop("checked", true);
		} else{
			$("input[name=chk]").prop("checked", false);
		} 
	});
	
	// 전체 체크 시 allChk 체크
	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;

		if(total != checked){
			$("#allChk").prop("checked", false);
		} else{
			$("#allChk").prop("checked", true); 
		} 
	});
})

// admin 글 삭제
function deleteBoards(){
	
	var chk_arr = $("input[name='chk']");
    var chkArray = [];
    for( var i=0; i<chk_arr.length; i++ ) {
        if( chk_arr[i].checked == true ) {
            chkArray.push(chk_arr[i].value);
        }
    }
	
	if(chkArray.length == 0){
		alert("삭제할 글을 선택하세요.");
	}else{
		var deleteBoardConfirm = confirm('체크된 글들을 삭제하시겠습니까?');
		if(deleteBoardConfirm){
			$.ajax({
				url:"/admin/deleteBoards",
				type:"POST",
				data: {
					"chkArray": chkArray
				},
				success: function(){
					alert('삭제 완료');
					window.location.reload();
				},
				error: function(error){
					alert("error : " + error);
				}
			})
		}
	}
	
}

// admin 글 report 초기화
function initBoardReports(){
	
	var chk_arr = $("input[name='chk']");
    var chkArray = [];
    for( var i=0; i<chk_arr.length; i++ ) {
        if( chk_arr[i].checked == true ) {
            chkArray.push(chk_arr[i].value);
        }
    }
	
	if(chkArray.length == 0){
		alert("신고 횟수를 초기화 할 글을 선택하세요.");
	}else{
		var initBoardReportConfirm = confirm('체크된 글들의 신고 횟수를 초기화 하겠습니까?');
		if(initBoardReportConfirm){
			$.ajax({
				url:"/admin/initBoardReports",
				type:"POST",
				data: {
					"chkArray": chkArray
				},
				success: function(){
					alert('초기화 완료');
					window.location.reload();
				},
				error: function(error){
					alert("error : " + error);
				}
			})
		}
	}
	
}

// admin 유저 report 초기화
function initUserReports(){
	
	var chk_arr = $("input[name='chk']");
    var chkArray = [];
    for( var i=0; i<chk_arr.length; i++ ) {
        if( chk_arr[i].checked == true ) {
            chkArray.push(chk_arr[i].value);
        }
    }
	
	if(chkArray.length == 0){
		alert("신고 횟수를 초기화 할 유저를 선택하세요.");
	}else{
		var initUserReportConfirm = confirm('체크된 유저들의 신고 횟수를 초기화 하겠습니까?');
		if(initUserReportConfirm){
			$.ajax({
				url:"/admin/initUserReports",
				type:"POST",
				data: {
					"chkArray": chkArray
				},
				success: function(){
					alert('초기화 완료');
					window.location.reload();
				},
				error: function(error){
					alert("error : " + error);
				}
			})
		}
	}
	
}