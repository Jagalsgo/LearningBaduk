<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/message.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/message.js"></script>
<sec:authorize access="isAuthenticated">
	<sec:authentication property="principal.username" var="userId" />
	<input type="hidden" value="${userId }" id="userId" name="userId">
</sec:authorize>
<div class="cotainer-fluid popupHeader">쪽지 보내기</div>
<div class="headerItem mb-4" id="headerList">
	<div class="container-fluid py-3">
		<span class="fw-bold mb-2"> <a href="${pageContext.request.contextPath }/popup/receivedMessage">받은쪽지함</a>
		</span> <span class="fw-bold mb-2 mx-3"> <a href="${pageContext.request.contextPath }/popup/sentMessage">보낸쪽지함</a>
		</span> <span class="fw-bold mb-2"> <a href="${pageContext.request.contextPath }/popup/sendMessage"
			class="text-primary">쪽지보내기</a>
		</span>
	</div>
</div>
<div class="my-2 mx-3 fw-bold">쪽지를 받을 회원 닉네임</div>
<div class="mx-3 mb-3">
	<input type="text" value="${user.userNickname }" id="receiverNickname">
	<input type="hidden" value="${user.userId }" id="receiver">
</div>
<div class="my-2 mx-3 fw-bold">제목</div>
<div class="mx-3">
	<input type="text" id="messageTitle">
</div>
<div class="my-2 mx-3 fw-bold">내용</div>
<div class="mx-3">
	<textarea style="width: 300px; height: 200px;" id="messageContent"></textarea>
</div>
<div class="my-3 mx-3">
	<button class="btn btn-secondary btn-sm" id="sendMessagePostBtn"
		onclick="sendMessagePost()">보내기</button>
</div>