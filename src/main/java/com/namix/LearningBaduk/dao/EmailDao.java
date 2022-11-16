package com.namix.LearningBaduk.dao;

import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;

import com.namix.LearningBaduk.entity.EmailToken;

@Mapper
public interface EmailDao {
	
	EmailToken getEmailToken(int emailTokenId);

	int save(EmailToken emailToken);

	int useToken(int emailTokenId);

	int emailVerifySuccess(String userId);

	int updateTokenExpiredDate(LocalDateTime now, int emailTokenId);
	
}
