package com.namix.LearningBaduk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.User;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	/*
	 * @Transactional public void signUp(UserVo userVo) {
	 * 
	 * userVo.setUserPassword(passwordEncoder.encode(userVo.getPassword()));
	 * userDao.signUp(userVo);
	 * 
	 * }
	 */
	 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.login(username);
        if (user != null){
            return new SecurityUser(user);
        }
        System.out.println("null");
        return null;
		
	}

}
