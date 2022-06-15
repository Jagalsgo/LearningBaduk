package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserDao {

	User login(String id);

	int idOverlapCheck(String id);

	int nicknameOverlapCheck(String nickname);

	int signUp(User user);

	int editProfile(String password, String nickname, String email, String id);

	int withdraw(String id);

	int addProfileImg(String imgName, String imgUrl, String userId);

	int deleteProfileImg(String userId);

	UserProfileImg getProfileImg(String userId);

	List<User> getUsers(int offset, int size, String field, String query);

	int getUserCount(String field, String query);

	List<User> getReportUsers(int offset, int size, String field, String query);

	int getReportUserCount(String field, String query);

	int initUserReport(String id);
	
}
