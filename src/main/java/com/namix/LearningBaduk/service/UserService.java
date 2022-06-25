package com.namix.LearningBaduk.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserService {

	int idOverlapCheck(String signUpId);

	int nicknameOverlapCheck(String signUpNickname);

	int withdraw(String id);

	void editProfileImg(MultipartFile file, HttpServletRequest request, String userId) throws IOException;

	int addUserProfileImg(String imgUrl, String userId);

	int addProfileImg(String imgName, String imgUrl, String userId);

	void deleteProfileImg(String userId);

	UserProfileImg getProfileImg(String userId);

	List<User> getUsers(Integer page, String field, String query);

	int getUserCount(String field, String query);

	List<User> getReportUsers(int page, String field, String query);

	int getReportUserCount(String field, String query);

	void initUserReports(List<String> chkArray);

	void deleteUserProfileImg(String userId);

	User getUser(String userId);

	int reportUser(String reportedUser, String reportContent, String reporter);

	List<ReportList> getUserReportList(String userId, int page);

	int getUserReportsCount(String userId);

	ReportList getReport(int id);

	User getUserByNickname(String userNickname);

	int sendMessage(String sender, String receiver, String messageTitle, String messageContent);

}
