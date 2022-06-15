package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.UserDao;
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
	public User login(String id) {
		return userDaoMapper.login(id);
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
	public int signUp(User user) {
		return userDaoMapper.signUp(user);
	}

	@Override
	public int editProfile(String password, String nickname, String email, String id) {
		return userDaoMapper.editProfile(password, nickname, email, id);
	}

	@Override
	public int withdraw(String id) {
		return userDaoMapper.withdraw(id);
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
	public List<User> getUsers(int offset, int size, String field, String query) {
		return userDaoMapper.getUsers(offset, size, field, query);
	}

	@Override
	public int getUserCount(String field, String query) {
		return userDaoMapper.getUserCount(field, query);
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

}
