package com.namix.LearningBaduk.dao.mybatis;

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
	public User login(String id, String password) {
		return userDaoMapper.login(id, password);
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
	public int signUp(String id, String password, String nickname, String email) {
		return userDaoMapper.signUp(id, password, nickname, email);
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

}
