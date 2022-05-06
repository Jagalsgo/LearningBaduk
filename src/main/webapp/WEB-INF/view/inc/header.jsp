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
			    	<img alt="login" src="/img/login.jpg" width="30" height="30" id="loginBtn">
			    	<div class="container openBox" id="openLoginBox">
			    		<div class="row mt-3 mb-2">
			    			<div class="col text-center fw-bold h5">로그인</div>
			    			<div class="col"><input type="checkbox"> 자동 로그인</div>
			    		</div>
			    		<form class="row" action="dsf">
			    			<div class="col form-group">
			    				<input class="form-control" type="text" placeholder="아이디">
			    				<input class="form-control" type="password" placeholder="비밀번호">
			    			</div>
			    			<div class="col-4 form-group">
			    				<input class="form-control btn btn-secondary btn-sm mt-3" type="submit" value="로그인">
			    			</div>
			    		</form>
			    		<div class="row my-3">
			    			<a href="dlk" class="col text-center text-primary smText">아이디, 비밀번호가 기억 안납니까?</a>
			    		</div>
			    		<div class="row my-2">
			    			<a href="lsdnv" class="col text-center smText">회원가입</a>
			    		</div>
			    	</div>
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