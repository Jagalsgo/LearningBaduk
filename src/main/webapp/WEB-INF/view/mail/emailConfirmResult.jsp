<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>email verified</title>
</head>
<body>
	<c:choose>
		<!-- Error -->
		<c:when test="${state == -1}">
			이메일 전송 중 에러가 발생하여 메일을 다시 보냈습니다. 관련 문의는 해당 메일로 부탁드립니다.
		</c:when>
		<!-- Already Verified User -->
		<c:when test="${state == 0}">
			이미 인증된 유저입니다.
		</c:when>
		<!-- Verified -->
		<c:otherwise>
			이메일 인증이 완료되었습니다.
		</c:otherwise>
	</c:choose>
</body>
</html>