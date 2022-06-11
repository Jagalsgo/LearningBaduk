$(document).ready(function(){
	$("#allChk").click(function() {
		if($("#allChk").is(":checked")){
			$("input[name=chk]").prop("checked", true);
		} 
		else{
			$("input[name=chk]").prop("checked", false);
		} 
	});

	$("input[name=chk]").click(function() {
		var total = $("input[name=chk]").length;
		var checked = $("input[name=chk]:checked").length;

		if(total != checked) $("#allChk").prop("checked", false);
		else $("#allChk").prop("checked", true); 
	});
})