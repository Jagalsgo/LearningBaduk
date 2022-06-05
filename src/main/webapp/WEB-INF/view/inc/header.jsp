<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="headerItem" id="headerForm">	
		<div class="container-md my-3">
			<div class="row vertical-align">
				<div class="col-sm-11 col-xs-11">
					<img alt="baduk" src="/img/baduk.png" width="40" height="40">
					<span class="h4 fw-bold mx-2"><a href="/board/home">Learning Baduk</a></span>
				</div>
		    	<c:choose>
		    		<c:when test="${empty user }">
					    <div class="col-sm-1 col-xs-1 text-right" id="loginFormBox">
					    	<a href="/user/login"><img alt="login" src="/img/login.jpg" width="30" height="30" id="loginBtn"></a>
				    	</div> 
		    		</c:when>
		    		<c:otherwise>
					    <div class="col-sm-1 col-xs-1 text-right" id="userInfoFormBox">
					    	<c:choose>
					    		<c:when test="${!empty profileImg }">
					    			<img alt="" src="${profileImg.imgPath }" class="headerProfileImg vertical-align">
					    		</c:when>
					    		<c:otherwise>
							    	<i class="fa fa-solid fa-user fa-2x vertical-align headerUserInfoBtn" id="userInfoBtn"></i>
					    		</c:otherwise>
					    	</c:choose>
					    	<div class="openBox text-center" id="openUserInfoBox">
					    		<img class="mb-3 mt-4" alt="baduk" src="/img/baduk.png" width="100" height="100">
					    		<div class="my-3" id="userInfoBorderBox">
					    			<div class="innerBorderBox"><a href="s"><i class="fa fa-solid fa-envelope"></i> 쪽지함</a></div>
					    			<div class="innerBorderBox"><a href="/board/myWritingBoard"><i class="fa fa-solid fa-folder-open"></i> 내가 쓴 글</a></div>
					    			<div class="innerBorderBox"><a href="/board/myOwnBoard"><i class="fa fa-solid fa-book"></i> 나만의 게시판</a></div>
					    			<div class="innerBorderBox2"><a href="/user/editProfile"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></div>
					    		</div>
					    		<div class="my-4">
					    			<a href="/user/logout"><button class="btn btn-secondary">로그아웃</button></a>
					    		</div>
					    	</div>
					    </div>
		    		</c:otherwise>
		    	</c:choose>
		   </div>
		</div>
	</div>
	<div class="headerItem" id="headerList">
		<div class="container-md py-3">
			<div class="row">
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/freeBoard">자유게시판</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/ruleBoard">룰</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/patternBoard">정석</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/openingBoard">포석</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/endGameBoard">끝내기</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/quetionBoard">바둑Q&A</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/scheduleBoard">프로바둑일정</a></div>
			   	<div class="col-sm-3 col-md fw-bold mb-2"><a href="/board/noticeBoard">공지</a></div>
		   	</div>
		</div>
	</div>