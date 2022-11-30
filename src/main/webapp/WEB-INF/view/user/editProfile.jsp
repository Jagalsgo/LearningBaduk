<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/editProfile.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/editProfile.js"></script>

<!-- Edit Profile Form -->
<div class="container-md">
	<form action="${pageContext.request.contextPath }/user/editProfile"
		method="post" class="border px-5 pt-4" id="editProfileForm"
		enctype="multipart/form-data">
		<input type="hidden" name="_method" value="PUT">
		<div class="fw-bold h4 mb-5 mt-3">회원 정보 수정</div>

		<sec:authorize access="isAuthenticated">
			<sec:authentication property="principal.userProfileImg"
				var="userProfileImg" />
			<sec:authentication property="principal.username" var="userId" />
		</sec:authorize>

		<!-- User's Profile Image Status -->
		<c:if test="${!empty userProfileImg }">
			<div class="text-center my-5">
				<img alt="" src="${userProfileImg }"
					style="height: 300px; width: 300px;">
			</div>
		</c:if>
		<div class="form-group">
			<label for="editProfileId" class="editProfileFormLabel">아이디</label>
			<div class="my-2">${userId }</div>
			<input type="hidden" value="${userId }" id="userId" name="userId">
		</div>
		<div class="form-group">
			<label for="editProfilePassword" class="editProfileFormLabel">비밀번호
				변경</label> <input type="password" class="form-control"
				placeholder="PASSWORD" id="editProfilePassword" name="userPassword">
		</div>
		<div class="form-group">
			<label for="editProfilePasswordCheck" class="editProfileFormLabel">비밀번호
				확인</label> <input type="password" class="form-control"
				placeholder="PASSWORD CHECK" id="editProfilePasswordCheck"
				name="userPasswordCheck">
		</div>
		<div class="form-group">
			<label for="editProfileName" class="editProfileFormLabel">닉네임</label>
			<input type="text" class="form-control" placeholder="NICKNAME"
				id="editProfileNickname" name="userNickname"> <input
				type="button" class="btn btn-secondary btn-sm" id="nicknameCheckBtn"
				value="닉네임 중복 체크" onclick="nicknameOverlapCheck()">
			<div class="text-success" id="nicknameCheckedText">checked!</div>
		</div>
		<div class="form-group">
			<label for="editProfileEmail" class="editProfileFormLabel mt-3">이메일</label>
			<input type="email" class="form-control" placeholder="EMAIL"
				id="editProfileEmail" name="userEmail"><input type="button"
				class="btn btn-secondary btn-sm" id="emailCheckBtn"
				value="이메일 중복 체크" onclick="emailOverlapCheck()">
			<div class="text-success" id="emailCheckedText">checked!</div>
			<div class="alert alert-primary p-1 fw-bold mt-2 mb-4" role="alert">이메일
				인증을 다시 하셔야 합니다.</div>
		</div>
		<div class="form-group">
			<label for="editProfileProfileImg" class="editProfileFormLabel">프로필
				사진</label> <input type="file" accept="image/*" class="form-control"
				id="editProfileProfileImg" name="profileImg"> <input
				type="button" class="btn btn-secondary btn-sm"
				id="deleteProfileImgBtn" value="프로필 사진 삭제"
				onclick="deleteProfileImg()">
		</div>
		<div class="form-group">
			<label for="editProfilePassword" class="editProfileFormLabel mt-5 h5">현재
				비밀번호</label> <input type="password" class="form-control mb-3" placeholder=""
				id="oldPassword" name="oldPassword">
		</div>
		<div class="form-group text-center my-5" id="editProfileSubmitBtnBox">
			<input type="submit" class="btn btn-primary pull-right"
				value="회원 정보 수정" id="editProfileSubmitBtn">
		</div>
		<input type="button" class="btn btn-secondary btn-sm" id="withdrawBtn"
			value="회원탈퇴" onclick="withdraw()">
	</form>
</div>