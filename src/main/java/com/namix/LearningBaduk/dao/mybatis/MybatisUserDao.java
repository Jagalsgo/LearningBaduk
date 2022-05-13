package com.namix.LearningBaduk.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.User;

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

}
