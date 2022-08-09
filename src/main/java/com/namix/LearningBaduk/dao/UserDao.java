package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.Alarm;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserDao {

	List<User> getUsers(int offset, int size, String field, String query);

	User getUser(String id);

	int getUserCount(String field, String query);

	User getUserByNickname(String userNickname);

	User getUserByEmail(String email);

	User getVerifiedUser(String userId);

	User getVerifiedUserByEmail(String email);

	int idOverlapCheck(String id);

	int nicknameOverlapCheck(String nickname);

	User emailOverlapCheck(String email);

	int signUp(User user);

	int editProfile(String password, String nickname, String email, String id);

	int addProfileImg(String imgName, String imgUrl, String userId);

	int deleteProfileImg(String userId);

	UserProfileImg getProfileImg(String userId);

	int addUserProfileImg(String imgUrl, String userId);

	int editUserPassword(String id, String password);

	int withdraw(String id);

	List<User> getReportUsers(int offset, int size, String field, String query);

	int getReportUserCount(String field, String query);

	int initUserReport(String id);

	List<ReportList> getUserReportList(String userId, int size, int offset);

	ReportList getReport(int id);

	int deleteUserProfileImg(String userId);

	int addUsersReport(String reportedUser);

	int postReportList(String type, String reportedUser, String reportContent, String reporter);

	int getUserReportsCount(String userId);

	int deleteUserReportList(String id);

	int initEmailAuth(String id);

}
