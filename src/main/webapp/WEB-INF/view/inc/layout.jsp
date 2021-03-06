<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="/css/common.css">
<link rel="stylesheet" href="/css/header.css">
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/9e1a390ee4.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="/js/header.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/ckeditor5/build/ckeditor.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"
	integrity="sha512-1QvjE7BtotQjkq8PxLeF6P46gEpBRXuskzIVgjFpekzFVF4yjRgrQvTG1MTOJ3yQgvTteKAcO7DSZI92+u/yZw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"
	integrity="sha512-iKDtgDyTHjAitUDdLljGhenhPwrbBfqTKWO1mkhSFH3A7blITC9MhYon6SjnMhp4o0rADGw9yAC6EW4t5a4K3g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<title>Learning Baduk</title>

<style>
.ck-editor__editable {
	min-height: 350px;
}
</style>
</head>
<body>

	<!-- header  -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- main  -->
	<tiles:insertAttribute name="main"></tiles:insertAttribute>

	<script>
		ClassicEditor
			.create( document.querySelector( '#ckeditor' ), {
				ckfinder: {
			        uploadUrl: '/file/imgUpload' // 내가 지정한 업로드 url (post로 요청감)
				}
			} )
			.catch( error => {
			    console.error( error );
			} );
	</script>

</body>
</html>