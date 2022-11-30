<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/message.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/message.js"></script>
<div class="cotainer-fluid popupHeader">보낸 쪽지</div>
<div class="headerItem mb-4" id="headerList">
	<div class="container-fluid py-3">
		<span class="fw-bold mb-2"> <a
			href="${pageContext.request.contextPath }/popup/receivedMessage">받은쪽지함</a>
		</span> <span class="fw-bold mb-2 mx-3"> <a
			href="${pageContext.request.contextPath }/popup/sentMessage"
			class="text-primary">보낸쪽지함</a>
		</span> <span class="fw-bold mb-2"> <a
			href="${pageContext.request.contextPath }/popup/sendMessage">쪽지보내기</a>
		</span>
	</div>
</div>
<!-- Sent Message Detail Content -->
<div class="row p-3 mb-4 messageDetailBox">
	<div class="col-12 fw-bold mb-3 messageDetailTitle">${messageView.messageTitle }</div>
	<div class="col-12 my-2">
		<span style="font-size: 14px;">받은 사람 :</span> <span
			class="userMenuPointer userMenuClick fw-bold"
			onclick="openUserMenu(${messageView.messageId}, '${messageView.receiver }')">${messageView.receiverNickname}
			<span id="boardId${messageView.messageId }"
			class="boardIdAll position-relative"></span>
		</span>
	</div>
	<div class="col-12 text-muted">
		<fmt:formatDate value="${messageView.messageSendDate }"
			pattern="yyyy-MM-dd" />
	</div>
	<div class="col12 my-4 messageDetailContent py-4">${messageView.messageContent }</div>
	<a
		href="/popup/deleteMessageDetail?id=${messageView.messageId }&go=sentMessage"
		class="text-right"><button class="btn btn-secondary btn-sm UDBtn ">삭제</button></a>
</div>

<!-- Go To List  -->
<div class="m-4" id="goToList">
	<a
		href="${pageContext.request.contextPath }/popup/sentMessage?p=${page}"><i
		class="fa fa-solid fa-list fa-2x"></i></a>
</div>