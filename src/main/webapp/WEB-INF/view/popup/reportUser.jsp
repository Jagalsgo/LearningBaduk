<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/reportUser.js"></script>
<div class="cotainer-fluid popupHeader mb-4">유저 신고하기</div>
<div class="my-2 mx-3 fw-bold">신고할 유저</div>
<div class="mx-3 mb-4">
	<input type="text" value="${user.userNickname }" disabled>
	<input type="hidden" value="${user.userId }" id="reportedUser">
</div>
<div class="my-2 mx-3 fw-bold">신고 내용</div>
<div class="mx-3">
	<textarea style="width: 300px; height: 200px;" id="reportContent"></textarea>
</div>
<div class="my-3 mx-3">
	<button class="btn btn-secondary btn-sm" id="reportUserPostBtn"
		onclick="reportUserPost()">신고하기</button>
</div>