package com.namix.LearningBaduk.entity;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailToken {
	
	// private static final long MAX_EXPIRE_TIME = 5L;

	private int emailTokenId;
	private String email;
	private String authToken;
	private boolean expired;
	private LocalDateTime expiredDate;
	
	public EmailToken(String email, String authToken , boolean expired, LocalDateTime expiredDate) {
		this.email = email;
		this.authToken = authToken;
		this.expired = expired;
		this.expiredDate = expiredDate;
	}

	public boolean isExpired() {
		return expired;
	}

}
