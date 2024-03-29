<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/board.css">

<!-- Board List -->
<div class="container-md py-5">
	<div class="row">
		<div class="fw-bold h4 mb-4 col-12">
			<a href="${pageContext.request.contextPath }/board/myOwnBoard">나만의
				게시판</a>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr class="vertical-align">
						<th style="width: 10%" class="text-center listDate"><i
							class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
						<th style="width: 65%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${boards }">
						<tr>
							<td class="boardDate text-muted text-center">${b.myBoardDate }</td>
							<td class="boardTitle "><a
								href="${pageContext.request.contextPath }/detail/myOwnDetail?id=${b.myBoardId }">${b.myBoardTitle }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- About List  -->
<div class="container-md my-4">
	<div class="row">
		<!-- Go To List  -->
		<div class="col-sm-1 col-md-1" id="goToList">
			<a href="${pageContext.request.contextPath }/board/myOwnBoard"><i
				class="fa fa-solid fa-list fa-2x"></i></a>
		</div>
		<!-- Pagination -->
		<c:set var="page" value="${(empty param.p)?1:param.p }" />
		<c:set var="firstPage" value="${page - (page - 1) % 5}" />
		<c:set var="lastPage"
			value="${ fn:substringBefore(Math.ceil(pageCount/10), '.') }" />

		<div aria-label="Page navigation example" class="col-sm-8 col-md-9">
			<ul class="pagination pagination-sm justify-content-center">
				<c:if test="${firstPage > 1 }">
					<li class="page-item"><a class="page-link"
						href="?q=${param.q }&p=${firstPage - 5 }" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(firstPage + i) <= lastPage }">
						<li class="page-item"><a
							class="page-link ${(page==(firstPage+i))?'text-warning':'' }"
							href="?q=${param.q}&p=${firstPage + i}">${firstPage + i }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${firstPage + 4 < lastPage }">
					<li class="page-item"><a class="page-link"
						href="?q=${param.q }&p=${firstPage + 5 }" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>

		<!-- Write Board -->
		<div class="col-sm-3 col-md-2" id="goToWrite">
			<form action="/detail/writeMyDetail">
				<button class="btn btn-sm btn-secondary" id="goToWriteBtn"
					type="submit">
					<i class="fa fa-solid fa-pen"></i> 글작성
				</button>
			</form>
		</div>
	</div>
</div>

<!-- Search Form -->
<div class="container-md mb-5 mt-2" id="searchFormBox">
	<form class="search-form">
		<fieldset>
			<label for="query" class="fw-bold">제목</label> <input type="text"
				class="mx-3" name="q" id="query" value="${param.q }"
				style="width: 150px;" /> <input type="submit"
				class="btn btn-sm btn-secondary" value="검색" />
		</fieldset>
	</form>
</div>