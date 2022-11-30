<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/home.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/home.js"></script>
	
<!-- Boards List (5) -->
<div class="container-md py-5">
	<div class="row">
		<div class="fw-bold h3 mb-4 col-12">Home</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=free">자유게시판</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=free">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.free }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=free&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=rule">룰</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=rule">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.rule }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=rule&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=pattern">정석</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=pattern">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.pattern }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=pattern&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=opening">포석</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=opening">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.opening }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=opening&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=endGame">끝내기</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=endGame">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.endGame }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=endGame&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=lifeDeath">사활</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=lifeDeath">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.lifeDeath }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=lifeDeath&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=quetion">바둑Q&A</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=quetion">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.quetion }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=quetion&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=schedule">프로바둑일정</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=schedule">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.schedule }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=schedule&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tableBox">
			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="boardName"><a
							href="${pageContext.request.contextPath }/board/board?ct=notice">공지</a></th>
						<th class='moreBoard'><a
							href="${pageContext.request.contextPath }/board/board?ct=notice">더보기▷</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${map.notice }">
						<tr>
							<td class="boardTitle"><a
								href="/detail/detail?ct=notice&id=${b.boardId }">${b.boardTitle }
									(${b.commentCount })</a></td>
							<td class="boardWriter"><div class="mx-3 text-muted">${b.userNickname }</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>