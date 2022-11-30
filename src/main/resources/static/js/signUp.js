$(document).ready(function() {

	signUpId = $('#signUpId');
	signUpPassword = $('#signUpPassword');
	signUpPasswordCheck = $('#signUpPasswordCheck');
	signUpNickname = $('#signUpNickname');
	signUpEmail = $('#signUpEmail');
	idCheckedText = $('#idCheckedText');
	idCheckBtn = $('#idCheckBtn');
	nicknameCheckedText = $('#nicknameChekedText');
	nicknameCheckBtn = $("#nicknameCheckBtn");
	emailCheckedText = $('#emailCheckedText');
	emailCheckBtn = $("#emailCheckBtn");
	idCheckResult = 0;
	nicknameCheckResult = 0;
	emailCheckResult = 0;

	// Regular Expression
	idExp = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
	passwordExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#>&])[A-Za-z\d$@$!%*#>&]{8,}$/;
	emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	nicknameExp = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;

	// Init IdCheck when Id Changed
	signUpId.on("input", function() {
		idCheckBtn.show();
		idCheckedText.hide();
		idCheckResult = 0;
	});

	// Init NicknameCheck when Nickname Changed
	signUpNickname.on("input", function() {
		nicknameCheckBtn.show();
		nicknameCheckedText.hide();
		nicknameCheckResult = 0;
	});
	
	// Init EmailCheck when Email Changed
	signUpEmail.on("input", function() {
		emailCheckBtn.show();
		emailCheckedText.hide();
		emailCheckResult = 0;
	});

	// Click SignUp Btn
	$('#signUpForm').submit(function() {

		var rv = false;

		// Check Regular Expression
		if (!idExp.test(signUpId.val())) {
			alert('아이디 형식이 올바르지 않습니다. (4-20자 영어, 숫자, 첫자에는 숫자 불가)');
			signUpId.focus();
			return rv;
		}
		if (!passwordExp.test(signUpPassword.val())) {
			alert('비밀번호 형식이 올바르지 않습니다. (8자 이상, 영어, 숫자, 특수문자 1개 이상');
			signUpPassword.focus();
			return rv;
		}
		if (!nicknameExp.test(signUpNickname.val())) {
			alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
			signUpNickname.focus();
			return rv;
		}
		if (!emailExp.test(signUpEmail.val())) {
			alert('이메일 형식이 올바르지 않습니다.');
			signUpEmail.focus();
			return rv;
		}

		// Check Password
		if (signUpPassword.val() != signUpPasswordCheck.val()) {
			alert('비밀번호가 check와 같지 않습니다.');
			signUpPasswordCheck.focus();
			return rv;
		}

		// Id OverlapCheck Status
		if (idCheckResult != 1) {
			alert('아이디 중복 검사를 해주세요.');
			signUpId.focus();
			return rv;
		}

		// Nickname OverlapCheck Status
		if (nicknameCheckResult != 1) {
			alert('닉네임 중복 검사를 해주세요.');
			signUpNickname.focus();
			return rv;
		}
		
		// Email OverlapCheck Status
		if (emailCheckResult != 1) {
			alert('이메일 중복 검사를 해주세요.');
			signUpEmail.focus();
			return rv;
		}

	});

})

function idOverlapCheck() {

	if (signUpId.val() == '') {
		alert('아이디를 입력하세요.');
		signUpId.focus();
		return false;
	}

	if (!idExp.test(signUpId.val())) {
		alert('아이디 형식이 올바르지 않습니다. (4-20자 영어, 숫자, 첫자에는 숫자 불가)');
		signUpId.focus();
		return false;
	}

	$.ajax({
		type: "GET",
		url: "/user/idOverlapCheck",
		data: { "id": signUpId.val() },
		success: function(data) {
			if (data.count == 0) {
				alert('사용 가능한 아이디입니다.');
				idCheckBtn.hide();
				idCheckedText.show();
				signUpPassword.focus();
				idCheckResult = 1;
				window.opener.location.reload();
			} else {
				alert('같은 아이디가 존재합니다.');
				idCheckBtn.show();
				idCheckedText.hide();
				idCheckResult = 0;
				signUpId.focus();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function nicknameOverlapCheck() {

	if (signUpNickname.val() == '') {
		alert('닉네임를 입력하세요.');
		signUpNickname.focus();
		return false;
	}

	if (!nicknameExp.test(signUpNickname.val())) {
		alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
		signUpNickname.focus();
		return false;
	}

	$.ajax({
		type: "GET",
		url: "/user/nicknameOverlapCheck",
		data: { "nickname": signUpNickname.val() },
		success: function(data) {
			if (data.count == 0) {
				alert('사용 가능한 닉네임입니다.');
				nicknameCheckBtn.hide();
				nicknameCheckedText.show();
				signUpEmail.focus();
				nicknameCheckResult = 1;
				window.opener.location.reload();
			} else {
				alert('같은 닉네임이 존재합니다.');
				nicknameCheckBtn.show();
				nicknameCheckedText.hide();
				nicknameCheckResult = 0;
				signUpNickname.focus();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

function emailOverlapCheck() {

	if (signUpEmail.val() == '') {
		alert('이메일을 입력하세요.');
		signUpEmail.focus();
		return false;
	}

	if (!emailExp.test(signUpEmail.val())) {
		alert('이메일 형식이 올바르지 않습니다.');
		signUpEmail.focus();
		return false;
	}

	$.ajax({
		type: "GET",
		url: "/user/emailOverlapCheck",
		data: { "email": signUpEmail.val() },
		success: function(data) {
			if (data.count == 0) {
				alert('사용 가능한 이메일입니다.');
				emailCheckBtn.hide();
				emailCheckedText.show();
				signUpEmail.focus();
				emailCheckResult = 1;
				window.opener.location.reload();
			} else if(data.count == -1) {
				alert('인증 대기중인 이메일입니다.');
				emailCheckBtn.show();
				emailCheckedText.hide();
				emailCheckResult = 0;
				signUpEmail.focus();
			}else{
				alert('같은 이메일이 존재합니다.');
				emailCheckBtn.show();
				emailCheckedText.hide();
				emailCheckResult = 0;
				signUpEmail.focus();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}