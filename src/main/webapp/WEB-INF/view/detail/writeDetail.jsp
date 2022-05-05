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
    <link rel="stylesheet" href="/css/writeDetail.css">
    <script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/9e1a390ee4.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/js/header.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
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
	<div class="fw-bold h4 mb-4 col-12 container-md pt-5">자유게시판 - 글 작성</div>
	<div class="container-md border px-5 pt-4" id=writeFormBox>
		<form action="write.jsp" method="post" id="writeForm">
	        <div class="form-group mb-5">
				<label for="writeTitle" class="my-3 fw-bold" id="wirteTitleLabel">제목</label>
	            <input type="text" class="form-control" placeholder="제목" name="writeTitle" maxlength="50" id="writeTitle">
	        </div>
	        <div class="form-group">
	        	<label for="writeContent" class="my-2 fw-bold" id="writeContentLabel">내용</label>
	            <textarea type="text" class="form-control my-3" placeholder="내용" name="writeContent" maxlength="2048" style="height:350px" id="writeContent"></textarea>
			</div>
			<div class="row my-5">
				<div class="col-6" id="goToList"><i class="fa fa-solid fa-list fa-2x"></i></div>
				<div class="form-group col-6 text-right">
		    		<input type="submit" class="btn btn-secondary" value="글 작성">
				</div>
			</div>
      	</form>
	</div>

</body>
</html>