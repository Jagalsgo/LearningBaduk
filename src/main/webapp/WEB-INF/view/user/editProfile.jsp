<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-md">
		<form action="/user/editProfile" method="post" class="border px-5 pt-4" id="editProfileForm">
			<div class="fw-bold h4 mb-5 mt-3">회원 정보 수정</div>
	        <div class="form-group">
	            <label for="editProfileId" class="editProfileFormLabel">아이디</label>
	            <div class="my-2">${user.userId }</div>
	            <input type="hidden" value="${user.userId }" id="editProfileId", name="editProfileId">
	        </div>
	        <div class="form-group">
	            <label for="editProfilePassword" class="editProfileFormLabel">비밀번호 변경</label>
	            <input type="password" class="form-control" placeholder="PASSWORD" id="editProfilePassword" name="editProfilePassword">
	        </div>
	        <div class="form-group">
	            <label for="editProfilePasswordCheck" class="editProfileFormLabel">비밀번호 확인</label>
	            <input type="password" class="form-control" placeholder="PASSWORD CHECK" id="editProfilePasswordCheck" name="editProfilePasswordCheck">
	        </div>
	        <div class="form-group">
	            <label for="editProfileName" class="editProfileFormLabel">닉네임</label>
	            <input type="text" class="form-control" placeholder="NICKNAME" id="editProfileNickname" name="editProfileNickname">
	            <input type="button" class="btn btn-secondary btn-sm" id="nicknameCheckBtn" value="닉네임 중복 체크" onclick="nicknameOverlapCheck()">
	            <div class="text-success" id="nicknameCheckedText">checked!</div>
	        </div>
	        <div class="form-group">
	            <label for="editProfileEmail" class="editProfileFormLabel">이메일</label>
	            <input type="email" class="form-control" placeholder="EMAIL" id="editProfileEmail" name="editProfileEmail">
	        </div>
	        <div class="form-group">
	        	<label for="editProfileProfileImg" class="editProfileFormLabel">프로필 이미지</label>
	        	<input type="file" accept="image/*" class="form-control" id="editProfileProfileImg" name="editProfileProfileImg">
	        </div>
	        <div class="form-group text-center my-5" id="editProfileSubmitBtnBox">
	        	<a href="/user/withdraw" ><button class="btn btn-secondary pull-left" id="goToWithdraw" type="button">회원탈퇴</button></a>
	            <input type="submit" class="btn btn-secondary pull-right" value="수정" id="editProfileSubmitBtn">
	        </div>
    	</form>
	</div>