<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/header.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/9e1a390ee4.js"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/header.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/ckeditor5/build/ckeditor.js"></script>
<title>Learning Baduk</title>

<style>
.ck-editor__editable {
	min-height: 350px;
}
</style>
</head>
<body>

	<!-- Header  -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- Main  -->
	<tiles:insertAttribute name="main"></tiles:insertAttribute>

	<script>
	
		ClassicEditor
			.create( document.querySelector( '#ckeditor' ), {
				ckfinder: {
			        uploadUrl: '${pageContext.request.contextPath }/file/imgUpload'
				},
				mediaEmbed: {
				      previewsInData: true
				}
			} )
			.catch( error => {
			    
			} );
			
	</script>

</body>
</html>