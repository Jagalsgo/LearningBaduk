<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="/css/board.css">
<div class="container-md py-5">
		<div class="row">
			<div class="fw-bold h4 mb-4 col-12"><a href="/board/board?ct=${category.ct }">${category.categoryKor }</a></div>
			<div class="tableBox">
				<table class="table">
		            <thead class="table-secondary">
		                <tr class="vertical-align">
		                    <th style="width:10%" class="text-center listDate"><i class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
		                    <th style="width:5%"><i class="fa fa-solid fa-thumbs-up fa-lg vertical-align"></i></th>
		                    <th style="width: 65%"></th>
		                    <th style="width:15%" class="text-center"><i class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
		                    <th style="width:5%" class="text-center"><i class="fa fa-solid fa-eye fa-lg vertical-align"></i></th>
		                </tr>
		            </thead>
		            <tbody>
		                	<c:forEach var="b" items="${boards }">
			            	    <tr>
				                    <td class="boardDate text-muted text-center">${b.boardDate }</td>
				                    <td class="boardLike fw-bold">${b.likeCount - b.dislikeCount}</td>
				                    <td class="boardTitle "><a href="/detail/detail?ct=${category.ct }&id=${b.boardId }">${b.boardTitle }  <span class="text-muted">(${b.commentCount })</span></a></td>
				                    <td class="boardWriter fw-bold text-center">
				                    	<div class="position-relative userMenuPointer">${b.userNickname }
				                    		<ul class="userMenuBox">
					                    		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
					                    		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
					                    	</ul>
				                    	</div>
				                    </td>
				                    <td class="boardHit text-muted text-center">${b.boardHit }</td>
			         	       </tr>
		                	</c:forEach>
		            </tbody>
		        </table>
	        </div>	
		</div>
	</div>
	
	<!-- about list  -->
	<div class="container-md my-4">
		<div class="row">
			<!-- go to list  -->
			<div class="col-sm-1 col-md-1" id="goToList"><a href="/board/board?ct=${category.ct }"><i class="fa fa-solid fa-list fa-2x"></i></a></div>
			<!-- pagination -->
			<c:set var="page" value="${(empty param.p)?1:param.p }" />
			<c:set var="firstPage" value="${page - (page - 1) % 5}" />
			<c:set var="lastPage" value="${ fn:substringBefore(Math.ceil(pageCount/10), '.') }" />
			
			<div aria-label="Page navigation example" class="col-sm-8 col-md-9">
		        <ul class="pagination pagination-sm justify-content-center">
		        	<c:if test="${firstPage > 1 }">
			            <li class="page-item">
			                <a class="page-link" href="?ct=${category.ct }&f=${param.f }&q=${param.q }&p=${firstPage - 5 }" aria-label="Previous">
			                <span aria-hidden="true">&laquo;</span>
			                </a>
			            </li>
		            </c:if>
		            <c:forEach var="i" begin="0" end="4">
			            <c:if test="${(firstPage + i) <= lastPage }">
				            <li class="page-item"><a class="page-link ${(param.p==(firstPage+i))?'text-warning':'' }" href="?ct=${category.ct }&?f=${param.f }&q=${param.q}&p=${firstPage + i}">${firstPage + i }</a></li>
			            </c:if>
		            </c:forEach>
		            <c:if test="${firstPage + 4 < lastPage }">
			            <li class="page-item">
			                <a class="page-link" href="?ct=${category.ct }&?f=${param.f }&q=${param.q }&p=${firstPage + 5 }" aria-label="Next">
			                <span aria-hidden="true">&raquo;</span>
			                </a>
			            </li>
		            </c:if>
		        </ul>
		    </div>
		    
		    <!-- 글 작성 버튼 -->
		    <sec:authorize access="isAuthenticated">
	           <div class="col-sm-3 col-md-2" id="goToWrite">
	           		<form action="/detail/writeDetail">
	           			<input type="hidden" id="writeCt" name="writeCt" value="${category.ct }">
	           			<button class="btn btn-sm btn-secondary" id="goToWriteBtn" type="submit"><i class="fa fa-solid fa-pen"></i> 글작성</button>
	           		</form>
	           </div>
		    </sec:authorize>
	    </div>
    </div>
    
    <!-- 검색 폼 -->
    <div class="container-md mb-5 mt-2" id="searchFormBox">
		<form class="search-form">
    		<fieldset>
        		<select class="form-select-sm" name="f" style="width:80px;">
	           		<option ${param.f == "boardTitle"?"selected":"" } value="boardTitle">제목</option>
	           		<option ${param.f == "userNickname"?"selected":"" } value="userNickname">작성자</option>
       			</select> 		
       			<input type="text" name="q" value="${param.q }" style="width: 150px;"/>
       			<input type="hidden" name="ct" value="${category.ct }">
				<input type="submit" class="btn btn-sm btn-secondary" value="검색" />
           </fieldset>
       </form>
   </div>