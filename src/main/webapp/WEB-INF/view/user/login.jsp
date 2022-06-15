<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/login.css">
<script type="text/javascript" src="/js/login.js"></script>
<div class="container-md">
		<form action="/login" method="post" class="border px-5 py-4" id="loginForm">
			<div class="fw-bold h4 mb-5 mt-3">로그인</div>
			<c:if test="${param.error != null}">
				<p>
					Invalid username and password.
				</p>
			</c:if>
			<c:if test="${param.logout != null}">
				<p>
					You have been logged out.
				</p>
			</c:if>	
	        <div class="form-group">
	            <label for="loginId" class="loginFormLabel">아이디</label>
	            <input type="text" class="form-control" placeholder="ID" id="userId" name="username">
	        </div>
	        <div class="form-group">
	            <label for="loginPassword" class="loginFormLabel">비밀번호</label>
	            <input type="password" class="form-control" placeholder="Password" id="userPassword" name="password">
	        </div>
            <div class="text-right">
            	<input type="submit" class="btn btn-secondary my-3" value="로그인">
            </div>
    	<div class="text-center my-4"><a href="/user/signUp" class="text-primary">계정이 없습니까?</a></div>
    	<div class="text-center my-4"><a href="/user/findAccount" class="text-primary">계정을 잃어버렸습니까?</a></div>
    	</form>
	</div>