<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container my-5">
	<ul class="list-group">
		<li
			class="list-group-item d-flex justify-content-between align-items-center"><a
			href="${pageContext.request.contextPath }/admin/boardReportList"
			class="fw-bold">신고당한 게시판 내역</a> <span
			class="badge bg-primary rounded-pill">${reportedBoardCount }</span></li>
		<li
			class="list-group-item d-flex justify-content-between align-items-center"><a
			href="${pageContext.request.contextPath }/admin/userReportList"
			class="fw-bold">신고당한 유저 내역</a> <span
			class="badge bg-primary rounded-pill">${reportedUserCount }</span></li>
		<li
			class="list-group-item d-flex justify-content-between align-items-center">
			<a href="${pageContext.request.contextPath }/admin/userManagement"
			class="fw-bold">회원 관리</a> <span class="badge bg-primary rounded-pill"></span>
		</li>
	</ul>
</div>