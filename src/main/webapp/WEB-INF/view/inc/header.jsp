<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="headerItem" id="headerForm">	
		<div class="container-md my-3">
			<div class="row vertical-align">
				<div class="col-sm-11 col-xs-11">
					<img alt="baduk" src="/img/baduk.png" width="40" height="40">
					<span class="h4 fw-bold mx-2"><a href="">Learning Baduk</a></span>
				</div>
		    	<!-- 로그인 폼 -->
			    <div class="col-sm-1 col-xs-1 text-right" id="loginFormBox">
			    	<a href="/user/login"><img alt="login" src="/img/login.jpg" width="30" height="30" id="loginBtn"></a>
		    	</div> 
			    <!-- 회원 정보 폼 -->
			    <div class="col-sm-1 col-xs-1 text-right" id="userInfoFormBox">
			    	<i class="fa fa-solid fa-user fa-2x vertical-align" id="userInfoBtn"></i>
			    	<div class="openBox text-center" id="openUserInfoBox">
			    		<img class="mb-3 mt-4" alt="baduk" src="/img/baduk.png" width="100" height="100">
			    		<div class="my-3" id="userInfoBorderBox">
			    			<div class="innerBorderBox"><a href="s"><i class="fa fa-solid fa-envelope"></i> 쪽지함</a></div>
			    			<div class="innerBorderBox"><a href="s"><i class="fa fa-solid fa-folder-open"></i> 내가 쓴 글</a></div>
			    			<div class="innerBorderBox"><a href="s"><i class="fa fa-solid fa-book"></i> 나만의 게시판</a></div>
			    			<div class="innerBorderBox2"><a href="s"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></div>
			    		</div>
			    		<div class="my-4">
			    			<a href="aa"><button class="btn btn-secondary">로그아웃</button></a>
			    		</div>
			    	</div>
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