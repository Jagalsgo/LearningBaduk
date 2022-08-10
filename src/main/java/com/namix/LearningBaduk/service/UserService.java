package com.namix.LearningBaduk.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.namix.LearningBaduk.entity.Alarm;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserService {

	// get user
	List<User> getUsers(Integer page, String field, String query);

	User getUser(String userId);

	User getUserByNickname(String userNickname);

	User getUserByEmail(String email);

	User getVerifiedUser(String userId);

	User getVerifiedUserByEmail(String email);

	// overlap check
	int idOverlapCheck(String signUpId);

	int nicknameOverlapCheck(String signUpNickname);

	int emailOverlapCheck(String email);

	// edit profile

	void editProfileImg(MultipartFile file, HttpServletRequest request, String userId) throws IOException;

	int addUserProfileImg(String imgUrl, String userId);

	int addProfileImg(String imgName, String imgUrl, String userId);

	void deleteProfileImg(String userId);

	void deleteUserProfileImg(String userId);

	// withdraw

	int withdraw(String id);

	// report

	List<ReportList> getUserReportList(String userId, int page);

	ReportList getReport(int id);

	List<User> getReportUsers(int page, String field, String query);

	int getUserCount(String field, String query);

	int getUserReportsCount(String userId);

	int getReportUserCount(String field, String query);

	void initUserReports(List<String> chkArray);

	int reportUser(String reportedUser, String reportContent, String reporter);

	UserProfileImg getProfileImg(String userId);
	
	void initEmailAuth(String id);

}
