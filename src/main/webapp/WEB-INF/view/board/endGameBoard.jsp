<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-md py-5">
		<div class="row">
			<div class="fw-bold h4 mb-4 col-12">바둑 끝내기</div>
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
		                	<c:forEach var="b" items="${boards }">
			                    <td class="boardDate text-muted text-center"><fmt:formatDate value="${b.boardDate }" pattern="yy-MM-dd"/></td>
			                    <td class="boardLike fw-bold">${b.likeCount - b.dislikeCount}</td>
			                    <td class="boardTitle ">${b.boardTitle }</td>
			                    <td class="boardWriter fw-bold text-center">
			                    	<div class="position-relative userMenuPointer">${b.userNickname }
			                    	
			                    	</div>
			                    </td>
			                    <td class="boardHit text-muted text-center">${b.boardHit }</td>
		                	</c:forEach>
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
			<c:set var="page" value="${(empty param.p)?1:param.p }" />
			<c:set var="firstPage" value="${page - (page - 1) % 5}" />
			<c:set var="lastPage" value="${ fn:substringBefore(Math.ceil(pageCount/10), '.') }" />
			
			<div aria-label="Page navigation example" class="col-sm-8 col-md-9" id="pagination">
		        <ul class="pagination pagination-sm justify-content-center">
		        	<c:if test="${firstPage > 1 }">
			            <li class="page-item">
			                <a class="page-link" href="#" aria-label="Previous">
			                <span aria-hidden="true">&laquo;</span>
			                </a>
			            </li>
		            </c:if>
		            <c:forEach var="i" begin="0" end="4">
			            <c:if test="${(firstPage + i) <= lastPage } ">
				            <li class="page-item"><a class="page-link" href="?f=${param.f }&q=${param.q}&p=${firstPage + i}">${firstPage + i }</a></li>
			            </c:if>
		            </c:forEach>
		            <c:if test="${firstPage + 4 < lastPage }">
			            <li class="page-item">
			                <a class="page-link" href="#" aria-label="Next">
			                <span aria-hidden="true">&raquo;</span>
			                </a>
			            </li>
		            </c:if>
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
        		<select class="form-select-sm" name="f" style="width:80px;">
	           		<option ${param.f == "boardTitle"?"selected":"" } value="boardTitle">제목</option>
	           		<option ${param.f == "userNickname"?"selected":"" } value="userNickname">작성자</option>
       			</select> 		
       			<input type="text" name="q" value="${param.q }" style="width: 150px;"/>
				<input type="submit" class="btn btn-sm btn-secondary" />
           </fieldset>
       </form>
   </div>