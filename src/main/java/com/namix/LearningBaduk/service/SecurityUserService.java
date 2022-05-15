package com.namix.LearningBaduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.SecurityUser;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SecurityUser user = userDao.login(username);
		UserDetails userDetails = user;
		
		return userDetails;
	}

}
