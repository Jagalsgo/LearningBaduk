$(document).ready(function() {

})

function findId() {

	if ($('#findIdEmail').val() == '') {
		alert('이메일을 입력하세요.');
		$('#findIdEmail').focus();
		return false;
	}

	$.ajax({
		type: "POST",
		url: "/user/findId",
		data: { "findIdEmail": $('#findIdEmail').val() },
		success: function(data) {
			if (data == 'null') {
				alert('해당 회원이 존재하지 않습니다.');
			} else {
				alert('회원님의 아이디는 ' + data + ' 입니다.');
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function findPassword() {

	if ($('#findPasswordId').val() == '') {
		alert('아이디를 입력하세요.');
		$('#findPasswordId').focus();
		return false;
	}

	if ($('#findPasswordEmail').val() == '') {
		alert('이메일을 입력하세요.');
		$('#findPasswordEmail').focus();
		return false;
	}

	$.ajax({
		type: "POST",
		url: "/user/findPassword",
		data: {
			"findPasswordId": $('#findPasswordId').val(),
			"findPasswordEmail": $('#findPasswordEmail').val()
		},
		success: function(data) {
			if (data == 'null') {
				alert('해당 회원이 존재하지 않습니다.');
			} else if(data == 'incorrectEmail') {
				alert('해당 아이디와 이메일이 서로 맞지 않습니다.');
			} else{
				alert('해당 이메일로 임시 비밀번호를 보냈습니다.');
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}