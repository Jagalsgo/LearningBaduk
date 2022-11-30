<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="cotainer-fluid popupHeader mb-4">신고 내용</div>
<div class="my-2 mx-3 fw-bold">신고 당한 유저</div>
<div class="mx-3 mb-4">
	<input type="text" value="${report.reportedUser }" disabled>
</div>
<div class="my-2 mx-3 fw-bold">신고한 유저</div>
<div class="mx-3 mb-4">
	<input type="text" value="${report.reporter }" disabled>
</div>
<div class="my-2 mx-3 fw-bold">신고 내용</div>
<div class="mx-3">
	<textarea style="width: 300px; height: 200px;" id="reportContent"
		disabled>${report.reportContent }</textarea>
</div>
<!-- Go To List  -->
<div class="m-4" id="goToList">
	<a
		href="${pageContext.request.contextPath }/popup/userReports?userId=${report.reportedUser }&p=${page}"><i
		class="fa fa-solid fa-list fa-2x"></i></a>
</div>