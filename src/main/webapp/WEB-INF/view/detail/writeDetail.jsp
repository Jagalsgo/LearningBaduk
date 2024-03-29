<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/writeDetail.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/writeDetail.js"></script>

<!-- Write Detail Form -->
<div class="fw-bold h4 mb-4 col-12 container-md pt-5">${category.categoryKor }
	- 글 작성</div>
<div class="container-md border px-5 pt-4" id=writeFormBox>
	<form action="${pageContext.request.contextPath }/detail/writeDetail"
		method="post" id="writeForm">
		<div class="form-group mb-5">
			<label for="writeTitle" class="my-3 fw-bold" id="wirteTitleLabel">제목</label>
			<input type="text" class="form-control" placeholder="제목"
				name="writeTitle" maxlength="50" id="writeTitle">
		</div>
		<div class="form-group">
			<label for="ckeditor" class="my-2 fw-bold" id="ckeditorLabel">내용</label>
			<textarea class="form-control my-3" placeholder="내용"
				name="writeContent" maxlength="2048" id="ckeditor"></textarea>
		</div>
		<input type="hidden" name="ct" value="${category.ct }">
		<div class="row my-5">
			<div class="col-6" id="goToList">
				<a
					href="${pageContext.request.contextPath }/board/board?ct=${category.ct }"><i
					class="fa fa-solid fa-list fa-2x"></i></a>
			</div>
			<div class="form-group col-6 text-right">
				<input type="submit" class="btn btn-secondary" value="글 작성">
			</div>
		</div>
	</form>
</div>
