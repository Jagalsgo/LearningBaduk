package com.namix.LearningBaduk.dao;

import java.time.LocalDateTime;

import com.namix.LearningBaduk.entity.EmailToken;

public interface EmailDao {
	
	EmailToken getEmailToken(int emailTokenId);

	int save(EmailToken emailToken);

	int useToken(int emailTokenId);

	int emailVerifySuccess(String userId);

	int updateTokenExpiredDate(LocalDateTime now, int emailTokenId);
	
}
