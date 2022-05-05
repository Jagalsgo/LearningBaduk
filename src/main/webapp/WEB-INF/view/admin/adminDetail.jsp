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
    <link rel="stylesheet" href="/css/detail.css">
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
	<!-- detail content  -->
	<div class="fw-bold h4 mb-4 col-12 container-md pt-5">자유게시판</div>
	<div class="container-md border p-3">
		<div class="row">
			<div class="col12 pb-3 border-bottom fw-bold" id="detailTitle">detailTitle Man</div>
			<div class="col-7 p-3 border-bottom">
			<span class="userMenuPointerDetail"><img alt="baduk" src="/img/baduk.png" width="25" height="25"> writerMan</span>
				<div class="position-relative">
					<ul class="userMenuBoxDetail">
	               		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
	               		<li><a href="s"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></li>
	               		<li><a href="sdfds"><i class="fa fa-solid fa-ban"> 회원 제거</i></a></li>
	               	</ul>
				</div>
			</div>
			<div class="col-3 p-3  border-bottom text-muted text-right">22-11-11</div>
			<div class="col-2 p-3  text-center border-bottom text-muted"><i class="fa fa-solid fa-eye fa-lg vertical-align"></i> 12</div>
			<div class="col-12 px-3 py-5">
				Lorem Ipsum is simply dummy text of the printing and typesetting industry.
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type specimen book.
				It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
				It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
				and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum
			</div>
			<div class="col-6 text-right my-4" id="likeIconBox"><i class="fa fa-solid fa-thumbs-up fa-2x"></i>  41</div>
			<div class="col-6 my-4" id="dislikeIconBox"><i class="fa fa-solid fa-thumbs-down fa-2x"></i>  12</div>
			<div class="col-12 my-4 text-right px-5">
				<a href="/list.jsp"><button class="btn btn-secondary lUDBtn mx-2">수정</button></a>
            	<a href="/update.jsp"><button class="btn btn-secondary lUDBtn">삭제</button></a>
			</div>
		</div>
	</div>
	
	<!-- post comment -->
	<div class="container-md border p-3 my-5">
		<div class="mt-2 mb-4 fw-bold" id="postCommentText">댓글 작성하기</div>
		<form action="postComment.jsp" id="commentForm">
	        <div class="form-floating form-group">
	            <input type="textarea" class="form-control" id="commentContent">
	            <label for="commentContent">Comments</label>
	        </div>
	        <div class="form-group text-right my-1">
	            <input type="submit" class="btn btn-secondary mt-2" value="작성" id="commentSubmitBtn">
	        </div>
	    </form>
	</div>
	
	<!-- comment list -->
	<div class="container-md border p-3 my-5">
		<div class="mt-2 mb-4 fw-bold" id="commentList"><input type="checkbox" value="deleteAllComment"> 댓글 목록</div>
		<div class="row">
			<div class="col-6 p-3 border-bottom border-top"><input type="checkbox" value="deleteAllComment">
			<span class=" userMenuPointerDetail"><img alt="baduk" src="/img/baduk.png" width="25" height="25"> writerMan</span>
			<div class="position-relative">
				<ul class="userMenuBoxDetail">
               		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
               		<li><a href="s"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></li>
               		<li><a href="sdfds"><i class="fa fa-solid fa-ban"> 회원 제거</i></a></li>
               	</ul>
			</div>
			</div>
			<div class="col-6 p-3  border-bottom text-muted text-right">22-11-11</div>
			<div class="col-12 p-3">
				Lorem Ipsum is simply dummy text of the printing and typesetting industry.
				Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
				when an unknown printer took a galley of type and scrambled it to make a type specimen book.
				It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
			</div>
			<div class="text-right col-12 fw-bold text-muted" id="deleteComment">삭제</div>
		</div>
		<!-- delete comment Button  -->
		<div class="mt-5 mb-3"" id="deleteCommentBtn">
			<a href="write.jsp" ><button class="btn btn-sm btn-secondary" id="goToWriteBtn" type="button">삭제</button></a>
		</div>
		<!-- comment pagination -->
		<div aria-label="Page navigation example" class="mt-5 mb-3" id="pagination">
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
	</div>
	
	<!-- list under detail view -->
	<div class="container-md py-5">
		<div class="row">
			<div class="tableBox">
				<table class="table">
		            <thead class="table-secondary">
		                <tr class="vertical-align">
		                    <th style="width:10%" class="text-center listDate"><i class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
		                    <th style="width:5%"><i class="fa fa-solid fa-thumbs-up fa-lg vertical-align"></i></th>
		                    <th></th>
		                    <th style="width:15%" class="text-center"><i class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
		                    <th style="width:5%" class="text-center"><i class="fa fa-solid fa-eye fa-lg vertical-align"></i></th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td class="boardDate text-muted text-center">17-08-14</td>
		                    <td class="boardLike fw-bold">12</td>
		                    <td class="boardTitle">this is title is title man</td>
		                    <td class="boardWriter fw-bold text-center">
		                    	<div class="position-relative userMenuPointer">writer
		                    	<ul class="userMenuBox">
		                    		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
		                    		<li><a href="s"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></li>
		                    		<li><a href="sdfds"><i class="fa fa-solid fa-ban"> 회원 제거</i></a></li>
		                    	</ul>
		                    	</div>
		                    </td>
		                    <td class="boardHit text-muted text-center">12</td>
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
    <div class="container-md mb-5" id="searchFormBox">
		<form class="search-form">
    		<fieldset>
        		<select class="form-select-sm" name="field" style="width:80px;">
	           		<option value="listTitle">제목</option>
	           		<option value="userId">작성자</option>
       			</select> 		
       			<input type="text" name="query" value="" style="width: 150px;"/>
				<input class="btn btn-sm btn-secondary" type="submit" value="검색" />
           </fieldset>
       </form>
   </div>
	
</body>
</html>