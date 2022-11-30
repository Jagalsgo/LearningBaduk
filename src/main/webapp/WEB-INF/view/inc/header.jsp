<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!-- Site Image -->
<div class="headerItem" id="headerForm">
	<div class="container-md my-3">
		<div class="row vertical-align">
			<div class="col-7">
				<img alt="baduk"
					src="${pageContext.request.contextPath }/img/baduk.png" width="40"
					height="40"> <span class="h4 fw-bold mx-2"><a
					href="${pageContext.request.contextPath }/board/home">Learning
						Baduk</a></span>
			</div>

			<!-- Before Log In-->
			<sec:authorize access="isAnonymous">
				<div class="col-5 text-right" id="loginFormBox">
					<a href="${pageContext.request.contextPath }/user/login"><img
						alt="login" src="/img/login.jpg" width="40" height="40"
						id="loginBtn"></a>
				</div>
			</sec:authorize>

			<!-- After Log In -->
			<sec:authorize access="isAuthenticated">

				<sec:authentication property="principal.userProfileImg"
					var="userProfileImg" />
				<sec:authentication property="principal.username" var="userId" />
				<input type="hidden" id="userId" value="${userId }">

				<!-- User Info Menu -->
				<div class="col-5 text-right" id="userInfoFormBox">
					<sec:authorize access="hasRole('ADMIN')">
						<a href="${pageContext.request.contextPath }/admin/adminPages"><button
								class="btn btn-sm btn-secondary">admin</button></a>
					</sec:authorize>
					<!-- Alarm -->
					<span class="position-relative"> <i
						class="fa fa-solid fa-bell fa-2x vertical-align position-relative mx-3 alarmClick"
						style="cursor: pointer;" onclick="getAlarms()" id="alarmClick">
							<span
							class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
							style="width: 10px; height: 20px;" id="alarmCountView"> <span
								class="position-absolute top-50 left-10 translate-middle"
								style="font-size: 0.7rem;" id="alarmCountText"></span><span
								class="visually-hidden">unread messages</span>
						</span>
					</i> <span id="alarmsOpen" class="text-center alarmsOpen"
						style="width: 300px;"></span>
					</span>
					<!-- Profile Image -->
					<c:choose>
						<c:when test="${!empty userProfileImg }">
							<img alt="" src="${userProfileImg }"
								class="headerProfileImg vertical-align">
						</c:when>
						<c:otherwise>
							<img alt="" src="/img/user.png"
								class="vertical-align headerUserInfoBtn" id="userInfoBtn">
						</c:otherwise>
					</c:choose>
					<div class="openMyInfo text-center" id="openUserInfoBox">
						<c:choose>
							<c:when test="${!empty userProfileImg }">
								<img alt="" src="${userProfileImg }"
									class="mb-3 mt-4 vertical-align" width="100" height="100">
							</c:when>
							<c:otherwise>
								<img alt="" src="/img/user.png" class="mb-3 mt-4" width="100"
									height="100">
							</c:otherwise>
						</c:choose>
						<div class="my-3" id="userInfoBorderBox">
							<div class="innerBorderBox">
								<a href="${pageContext.request.contextPath }/user/myProfile"><i
									class="fa fa-solid fa-user"></i> 내 정보</a>
							</div>
							<div class="innerBorderBox">
								<a onclick="receivedMessage()" class="" style="cursor: pointer;"><i
									class="fa fa-solid fa-envelope"></i> 쪽지함</a>
							</div>
							<div class="innerBorderBox">
								<a
									href="${pageContext.request.contextPath }/board/myWritingBoard"><i
									class="fa fa-solid fa-folder-open"></i> 내가 쓴 글</a>
							</div>
							<div class="innerBorderBox">
								<a href="${pageContext.request.contextPath }/board/myOwnBoard"><i
									class="fa fa-solid fa-book"></i> 나만의 게시판</a>
							</div>
							<div class="innerBorderBox2">
								<a href="${pageContext.request.contextPath }/user/editProfile"><i
									class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a>
							</div>
						</div>
						<div class="my-4">
							<a href="${pageContext.request.contextPath }/logout"><button
									class="btn btn-secondary">로그아웃</button></a>
						</div>
					</div>
				</div>
			</sec:authorize>

		</div>
	</div>
</div>
<nav class="navbar navbar-expand-md navbar-light headerItem"
	id="headerList">
	<div class="container-md py-1">
		<!-- Toggle Button for Mobile Nav -->
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Navbar Links -->
		<div class="collapse navbar-collapse align-center" id="navbarNav">
			<ul class="navbar-nav row" style="width: 100%">
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=free" class="nav-link">자유게시판</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=rule" class="nav-link">룰</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=pattern" class="nav-link">정석</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=opening" class="nav-link">포석</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=endGame" class="nav-link">끝내기</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=lifeDeath" class="nav-link">사활</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=quetion" class="nav-link">바둑Q&A</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=schedule" class="nav-link">프로바둑일정</a></li>
				<li class="fw-bold mb-2 nav-item col-md"><a
					href="/board/board?ct=notice" class="nav-link">공지</a></li>
			</ul>
		</div>
	</div>
</nav>