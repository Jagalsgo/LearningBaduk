package com.namix.LearningBaduk.dao;

import com.namix.LearningBaduk.entity.SecurityUser;

public interface UserDao {

	SecurityUser login(String id);
	
}
