package com.namix.LearningBaduk.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class EmailToken {
	
	// private static final long MAX_EXPIRE_TIME = 5L;

	private int emailTokenId;
	private String email;
	private String authToken;
	private boolean expired;
	private LocalDateTime expiredDate;
	
	public EmailToken() {
		// TODO Auto-generated constructor stub
	}

	public EmailToken(String email, String authToken , boolean expired, LocalDateTime expiredDate) {
		this.email = email;
		this.authToken = authToken;
		this.expired = expired;
		this.expiredDate = expiredDate;
	}

	public int getEmailTokenId() {
		return emailTokenId;
	}

	public void setEmailTokenId(int emailTokenId) {
		this.emailTokenId = emailTokenId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}
	
}
