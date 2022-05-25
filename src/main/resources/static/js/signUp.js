$(document).ready(function(){
	
	signUpId = $('#signUpId');
	signUpPassword = $('#signUpPassword');
	signUpPasswordCheck = $('#signUpPasswordCheck');
	signUpNickname = $('#signUpNickname');
	signUpEmail = $('#signUpEmail');
	idCheckedText = $('#idCheckedText');
	nicknameCheckedText = $('#nicknameChekedText');
	idCheckBtn = $('#idCheckBtn');
	nicknameCheckBtn = $("#nicknameCheckBtn");
	idCheckResult = 0;
	nicknameCheckResult = 0;
	
	// 정규표현식
	idExp = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
    passwordExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#>&])[A-Za-z\d$@$!%*#>&]{8,}$/;
    emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
    nicknameExp = /^([a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]).{1,10}$/;
    
    // 아이디 변경 시 idCheck 초기화
	signUpId.on("input", function(){
        idCheckBtn.show();
        idCheckedText.hide();
        idCheckResult = 0;
    });
    
    // 닉네임 변경 시 nicknameCheck 초기화
	signUpNickname.on("input", function(){
        nicknameCheckBtn.show();
        nicknameCheckedText.hide();
        nicknameCheckResult = 0;
    });
    
    // 회원가입 버튼 클릭
    $('#signUpForm').submit(function(){
	
		// 정규 표현식 검사
        if(!idExp.test(signUpId.val())){
            alert('아이디 형식이 올바르지 않습니다. (4-20자 영어, 숫자, 첫자에는 숫자 불가)');
            signUpId.focus();
            return false;
        }
        if(!passwordExp.test(signUpPassword.val())){
            alert('비밀번호 형식이 올바르지 않습니다. (8자 이상, 영어, 숫자, 특수문자 1개 이상');
            signUpPassword.focus();
            return false;
        }
        if(!nicknameExp.test(signUpNickname.val())){
            alert('닉네임 형식이 올바르지 않습니다. (2-10자 한글, 영어, 숫자)');
            signUpNickname.focus();
            return false;
        }
        if(!emailExp.test(signUpEmail.val())){
            alert('이메일 형식이 올바르지 않습니다.');
            signUpEmail.focus();
            return false;
        }
        
        // 비밀번호와 check가 같지 않을 시
        if(signUpPassword.val() != signUpPasswordCheck.val()){
            alert('비밀번호가 check와 같지 않습니다.');
            regPasswordCheck.focus();
            return false;
        }
	
		// id 중복 검사 안했을 시
        if(idCheckResult != 1){
            alert('아이디 중복 검사를 해주세요.');
            signUpId.focus();
            return false;
        }
        
        // 닉네임 중복 검사 안했을 시
        if(nicknameCheckResult != 1){
            alert('닉네임 중복 검사를 해주세요.');
            signUpNickname.focus();
            return false;
        }
	
	});
	
})

// 아이디 중복 체크 함수

// 닉네임 중복 체크 함수