<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/message.css">
<script type="text/javascript" src="/js/message.js"></script>
<div class="cotainer-fluid popupHeader">쪽지 보내기</div>
<div class="headerItem mb-4" id="headerList">
	<div class="container-fluid py-3">
		<span class="fw-bold mb-2"> <a href="/popup/receivedMessage">받은쪽지함</a>
		</span> <span class="fw-bold mb-2 mx-3"> <a
			href="/popup/sentMessage">보낸쪽지함</a>
		</span> <span class="fw-bold mb-2"> <a href="/popup/sendMessage"
			class="text-primary">쪽지보내기</a>
		</span>
	</div>
</div>
<div class="my-2 mx-3 fw-bold">쪽지를 받을 회원 닉네임</div>
<div class="mx-3 mb-3">
	<input type="text" value="${user.userNickname }" id="receiverNickname">
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