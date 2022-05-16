package com.namix.LearningBaduk.dao;

import com.namix.LearningBaduk.entity.User;

public interface UserDao {

	User login(String id, String password);
	
}
