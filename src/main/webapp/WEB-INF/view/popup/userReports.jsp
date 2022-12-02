<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="cotainer-fluid popupHeader">${user.userNickname }님이 신고받은 내역</div>
<!-- List Who Report User -->
<div class="row">
	<div class="tableBox">
		<table class="table">
			<thead class="table-secondary">
				<tr class="vertical-align">
					<th class="text-center listDate"><i
						class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
					<th>reportedUser</th>
					<th>reporter</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${reports }">
					<tr>
						<td class="boardDate text-muted text-center"><fmt:formatDate
								value="${r.reportDate }" pattern="yyyy-MM-dd" /></td>
						<td class="fw-bold"><a href="${pageContext.request.contextPath }/popup/userReportDetail?id=${r.reportId }&p=${param.p}">${r.reportedUser}</a></td>
						<td>${r.reporter }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
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
				href="?userId=${user.userId }&p=${firstPage - 5 }"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
		</c:if>
		<c:forEach var="i" begin="0" end="4">
			<c:if test="${(firstPage + i) <= lastPage }">
				<li class="page-item"><a
					class="page-link ${(page==(firstPage+i))?'text-warning':'' }"
					href="?userId=${user.userId }&p=${firstPage + i}">${firstPage + i }</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${firstPage + 4 < lastPage }">
			<li class="page-item"><a class="page-link"
				href="?userId=${user.userId }&p=${firstPage + 5 }" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
			</a></li>
		</c:if>
	</ul>
</div>