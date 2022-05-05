<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="/css/font-awesome.css">    
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/signUp.css">
    <script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/9e1a390ee4.js" crossorigin="anonymous"></script>
    <title>Learning Baduk</title>
</head>
<body>
	<!-- header  -->
	<div class="headerItem" id="headerForm">	
		<div class="container-md my-3">
			<div class="row">
				<div class="col-sm-11 col-xs-11">
					<img alt="baduk" src="/img/baduk.png" width="40" height="40">
					<span class="h4 fw-bold mx-2"><a href="">Learning Baduk</a></span>
				</div>
			    <div class="col-sm-1 col-xs-1">
			    	<img alt="login" src="/img/login.jpg" width="30" height="30" id="loginBtn">
			    </div>
		   </div>
		</div>
	</div>
	<div class="headerItem" id="headerList">
		<div class="container-md py-3">
			<div class="row">
			   	<div class="col-sm-3 col-md fw-bold mb-2">자유게시판</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">룰</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">정석</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">포석</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">끝내기</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">바둑Q&A</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">프로바둑일정</div>
			   	<div class="col-sm-3 col-md fw-bold mb-2">공지</div>
		   	</div>
		</div>
	</div>
	
	<!-- main -->
	<div class="container-md">
		<form action="signUpAction" method="post" class="border px-5 py-4" id="signUpForm">
			<div class="fw-bold h4 mb-5">회원가입</div>
	        <div class="form-group">
	            <label for="signUpId" class="signUpFormLabel">아이디</label>
	            <input type="text" class="form-control" placeholder="ID" id="signUpId" name="signUpId">
	            <div class="text-success" id="idCheckedText">checked!</div>
	        </div>
	        <div class="form-group">
	            <label for="signUpPassword" class="signUpFormLabel">비밀번호</label>
	            <input type="password" class="form-control" placeholder="PASSWORD" id="signUpPassword" name="signUpPassword">
	        </div>
	        <div class="form-group">
	            <label for="signUpPasswordCheck" class="signUpFormLabel">비밀번호 확인</label>
	            <input type="password" class="form-control" placeholder="PASSWORD CHECK" id="signUpPasswordCheck" name="signUpPasswordCheck">
	        </div>
	        <div class="form-group">
	            <label for="signUpName" class="signUpFormLabel">닉네임</label>
	            <input type="text" class="form-control" placeholder="NICKNAME" id="signUpNickname" name="signUpNickname">
	            <div class="text-success" id="idCheckedText">checked!</div>
	        </div>
	        <div class="form-group">
	            <label for="signUpEmail" class="signUpFormLabel">이메일</label>
	            <input type="email" class="form-control" placeholder="EMAIL" id="signUpEmail" name="signUpEmail">
	            <div class="text-success" id="idCheckedText">checked!</div>
	        </div>
	        <div class="form-group text-center my-4" id="signUpSubmitBtnBox">
	            <input type="submit" class="btn btn-secondary" value="회원가입" id="signUpSubmitBtn">
	        </div>
    	</form>
	</div>
	
	<!-- js setting -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>