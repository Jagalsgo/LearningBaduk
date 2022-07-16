<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="/css/detail.css">
<script type="text/javascript" src="/js/detail.js"></script>
<!-- detail content  -->
<div class="fw-bold h4 mb-4 col-12 container-md pt-5">
	<a href="/board/board?ct=${category.ct }">${category.categoryKor }</a>
	<a href="/detail/detail?id=57#commentIdIs108">skull</a>
</div>
<div class="container-md border p-3">
	<div class="row">
		<input type="hidden" value="${boardView.userId }" id="boardUserId">
		<input type="hidden" value="${boardView.boardId }" id="boardId"
			name="boardId"> <input type="hidden"
			value="${category.categoryBoard }" id="category" name="category">
		<input type="hidden" value="${category.ct }" id="categoryCt"
			name="categoryCt"> <input type="hidden"
			value="${detailsPage }" id="detailsPage" name="detailsPage">
		<sec:authorize access="isAuthenticated">
			<sec:authentication property="principal.username" var="userId" />
			<input type="hidden" value="${userId }" id="userId" name="userId">
		</sec:authorize>
		<sec:authorize access="isAnonymous">
			<input type="hidden" value="-1" id="userId" name="userId">
		</sec:authorize>


		<div class="col12 pb-3 border-bottom fw-bold" id="detailTitle">${boardView.boardTitle }</div>
		<div class="col-7 p-3 border-bottom userMenu">
			<span class="userMenuPointerDetail"> <c:choose>
					<c:when test="${boardView.imgPath == null }">
						<span class="userMenuClick userMenuPointer"
							onclick="openUserMenu(${boardView.boardId}, '${boardView.userId }')">
							<img alt="user" src="/img/user.png" width="25" height="25">
							${boardView.userNickname } <span
							id="boardId${boardView.boardId }"
							class="boardIdAll position-relative"></span>
						</span>
					</c:when>
					<c:otherwise>
						<span class="userMenuClick userMenuPointer"
							onclick="openUserMenu(${boardView.boardId}, '${boardView.userId }')">
							<img alt="user" src="${boardView.imgPath }" width="25"
							height="25"> ${boardView.userNickname } <span
							id="boardId${boardView.boardId }"
							class="boardIdAll position-relative"></span>
						</span>
					</c:otherwise>
				</c:choose>
			</span>
		</div>
		<div class="col-3 p-3  border-bottom text-muted text-right">${boardView.boardDate }</div>
		<div class="col-2 p-3  text-center border-bottom text-muted">
			<i class="fa fa-solid fa-eye fa-lg vertical-align"></i>
			${boardView.boardHit }
		</div>
		<div class="col-12 px-3 py-5">${boardView.boardContent }</div>
		<div class="col-6 text-right my-4" id="likeIconBox">
			<i class="fa fa-solid fa-thumbs-up fa-2x likeDislikeImg"
				onclick="likeBtnClick(${boardView.boardId})" id="likeBtn"></i><span
				id="likeCount"> ${boardView.likeCount }</span>
		</div>
		<div class="col-6 my-4" id="dislikeIconBox">
			<i class="fa fa-solid fa-thumbs-down fa-2x likeDislikeImg"
				onclick="dislikeBtnClick(${boardView.boardId})" id="dislikeBtn"></i><span
				id="dislikeCount"> ${boardView.dislikeCount }</span>
		</div>

		<c:choose>
			<c:when test="${boardView.userId == userId }">
				<div class="col-12 my-4 text-right px-5">
					<a
						href="/detail/updateDetail?id=${boardView.boardId }&ct=${category.ct}"><button
							class="btn btn-secondary lUDBtn mx-2">수정</button></a> <a
						href="/detail/deleteDetail?id=${boardView.boardId }&ct=${category.ct}"><button
							class="btn btn-secondary lUDBtn">삭제</button></a>
				</div>
			</c:when>
			<c:otherwise>
				<sec:authorize access="isAnonymous">
					<div class="text-right my-1">
						<input type="button" class="btn btn-danger mx-2" value="신고"
							id="reportNeedLoginBtn">
					</div>
				</sec:authorize>
				<!-- 로그인 후 -->
				<sec:authorize access="isAuthenticated">
					<div class="text-right my-1">
						<button class="btn btn-danger mx-2"
							onclick="reportBoard(${boardView.boardId})" id="reportBoardBtn">신고</button>
					</div>
				</sec:authorize>
			</c:otherwise>

		</c:choose>

	</div>
</div>

<!-- post comment -->
<div class="container-md border p-3 my-5">
	<div class="mt-2 mb-4 fw-bold" id="postCommentText">댓글</div>
	<div class="form-floating form-group">
		<input type="text" class="form-control" id="commentContent"
			name="commentContent"> <label for="commentContent">Comments</label>
	</div>

	<!-- 로그인 전 -->
	<sec:authorize access="isAnonymous">
		<div class="text-right my-1">
			<input type="button" class="btn btn-secondary mt-2" value="작성"
				id="commentNeedLoginBtn">
		</div>
	</sec:authorize>

	<!-- 로그인 후 -->
	<sec:authorize access="isAuthenticated">
		<div class="text-right my-1">
			<button class="btn btn-secondary mt-2" onclick="postComment()"
				id="postCommentBtn">작성</button>
		</div>
	</sec:authorize>

</div>

<!-- comment list -->
<div class="container-md border p-3 my-5">
	<div class="mt-2 mb-4 fw-bold" id="commentList">댓글 목록
		(${boardView.commentCount })</div>
	<div class="row" id="comments"></div>
	<!-- comment pagination -->
	<input type="hidden" id="commentCountJs"
		value="${boardView.commentCount }">

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
						<th style="width: 5%"><i
							class="fa fa-solid fa-thumbs-up fa-lg vertical-align"></i></th>
						<th></th>
						<th style="width: 15%" class="text-center"><i
							class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
						<th style="width: 5%" class="text-center"><i
							class="fa fa-solid fa-eye fa-lg vertical-align"></i></th>
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
			<a href="/board/board?ct=${category.ct }"><i
				class="fa fa-solid fa-list fa-2x"></i></a>
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
						<div class="page-link boardPage"
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
		<sec:authorize access="isAuthenticated">
			<div class="col-sm-3 col-md-2" id="goToWrite">
				<form action="/detail/writeDetail">
					<input type="hidden" id="writeCt" name="writeCt"
						value="${category.ct }">
					<button class="btn btn-sm btn-secondary" id="goToWriteBtn"
						type="submit">
						<i class="fa fa-solid fa-pen"></i> 글작성
					</button>
				</form>
			</div>
		</sec:authorize>

	</div>
</div>