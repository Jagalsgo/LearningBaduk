$(document).ready(function(){
	
	writeTitle = $('#writeTitle');
	writeContent = $('#writeContent');
	
	$('#writeForm').submit(function(){
        if(writeTitle.val() == ''){
            alert('제목을 작성하세요.');
            writeTitle.focus();
            return false;
        }
        if(writeContent.val() == ''){
            alert('내용을 작성하세요.');
            writeContent.focus();
            return false; 
        }
    });
	
})