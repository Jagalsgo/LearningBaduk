package com.namix.LearningBaduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(String id, String password) {
		return userDao.login(id, password);
	}

	@Override
	public int idOverlapCheck(String id) {
		return userDao.idOverlapCheck(id);
	}

	@Override
	public int nicknameOverlapCheck(String nickname) {
		return userDao.nicknameOverlapCheck(nickname);
	}

	@Override
	public int signUp(String id, String password, String nickname, String email) {
		return userDao.signUp(id, password, nickname, email);
	}

}
