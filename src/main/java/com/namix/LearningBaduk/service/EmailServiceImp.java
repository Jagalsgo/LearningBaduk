package com.namix.LearningBaduk.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.namix.LearningBaduk.dao.EmailDao;
import com.namix.LearningBaduk.dao.UserDao;
import com.namix.LearningBaduk.entity.EmailToken;
import com.namix.LearningBaduk.entity.User;

@Service
public class EmailServiceImp implements EmailService {

	@Autowired
	private EmailDao emailDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private JavaMailSender javaMailSender;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Async
	@Override
	public void sendEmail(String email, String emailToken, int emailTokenId, String userId) {

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(email);
		smm.setSubject("Learning Baduk 회원가입 이메일 인증");
		smm.setText("https://learningbaduk.herokuapp.com/mail/confirmEmail?email=" + email + "&emailToken=" + emailToken
				+ "&emailTokenId=" + emailTokenId + "&userId=" + userId);
		javaMailSender.send(smm);

	}

	@Async
	@Override
	public void sendRandomPassword(String id, String email) {

		SimpleMailMessage smm = new SimpleMailMessage();
		String randomPassword = getRandomPassword(10);
		String encodePassword = passwordEncoder.encode(randomPassword);
		
		int result = 0;
		result = userDao.editUserPassword(id, encodePassword);
		
		if (result >= 1) {
			smm.setTo(email);
			smm.setSubject("Learning Baduk 비밀번호 찾기");
			smm.setText("회원님의 임시 비밀번호는 " + randomPassword + " 입니다.");
			javaMailSender.send(smm);
		} else {
			System.out.println("error");
		}

	}

	@Override
	@Transactional
	public int confirmEmail(String email, String authToken, int emailTokenId, String userId) {

		EmailToken emailToken = emailDao.getEmailToken(emailTokenId);
		User user = userDao.getUser(userId);

		if (emailToken == null) {
			sendEmail(email, UUID.randomUUID().toString(), emailTokenId, userId);
			return -1;
		}

		if (user.isEmailAuth() == true) {
			return 0;
		}

		if (emailToken.isExpired() != true) {
			LocalDateTime now = LocalDateTime.now();
			emailDao.useToken(emailTokenId);
			emailDao.updateTokenExpiredDate(now, emailTokenId);
			emailDao.emailVerifySuccess(userId);
		}
		return 1;

	}

	// 임시 비밀번호 생성
	public static String getRandomPassword(int size) {

		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&' };

		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		sr.setSeed(new Date().getTime());

		int idx = 0;
		int len = charSet.length;
		for (int i = 0; i < size; i++) {
			idx = sr.nextInt(len);
			sb.append(charSet[idx]);
		}

		return sb.toString();

	}

}
