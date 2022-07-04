package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.Alarm;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

public interface UserDao {

	User getUser(String id);

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

	int addUserProfileImg(String imgUrl, String userId);

	int deleteUserProfileImg(String userId);

	int addUsersReport(String reportedUser);

	int postReportList(String type, String reportedUser, String reportContent, String reporter);

	List<ReportList> getUserReportList(String userId, int size, int offset);

	int getUserReportsCount(String userId);

	ReportList getReport(int id);

	int deleteUserReportList(String id);

	User getUserByNickname(String userNickname);

	int sendMessage(Message message);

	Message getMessage(int id);

	int getAlarmCount(String receiver);

	List<AlarmView> getAlarms(String receiver);

	int addMessageAlarm(Message message);

	int deleteAlarm(int alarmId);

	int deleteAllAlarm(String receiver);

}
