<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/signUp.css">
<script type="text/javascript" src="/js/signUp.js"></script>
<div class="container-md">
	<form action="${pageContext.request.contextPath }/user/signUp"
		method="post" class="border px-5 py-4" id="signUpForm">
		<div class="fw-bold h4 mb-5">회원가입</div>
		<div class="form-group">
			<label for="signUpId" class="signUpFormLabel">아이디</label> <input
				type="text" class="form-control" placeholder="ID" id="signUpId"
				name="userId"> <input type="button"
				class="btn btn-secondary btn-sm" id="idCheckBtn" value="아이디 중복 확인"
				onclick="idOverlapCheck()">
			<div class="text-success" id="idCheckedText">checked!</div>
		</div>
		<div class="form-group">
			<label for="signUpPassword" class="signUpFormLabel">비밀번호</label> <input
				type="password" class="form-control" placeholder="PASSWORD"
				id="signUpPassword" name="userPassword">
		</div>
		<div class="form-group">
			<label for="signUpPasswordCheck" class="signUpFormLabel">비밀번호
				확인</label> <input type="password" class="form-control"
				placeholder="PASSWORD CHECK" id="signUpPasswordCheck"
				name="userPasswordCheck">
		</div>
		<div class="form-group">
			<label for="signUpName" class="signUpFormLabel">닉네임</label> <input
				type="text" class="form-control" placeholder="NICKNAME"
				id="signUpNickname" name="userNickname"> <input
				type="button" class="btn btn-secondary btn-sm" id="nicknameCheckBtn"
				value="닉네임 중복 체크" onclick="nicknameOverlapCheck()">
			<div class="text-success" id="nicknameCheckedText">checked!</div>
		</div>
		<div class="form-group">
			<label for="signUpEmail" class="signUpFormLabel">이메일</label> <input
				type="email" class="form-control" placeholder="EMAIL"
				id="signUpEmail" name="userEmail"> <input type="button"
				class="btn btn-secondary btn-sm" id="emailCheckBtn"
				value="이메일 중복 체크" onclick="emailOverlapCheck()">
			<div class="text-success" id="emailCheckedText">checked!</div>
			<div class="alert alert-primary p-1 fw-bold my-2" role="alert">이메일
				인증 후 로그인 가능합니다.</div>
		</div>
		<div class="form-group text-center my-4" id="signUpSubmitBtnBox">
			<input type="submit" class="btn btn-secondary" value="회원가입"
				id="signUpSubmitBtn">
		</div>
	</form>
</div>