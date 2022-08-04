<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/detail.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myOwnDetail.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- detail content  -->
<div class="fw-bold h4 mb-4 col-12 container-md pt-5">
	<a href="${pageContext.request.contextPath }/board/myOwnBoard">나만의 게시판</a>
</div>
<div class="container-md border p-3">
	<div class="row">
		<sec:authentication property="principal.username" var="userId" />
		<input type="hidden" value="${board.myBoardId }" id="boardId"
			name="boardId"> <input type="hidden" value="${userId }"
			id="userId" name="userId"> <input type="hidden"
			value="${detailsPage }" id="detailsPage" name="detailsPage">

		<div class="col-9 pb-3 border-bottom fw-bold" id="detailTitle">${board.myBoardTitle }</div>
		<div class="col-3 pb-3  border-bottom text-muted text-right">${board.myBoardDate }</div>
		<div class="col-12 px-3 py-5">${board.myBoardContent }</div>
		<c:if test="${board.userId == userId }">
			<div class="col-12 my-4 text-right px-5">
				<a href="${pageContext.request.contextPath }/detail/updateMyDetail?id=${board.myBoardId }"><button
						class="btn btn-secondary lUDBtn mx-2">수정</button></a> <a
					href="/detail/deleteMyDetail?id=${board.myBoardId }"><button
						class="btn btn-secondary lUDBtn">삭제</button></a>
			</div>
		</c:if>
	</div>
</div>

<!-- list under detail view -->
<div class="container-md py-5">
	<div class="row">
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr class="vertical-align">
						<th style="width: 10%" class="text-center listDate"><i
							class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
						<th style="width: 65%"></th>
					</tr>
				</thead>
				<tbody id="boards">
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- about list  -->
<div class="container-md my-4">
	<div class="row">
		<!-- go to list  -->
		<div class="col-sm-1 col-md-1" id="goToList">
			<a href="${pageContext.request.contextPath }/board/myOwnBoard"><i class="fa fa-solid fa-list fa-2x"></i></a>
		</div>
		<!-- pagination -->
		<c:set var="boardPage" value="${(empty boardPage)?1:boardPage }" />
		<c:set var="firstBoardPage" value="${boardPage - (boardPage - 1) % 5}" />
		<c:set var="lastBoardPage"
			value="${ fn:substringBefore(Math.ceil(boardCount/10), '.') }" />

		<div aria-label="Page navigation example" class="col-sm-8 col-md-9"
			id="underListPagination">
			<ul class="pagination pagination-sm justify-content-center">
				<c:if test="${firstBoardPage > 1 }">
					<li class="page-item">
						<div class="page-link boardPage listPage${firstBoardPage+i }"
							onclick="getBoards(${firstBoardPage - 5})" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</div>
					</li>
				</c:if>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(firstBoardPage + i) <= lastBoardPage }">
						<li class="page-item"><span
							class="page-link boardPage listPage${firstBoardPage+i }"
							onclick="getBoards(${firstBoardPage + i })">${firstBoardPage + i }</span></li>
					</c:if>
				</c:forEach>
				<c:if test="${firstBoardPage + 4 < lastBoardPage }">
					<li class="page-item">
						<div class="page-link boardPage"
							onclick="getBoards(${firstBoardPage + 5})" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</div>
					</li>
				</c:if>
			</ul>
		</div>

		<!-- 글 작성 버튼 -->
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