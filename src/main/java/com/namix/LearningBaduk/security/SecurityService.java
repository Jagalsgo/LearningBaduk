package com.namix.LearningBaduk.security;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.namix.LearningBaduk.dao.EmailDao;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.EmailToken;
import com.namix.LearningBaduk.entity.User;
import com.namix.LearningBaduk.service.EmailService;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private EmailDao emailDao;
	@Autowired
	private EmailService emailService;
	
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	  @Transactional
	  public void signUp(User user) {
	  
		String rawPassword = user.getUserPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setUserPassword(encPassword);
		
		userDao.signUp(user);
		
		EmailToken emailToken = new EmailToken(user.getUserEmail(), UUID.randomUUID().toString(), false, null);
		emailDao.save(emailToken);
		emailService.sendEmail(emailToken.getEmail(), emailToken.getAuthToken(), emailToken.getEmailTokenId(), user.getUserId());
	  
	  }
	  
	  
	  @Transactional
	  public void editProfile(User user) {
		  
		  User getUser = userDao.getUser(user.getUserId());
		  
		  String rawPassword = user.getUserPassword();
		  String password;
		  String nickname = user.getUserNickname();
		  String email = user.getUserEmail();
		  String id = user.getUserId();
		  
		  if(rawPassword == "" || rawPassword.isBlank()) {
				password = getUser.getUserPassword();
			}else {
				password = passwordEncoder.encode(rawPassword);
			}
			if(nickname == "" || nickname.isBlank()) {
				nickname = getUser.getUserNickname();
			}
			if(email == "" || email.isBlank()) {
				email = getUser.getUserEmail();
			}
		  
		  userDao.editProfile(password, nickname, email, id);
	  }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.getUser(username);
        if (user != null){
            return new SecurityUser(user);
        }
        System.out.println("null");
        return null;
		
	}

	public boolean isOldPasswordMatch(String userId, String oldPassword) {
		
		User user = userDao.getUser(userId);
		String dbPassword = user.getUserPassword();
		return passwordEncoder.matches(oldPassword, dbPassword);
		
	}

}
