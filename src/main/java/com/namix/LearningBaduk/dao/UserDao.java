package com.namix.LearningBaduk.dao;

import com.namix.LearningBaduk.entity.User;

public interface UserDao {

	User login(String id, String password);

	int idOverlapCheck(String id);

	int nicknameOverlapCheck(String nickname);

	int signUp(String id, String password, String nickname, String email);

	int editProfile(String password, String nickname, String email, String profileImg, String id);

	int withdraw(String id);
	
}
