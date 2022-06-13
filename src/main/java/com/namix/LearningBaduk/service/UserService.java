package com.namix.LearningBaduk.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserService {

	User login(String id, String userPassword);

	int idOverlapCheck(String signUpId);

	int nicknameOverlapCheck(String signUpNickname);

	int signUp(String id, String password, String nickname, String email);

	int editProfile(String password, String nickname, String email, String id);

	int withdraw(String id);

	void editProfileImg(MultipartFile file, HttpServletRequest request, String userId) throws IOException;
	

	int addProfileImg(String imgName, String imgUrl, String userId);

	int deleteProfileImg(String userId);
	
	UserProfileImg getProfileImg(String userId);

	List<User> getUsers(Integer page, String field, String query);

	int getUserCount(String field, String query);

	List<User> getReportUsers(int page, String field, String query);

	int getReportUserCount(String field, String query);

	void initUserReports(List<String> chkArray);
}
