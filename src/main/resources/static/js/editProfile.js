$(document).ready(function() {

	editProfilePassword = $('#editProfilePassword');
	editProfilePasswordCheck = $('#editProfilePasswordCheck');
	editProfileNickname = $('#editProfileNickname');
	editProfileEmail = $('#editProfileEmail');
	nicknameCheckedText = $('#nicknameCheckedText');
	nicknameCheckBtn = $("#nicknameCheckBtn");
	nicknameCheckResult = 0;
	emailCheckedText = $('#emailCheckedText');
	emailCheckBtn = $("#emailCheckBtn");
	emailCheckResult = 0;
	rv = false;

	// 정규표현식
	passwordExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#>&])[A-Za-z\d$@$!%*#>&]{8,}$/;
	emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	nicknameExp = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;

	//프로필 사진 삭제 시 물어보기
	$('#deleteProfileImgBtn').click(function() {
		var result = confirm('프로필 사진을 삭제하겠습니까?')
		if (!result) {
			return rv;
		}
	})

	//회원탈퇴 시 물어보기
	$('#withdrawBtn').click(function() {
		var result = confirm('회원 탈퇴 하시겠습니까?')
		if (!result) {
			return rv;
		}
	})

	// 닉네임 변경 시 nicknameCheck 초기화
	editProfileNickname.on("input", function() {
		nicknameCheckBtn.show();
		nicknameCheckedText.hide();
		nicknameCheckResult = 0;
	});
	
	// 이메일 변경 시 emailCheck 초기화
	editProfileEmail.on("input", function() {
		emailCheckBtn.show();
		emailCheckedText.hide();
		emailCheckResult = 0;
	});

	$('#editProfileForm').submit(function() {

		if (editProfilePassword.val() != "" || editProfilePasswordCheck.val() != "") {

			if (!passwordExp.test(editProfilePassword.val())) {
				alert('비밀번호 형식이 올바르지 않습니다. (8자 이상, 영어, 숫자, 특수문자 1개 이상');
				editProfilePassword.focus();
				return rv;
			}

			if (editProfilePassword.val() != editProfilePasswordCheck.val()) {
				alert('비밀번호가 check와 같지 않습니다.');
				editProfilePasswordCheck.focus();
				return rv;
			}

		}

		if (editProfileNickname.val() != "") {

			if (!nicknameExp.test(editProfileNickname.val())) {
				alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
				editProfileNickname.focus();
				return rv;
			}

			if (nicknameCheckResult != 1) {
				alert('닉네임 중복 검사를 해주세요.');
				editProfileNickname.focus();
				return rv;
			}

		}

		if (editProfileEmail.val() != "") {

			if (!emailExp.test(editProfileEmail.val())) {
				alert('이메일 형식이 올바르지 않습니다.');
				editProfileEmail.focus();
				return rv;
			}
			
			if (emailCheckResult != 1) {
				alert('이메일 중복 검사를 해주세요.');
				editProfileEmail.focus();
				return rv;
			}

		}

	})

})

// 닉네임 중복 체크 함수
function nicknameOverlapCheck() {

	if (editProfileNickname.val() == '') {
		alert('닉네임를 입력하세요.');
		editProfileNickname.focus();
		return false;
	}

	if (!nicknameExp.test(editProfileNickname.val())) {
		alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
		editProfileNickname.focus();
		return false;
	}

	$.ajax({
		type: "POST",
		url: "/user/nicknameOverlapCheck",
		data: { "nickname": editProfileNickname.val() },
		success: function(data) {
			if (data.count == 0) {
				alert('사용 가능한 닉네임입니다.');
				nicknameCheckBtn.hide();
				nicknameCheckedText.show();
				editProfileEmail.focus();
				nicknameCheckResult = 1;
				window.opener.location.reload();
			} else {
				alert('같은 닉네임이 존재합니다.');
				nicknameCheckBtn.show();
				nicknameCheckedText.hide();
				nicknameCheckResult = 0;
				editProfileNickname.focus();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 이메일 중복 체크 함수
function emailOverlapCheck() {

	if (editProfileEmail.val() == '') {
		alert('이메일을 입력하세요.');
		editProfileEmail.focus();
		return false;
	}

	if (!emailExp.test(editProfileEmail.val())) {
		alert('이메일 형식이 올바르지 않습니다.');
		editProfileEmail.focus();
		return false;
	}

	$.ajax({
		type: "POST",
		url: "/user/emailOverlapCheck",
		data: { "email": editProfileEmail.val() },
		success: function(data) {
			if (data.count == 0) {
				alert('사용 가능한 이메일입니다.');
				emailCheckBtn.hide();
				emailCheckedText.show();
				editProfileEmail.focus();
				emailCheckResult = 1;
				window.opener.location.reload();
			} else if(data.count == -1) {
				alert('인증 대기중인 이메일입니다.');
				emailCheckBtn.show();
				emailCheckedText.hide();
				emailCheckResult = 0;
				editProfileEmail.focus();
			}else{
				alert('같은 이메일이 존재합니다.');
				emailCheckBtn.show();
				emailCheckedText.hide();
				emailCheckResult = 0;
				editProfileEmail.focus();
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 프로필 사진 삭제
function deleteProfileImg() {
	console.log('aaa');
	$.ajax({
		type: "DELETE",
		url: "/user/deleteProfileImg",
		data: {
			"userId": $('#userId').val(),
			"oldPassword": $('#oldPassword').val()
		},
		success: function(data) {
			if (data.result == -1) {
				alert('기존 비밀번호가 올바르지 않습니다.');
				window.opener.location.reload();
				$('#oldPassword').focus();
			} else {
				alert('프로필 사진이 삭제되었습니다.');
				location.href = '/user/editProfile';
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}

// 회원 탈퇴
function withdraw() {

	$.ajax({
		type: "DELETE",
		url: "/user/withdraw",
		data: {
			"userId": $('#userId').val(),
			"oldPassword": $('#oldPassword').val()
		},
		success: function(data) {
			if (data.result == -1) {
				alert('기존 비밀번호가 올바르지 않습니다.');
				$('#oldPassword').focus();
			} else {
				alert('회원 탈퇴 되었습니다.');
				location.href = '/board/home';
			}
		},
		error: function(error) {
			alert('error : ' + error);
		}
	});

}