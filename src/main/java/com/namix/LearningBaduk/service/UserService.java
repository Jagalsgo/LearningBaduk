package com.namix.LearningBaduk.service;

import com.namix.LearningBaduk.entity.User;

public interface UserService {

	User login(String id, String userPassword);
	
}
