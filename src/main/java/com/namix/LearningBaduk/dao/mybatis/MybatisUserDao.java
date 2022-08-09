package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.ReportList;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.entity.UserProfileImg;

@Repository
public class MybatisUserDao implements UserDao {

	private UserDao userDaoMapper;

	@Autowired
	public MybatisUserDao(SqlSession sqlsession) {
		userDaoMapper = sqlsession.getMapper(UserDao.class);
	}

	@Override
	public List<User> getUsers(int offset, int size, String field, String query) {
		return userDaoMapper.getUsers(offset, size, field, query);
	}

	@Override
	public User getUser(String id) {
		return userDaoMapper.getUser(id);
	}

	@Override
	public User getUserByNickname(String userNickname) {
		return userDaoMapper.getUserByNickname(userNickname);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDaoMapper.getUserByEmail(email);
	}

	@Override
	public User getVerifiedUser(String userId) {
		return userDaoMapper.getVerifiedUser(userId);
	}

	@Override
	public User getVerifiedUserByEmail(String email) {
		return userDaoMapper.getVerifiedUserByEmail(email);
	}

	@Override
	public int getUserCount(String field, String query) {
		return userDaoMapper.getUserCount(field, query);
	}

	@Override
	public int idOverlapCheck(String id) {
		return userDaoMapper.idOverlapCheck(id);
	}

	@Override
	public int nicknameOverlapCheck(String nickname) {
		return userDaoMapper.nicknameOverlapCheck(nickname);
	}

	@Override
	public User emailOverlapCheck(String email) {
		return userDaoMapper.emailOverlapCheck(email);
	}

	@Override
	public int signUp(User user) {
		return userDaoMapper.signUp(user);
	}

	@Override
	public int editProfile(String password, String nickname, String email, String id) {
		return userDaoMapper.editProfile(password, nickname, email, id);
	}

	@Override
	public int addProfileImg(String imgName, String imgUrl, String userId) {
		return userDaoMapper.addProfileImg(imgName, imgUrl, userId);
	}

	@Override
	public int deleteProfileImg(String userId) {
		return userDaoMapper.deleteProfileImg(userId);
	}

	@Override
	public UserProfileImg getProfileImg(String userId) {
		return userDaoMapper.getProfileImg(userId);
	}

	@Override
	public int addUserProfileImg(String imgUrl, String userId) {
		return userDaoMapper.addUserProfileImg(imgUrl, userId);
	}

	@Override
	public int deleteUserProfileImg(String userId) {
		return userDaoMapper.deleteUserProfileImg(userId);
	}

	@Override
	public int editUserPassword(String id, String password) {
		return userDaoMapper.editUserPassword(id, password);
	}

	@Override
	public int withdraw(String id) {
		return userDaoMapper.withdraw(id);
	}

	@Override
	public List<User> getReportUsers(int offset, int size, String field, String query) {
		return userDaoMapper.getReportUsers(offset, size, field, query);
	}

	@Override
	public int getReportUserCount(String field, String query) {
		return userDaoMapper.getReportUserCount(field, query);
	}

	@Override
	public int initUserReport(String id) {
		return userDaoMapper.initUserReport(id);
	}

	@Override
	public int addUsersReport(String reportedUser) {
		return userDaoMapper.addUsersReport(reportedUser);
	}

	@Override
	public int postReportList(String type, String reportedUser, String reportContent, String reporter) {
		return userDaoMapper.postReportList(type, reportedUser, reportContent, reporter);
	}

	@Override
	public List<ReportList> getUserReportList(String userId, int size, int offset) {
		return userDaoMapper.getUserReportList(userId, size, offset);
	}

	@Override
	public int getUserReportsCount(String userId) {
		return userDaoMapper.getUserReportsCount(userId);
	}

	@Override
	public ReportList getReport(int id) {
		return userDaoMapper.getReport(id);
	}

	@Override
	public int deleteUserReportList(String id) {
		return userDaoMapper.deleteUserReportList(id);
	}

	@Override
	public int initEmailAuth(String id) {
		return userDaoMapper.initEmailAuth(id);
	}

}
