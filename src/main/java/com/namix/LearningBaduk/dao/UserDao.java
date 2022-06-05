package com.namix.LearningBaduk.dao;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserDao {

	User login(String id, String password);

	int idOverlapCheck(String id);

	int nicknameOverlapCheck(String nickname);

	int signUp(String id, String password, String nickname, String email);

	int editProfile(String password, String nickname, String email, String id);

	int withdraw(String id);

	int addProfileImg(String imgName, String imgUrl, String userId);

	int deleteProfileImg(String userId);

	UserProfileImg getProfileImg(String userId);
	
}
