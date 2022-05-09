<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-md">
		<form action="findAccountAction" method="post" class="border px-5 py-4" id="findAccountForm">
			<div class="fw-bold h4 mb-5">아이디 / 비밀번호 찾기</div>
	        <div class="form-group">
	        	<div class="mb-3">1. 아이디 찾기 <span class="text-muted dot7Rem">(이메일과 매치되는 아이디를 알려드립니다)</span></div>
	            <label for="findIdEmail" class="findAccountFormLabel">이메일</label>
	            <input type="text" class="form-control" placeholder="EMAIL" id="findIdEmail" name="findIdEmail">
	            <div class="text-right">
	            	<a href="write.jsp" ><button class="btn btn-sm btn-secondary" id="findIdBtn" type="button">아이디 찾기</button></a>
	            </div>
	        </div>
	        <div class="form-group">
	        	<div class="mb-3">1. 비밀번호 찾기 <span class="text-muted dot7Rem">(해당하는 이메일로 비밀번호를 알려드립니다)</span></div>
	            <label for="findPasswordId" class="findAccountFormLabel">아이디</label>
	            <input type="text" class="form-control" placeholder="ID" id="findPasswordId" name="findPasswordId">
	            <label for="findPasswordEmail" class="findAccountFormLabel">이메일</label>
	            <input type="email" class="form-control" placeholder="EMAIL" id="findPasswordEmail" name="findPasswordEmail">
	            <div class="text-right">
	            	<a href="write.jsp" ><button class="btn btn-sm btn-secondary" id="findPasswordBtn" type="button">비밀번호 찾기</button></a>
	            </div>
	        </div>
    	</form>
	</div>