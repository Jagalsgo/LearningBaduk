package com.namix.LearningBaduk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

@Mapper
public interface UserDao {

	List<User> getUsers(int offset, int size, String field, String query);
	User getUser(String id);
	User getUserByNickname(String userNickname);
	User getUserByEmail(String email);
	
	User getVerifiedUser(String userId);
	User getVerifiedUserByEmail(String email);

	int getUserCount(String field, String query);
	
	int idOverlapCheck(String id);
	int nicknameOverlapCheck(String nickname);
	User emailOverlapCheck(String email);

	UserProfileImg getProfileImg(String userId);

	int editProfile(String password, String nickname, String email, String id);
	int editUserPassword(String id, String password);
	
	int addReportList(String type, String reportedUser, String reportContent, String reporter);
	int addProfileImg(String imgName, String imgUrl, String userId);
	int addUserProfileImg(String imgUrl, String userId);
	int addUserReport(String reportedUser);
	
	int deleteProfileImg(String userId);
	int deleteUserProfileImg(String userId);
	int deleteUserReportList(String id);
	
	int signUp(User user);

	int withdraw(String id);

	List<ReportList> getUserReportList(String userId, int size, int offset);
	ReportList getReport(int id);

	List<User> getReportedUsers(int offset, int size, String field, String query);

	int getUserReportsCount(String userId);

	int getReportedUserCount(String field, String query);
	
	int initUserReport(String id);
	
	int initEmailAuth(String id);

}
