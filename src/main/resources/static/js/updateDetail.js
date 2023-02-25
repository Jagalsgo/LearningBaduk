$(document).ready(function() {

	updateTitle = $('#updateTitle');
	updateContent = $('#updateContent');

	// Click Update Detail Btn
	$('#updateForm').submit(function() {
		if (updateTitle.val() == '') {
			alert('제목을 작성하세요.');
			updateTitle.focus();
			return false;
		}
		if (updateContent.val() == '') {
			alert('내용을 작성하세요.');
			updateContent.focus();
			return false;
		}
	})

})