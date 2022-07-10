package com.namix.LearningBaduk.service;

public interface EmailService {

	public void sendEmail(String email, String emailToken, int emailTokenId, String userId);
	
	public int confirmEmail(String email, String emailToken,int emailTokenId, String userId);

	void sendRandomPassword(String id, String email);
	
}
