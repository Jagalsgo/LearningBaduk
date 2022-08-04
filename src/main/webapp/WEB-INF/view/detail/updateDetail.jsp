<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/updateDetail.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/updateDetail.js"></script>
<div class="fw-bold h4 mb-4 col-12 container-md pt-5">글 수정</div>
<div class="container-md border px-5 pt-4" id=updateFormBox>
	<form action="${pageContext.request.contextPath }/detail/updateDetail" method="post" id="updateForm">
		<input type="hidden" name="_method" value="PUT">
		<div class="form-group mb-5">
			<label for="updateTitle" class="my-3 fw-bold" id="updateTitleLabel">제목</label>
			<input type="text" class="form-control" placeholder="제목"
				name="updateTitle" maxlength="50" id="updateTitle"
				value="${boardView.boardTitle }">
		</div>
		<div class="form-group">
			<label for="ckeditor" class="my-2 fw-bold" id="ckeditorLabel">내용</label>
			<textarea class="form-control my-3" placeholder="내용"
				name="updateContent" maxlength="2048" style="height: 350px"
				id="ckeditor">${boardView.boardContent }</textarea>
		</div>
		<input type="hidden" id="id" name="id" value="${boardView.boardId }">
		<input type="hidden" id="ct" name="ct" value="${category.ct }">
		<div class="row my-5">
			<div class="col-6" id="goToList">
				<a href="${pageContext.request.contextPath }/board/board?ct=${category.ct }"><i
					class="fa fa-solid fa-list fa-2x"></i></a>
			</div>
			<div class="form-group col-6 text-right">
				<input type="submit" class="btn btn-secondary" value="글 수정">
			</div>
		</div>
	</form>
</div>