$(document).ready(function() {

})

function reportUserPost() {

	$.ajax({
		type: "POST",
		url: "/popup/reportUserPost",
		data: {
			"reportedUser": $('#reportedUser').val(),
			"reportContent": $('#reportContent').val()
		},
		success: function(data) {
			if (data <= 0) {
				alert('이미 신고하셨습니다.');
			} else {
				alert('신고 완료');
				window.close();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}