<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/board.css">

<!-- User Management List Table -->
<div class="container-md py-5">
	<div class="row">
		<div class="fw-bold h4 mb-4 col-12">
			<a href="${pageContext.request.contextPath }/admin/userManagement">회원
				관리</a>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr class="vertical-align">
						<th style="width: 15%" class="text-center listDate"><i
							class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
						<th>user ID</th>
						<th>user Email</th>
						<th class="text-center"><i
							class="fa fa-solid fa-user fa-lg vertical-align"></i></th>
						<th style="width: 5%" class="text-center"><i
							class="fa fa-solid fa-flag vertical-ailgn fa-lg"></i></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${users }">
						<tr>
							<td class="userDate text-muted text-center"><fmt:formatDate
									value="${u.userDate }" pattern="yyyy-MM-dd" /></td>
							<td class="userId">${u.userId }</td>
							<td class="userEmail">${u.userEmail }</td>
							<td class="boardWriter fw-bold text-center"><span
								class="userMenuPointer userMenuClick"
								onclick="openUserMenu('${u.userId }', '${u.userId }')">${u.userNickname }
									<span id="boardId${u.userId }"
									class="boardIdAll position-relative"></span>
							</span></td>
							<td class="userReport text-muted text-center">${u.userReport }</td>
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
			<a href="${pageContext.request.contextPath }/admin/userManagement"><i
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
						href="?ct=${category.ct }&f=${param.f }&q=${param.q }&p=${firstPage - 5 }"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${(firstPage + i) <= lastPage }">
						<li class="page-item"><a
							class="page-link ${(page==(firstPage+i))?'text-warning':'' }"
							href="?ct=${category.ct }&?f=${param.f }&q=${param.q}&p=${firstPage + i}">${firstPage + i }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${firstPage + 4 < lastPage }">
					<li class="page-item"><a class="page-link"
						href="?ct=${category.ct }&?f=${param.f }&q=${param.q }&p=${firstPage + 5 }"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>

	</div>
</div>

<!-- Search Form -->
<div class="container-md mb-5 mt-2" id="searchFormBox">
	<form class="search-form">
		<fieldset>
			<select class="form-select-sm" name="f" style="width: 80px;">
				<option ${param.f == "userNickname"?"selected":"" }
					value="userNickname">닉네임</option>
				<option ${param.f == "userId"?"selected":"" } value="userId">아이디</option>
				<option ${param.f == "userEmail"?"selected":"" } value="userEmail">이메일</option>
			</select> <input type="text" name="q" value="${param.q }"
				style="width: 150px;" /> <input type="submit"
				class="btn btn-sm btn-secondary" value="검색" />
		</fieldset>
	</form>
</div>