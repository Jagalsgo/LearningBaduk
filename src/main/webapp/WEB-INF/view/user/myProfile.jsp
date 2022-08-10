<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/myProfile.css">
<div class="container-md border" id="myProfileForm">
	<div class="fw-bold h4 mb-5">내 정보</div>
	<sec:authorize access="isAuthenticated">
		<sec:authentication property="principal.userProfileImg"
			var="userProfileImg" />
		<sec:authentication property="principal.username" var="userId" />
	</sec:authorize>

	<c:if test="${!empty userProfileImg }">
		<div class="text-center my-5">
			<img alt="" src="${userProfileImg }"
				style="height: 300px; width: 300px;">
		</div>
	</c:if>
	<div class="form-group my-4">
		<label for="myProfileId" class="myProfileFormLabel">아이디</label>
		<div class="my-2 px-3">${userId }</div>
		<input type="hidden" value="${userId }" id="userId" name="userId">
	</div>
	<div class="form-group">
		<label for="myProfileName" class="myProfileFormLabel">닉네임</label>
		<div class="my-2 px-3">${user.userNickname }</div>
	</div>
	<div class="form-group">
		<label for="myProfileEmail" class="myProfileFormLabel mt-3">이메일</label>
		<div class="my-2 px-3">${user.userEmail }</div>
	</div>
	<div class="form-group text-center my-5">
		<a href="${pageContext.request.contextPath }/user/editProfile" id="goToEditProfile"><button
				class="btn btn-primary">회원 정보 수정</button></a>
	</div>
</div>