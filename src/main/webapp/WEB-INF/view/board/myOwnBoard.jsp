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
    <link rel="stylesheet" href="/css/board.css">
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
	
	<!-- main  -->
	<div class="container-md py-5">
		<div class="row">
			<div class="fw-bold h4 mb-4 col-12">나만의 게시판</div>
			<div class="tableBox">
				<table class="table">
		            <thead class="table-secondary">
		                <tr class="vertical-align">
		                    <th style="width:10%" class="text-center listDate"><i class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
		                    <th></th>
		                    <th style="width:20%" class="text-center"><i class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td class="boardDate text-muted text-center">17-08-14</td>
		                    <td class="boardTitle">this is title is title man</td>
		                    <td class="boardWriter fw-bold text-center">
		                    	<div class="position-relative userMenuPointer">writer
		                    	<ul class="userMenuBox">
		                    		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
		                    		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
		                    	</ul>
		                    	</div>
		                    </td>
		                </tr>
		            </tbody>
		        </table>
	        </div>	
		</div>
	</div>
	
	<!-- about list  -->
	<div class="container-md my-4">
		<div class="row">
			<!-- go to list  -->
			<div class="col-sm-1 col-md-1" id="goToList"><i class="fa fa-solid fa-list fa-2x"></i></div>
			<!-- pagination -->
			<div aria-label="Page navigation example" class="col-sm-8 col-md-9" id="pagination">
		        <ul class="pagination pagination-sm justify-content-center">
		            <li class="page-item">
		                <a class="page-link" href="#" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		                </a>
		            </li>
		            <li class="page-item"><a class="page-link" href="#">1</a></li>
		            <li class="page-item"><a class="page-link" href="#">2</a></li>
		            <li class="page-item"><a class="page-link" href="#">3</a></li>
		            <li class="page-item">
		                <a class="page-link" href="#" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		                </a>
		            </li>
		        </ul>
		    </div>
		    <!-- 글 작성 버튼 -->
            <div class="col-sm-3 col-md-2" id="goToWrite">
                <a href="write.jsp" ><button class="btn btn-sm btn-secondary" id="goToWriteBtn" type="button"><i class="fa fa-solid fa-pen"></i> 글작성</button></a>
            </div>
	    </div>
    </div>
    
    <!-- 검색 폼 -->
    <div class="container-md" id="searchFormBox">
		<form class="search-form">
    		<fieldset>
        		<select class="form-select-sm" name="field" style="width:80px;">
	           		<option value="boardTitle">제목</option>
	           		<option value="userId">작성자</option>
       			</select> 		
       			<input type="text" name="query" value="" style="width: 150px;"/>
				<input class="btn btn-sm btn-secondary" type="submit" value="검색" />
           </fieldset>
       </form>
   </div>

	<!-- js setting -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
</body>
</html>