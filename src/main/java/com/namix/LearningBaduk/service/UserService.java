package com.namix.LearningBaduk.service;

import com.namix.LearningBaduk.entity.User;

public interface UserService {

	User login(String id, String userPassword);

	int idOverlapCheck(String signUpId);

	int nicknameOverlapCheck(String signUpNickname);

	int signUp(String id, String password, String nickname, String email);
	
}
