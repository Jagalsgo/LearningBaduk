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
	
	chk_arr = $("input[name='chk']");
    chkArray = [];
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