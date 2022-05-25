<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- detail content  -->
	<div class="fw-bold h4 mb-4 col-12 container-md pt-5">${categoryKor }</div>
	<div class="container-md border p-3">
		<div class="row">
			<div class="col12 pb-3 border-bottom fw-bold" id="detailTitle">${boardView.boardTitle }</div>
			<div class="col-7 p-3 border-bottom userMenu">
				<span class="userMenuPointerDetail"><img alt="baduk" src="/img/baduk.png" width="25" height="25"> ${boardView.userId }</span>
				<div class="position-relative">
					<ul class="userMenuBoxDetail">
	               		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
	               		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
	               	</ul>
				</div>
			</div>
			<div class="col-3 p-3  border-bottom text-muted text-right"><fmt:formatDate value="${boardView.boardDate }" pattern="yyyy-MM-dd"/></div>
			<div class="col-2 p-3  text-center border-bottom text-muted"><i class="fa fa-solid fa-eye fa-lg vertical-align"></i> ${boardView.boardHit }</div>
			<div class="col-12 px-3 py-5">
				${boardView.boardContent }
			</div>
			<div class="col-6 text-right my-4" id="likeIconBox"><i class="fa fa-solid fa-thumbs-up fa-2x"></i>  ${boardView.likeCount }</div>
			<div class="col-6 my-4" id="dislikeIconBox"><i class="fa fa-solid fa-thumbs-down fa-2x"></i>  ${boardView.dislikeCount }</div>
			<div class="col-12 my-4 text-right px-5">
				<a href="/detail/updateDetail?id=${boardView.boardId }"><button class="btn btn-secondary lUDBtn mx-2">수정</button></a>
            	<a href="/detail/deleteDetail?id=${boardView.boardId }&ct=${boardView.boardCategory}"><button class="btn btn-secondary lUDBtn">삭제</button></a>
			</div>
		</div>
	</div>
	
	<!-- post comment -->
	<div class="container-md border p-3 my-5">
		<div class="mt-2 mb-4 fw-bold" id="postCommentText">댓글 </div>
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
		<div class="mt-2 mb-4 fw-bold" id="commentList">댓글 목록</div>
		<div class="row">
			<c:forEach var="c" items="${comments }">
			<div class="col-6 p-3 border-bottom border-top">
			<span class="userMenuPointerDetail"><img alt="baduk" src="/img/baduk.png" width="25" height="25"> ${c.userId }</span>
			<div class="position-relative">
				<ul class="userMenuBoxDetail">
               		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
               		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
               	</ul>
			</div>
			</div>
			<div class="col-6 p-3  border-bottom text-muted text-right"><fmt:formatDate value="${c.commentDate}" pattern="yyyy-MM-dd"/></div>
			<div class="col-12 p-3">
				${c.commentContent }
			</div>
			<c:if test="${c.userId == user.userId }">
				<div class="text-right col-12 fw-bold text-muted" id="deleteComment">삭제</div>
			</c:if>
			</c:forEach>
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
		                    		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
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
			<div class="col-sm-1 col-md-1" id="goToList"><a href="/board/${categoryEng }"><i class="fa fa-solid fa-list fa-2x"></i></a></div>
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
	    </div>
    </div>