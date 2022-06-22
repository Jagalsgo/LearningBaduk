<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/css/userProfile.css">
<div class="cotainer-fluid popupHeader">${user.userNickname }님의 프로필</div>
<div class="row">
	<div class="col-12 text-center my-4">
		<c:choose>
			<c:when test="${user.userProfileImg == null }">
				<img alt="user" src="/img/user.png" width="200" height="180">
			</c:when>
			<c:otherwise>
				<img alt="user" src="${user.userProfileImg }" width="200" height="180">
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-4 col-lg-2 tableHeader">
		닉네임
	</div>
	<div class="col-8 col-lg-10 tableBody">
		${user.userNickname }
	</div>
	<div class="col-4 col-lg-2 tableHeader">
		가입일
	</div>
	<div class="col-8 col-lg10 tableBody">
		<fmt:formatDate value="${user.userDate }" pattern="yyyy-MM-dd"/>
	</div>
	<div class="col-12 text-center my-3">
		<a href="/popup/sendMessage?userId=${user.userId }"><button class="btn btn-secondary btn-sm">쪽지 보내기</button></a>
	</div>
	<div class="col-12 text-center">
		<a href="/popup/reportUser?userId=${user.userId }"><button class="btn btn-secondary btn-sm">신고하기</button></a>
	</div>
</div>