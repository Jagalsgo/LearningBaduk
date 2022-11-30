<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/message.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/message.js"></script>
<div class="cotainer-fluid popupHeader">받은 쪽지함</div>
<div class="headerItem mb-4" id="headerList">
	<div class="container-fluid py-3">
		<span class="fw-bold mb-2"> <a
			href="${pageContext.request.contextPath }/popup/receivedMessage"
			class="text-primary">받은쪽지함</a>
		</span> <span class="fw-bold mb-2 mx-3"> <a
			href="${pageContext.request.contextPath }/popup/sentMessage">보낸쪽지함</a>
		</span> <span class="fw-bold mb-2"> <a
			href="${pageContext.request.contextPath }/popup/sendMessage">쪽지보내기</a>
		</span>
	</div>
</div>
<!-- Recieved Messages List -->
<div class="row">
	<div class="tableBox">
		<table class="table">
			<thead class="table-secondary">
				<tr class="vertical-align">
					<th style="width: 1%"><input type="checkbox" name="allChk"
						value="allChk" id="allChk"></th>
					<th>제목</th>
					<th class="text-center"><i
						class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${messages }">
					<tr class="messages">
						<td><input type="checkbox" name="chk" value="${m.messageId }"></td>
						<td class="fw-bold"><a
							href="/popup/receivedMessageDetail?id=${m.messageId }&p=${param.p}">${m.messageTitle}</a></td>
						<td class="boardWriter text-center"><span
							class="userMenuPointer userMenuClick"
							onclick="openUserMenu(${m.messageId}, '${m.sender }')">${m.senderNickname}
								<span id="boardId${m.messageId }"
								class="boardIdAll position-relative"></span>
						</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<span><button class="btn btn-sm btn-secondary" id="deleteBtn"
		type="button" onclick="deleteReceivedMessage()">삭제</button></span>

<!-- Pagination -->
<c:set var="page" value="${(empty param.p)?1:param.p }" />
<c:set var="firstPage" value="${page - (page - 1) % 5}" />
<c:set var="lastPage"
	value="${ fn:substringBefore(Math.ceil(messageCount/10), '.') }" />

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
					class="page-link ${(param.p==(firstPage+i))?'text-warning':'' }"
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

<!-- Search Form -->
<div class="container-md mb-5 mt-2" id="searchFormBox">
	<form class="search-form">
		<fieldset>
			<select class="form-select-sm" name="f" style="width: 80px;">
				<option ${param.f == "messageTitle"?"selected":"" }
					value="messageTitle">제목</option>
				<option ${param.f == "senderNickname"?"selected":"" }
					value="senderNickname">보낸 사람</option>
			</select> <input type="text" name="q" value="${param.q }"
				style="width: 150px;" /> <input type="submit"
				class="btn btn-sm btn-secondary" value="검색" />
		</fieldset>
	</form>
</div>