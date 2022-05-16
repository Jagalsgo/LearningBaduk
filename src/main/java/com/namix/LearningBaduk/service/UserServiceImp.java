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

}
