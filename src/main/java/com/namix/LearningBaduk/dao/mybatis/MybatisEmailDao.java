package com.namix.LearningBaduk.dao.mybatis;

import java.time.LocalDateTime;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.EmailDao;
import com.namix.LearningBaduk.entity.EmailToken;

@Repository
public class MybatisEmailDao implements EmailDao {

	private EmailDao emailDaoMapper;

	@Autowired
	public MybatisEmailDao(SqlSession sqlsession) {
		emailDaoMapper = sqlsession.getMapper(EmailDao.class);
	}
	
	@Override
	public EmailToken getEmailToken(int emailTokenId) {
		return emailDaoMapper.getEmailToken(emailTokenId);
	}

	@Override
	public int save(EmailToken emailToken) {
		return emailDaoMapper.save(emailToken);
	}

	@Override
	public int useToken(int emailTokenId) {
		return emailDaoMapper.useToken(emailTokenId);
	}

	@Override
	public int emailVerifySuccess(String userId) {
		return emailDaoMapper.emailVerifySuccess(userId);
	}

	@Override
	public int updateTokenExpiredDate(LocalDateTime now, int emailTokenId) {
		return emailDaoMapper.updateTokenExpiredDate(now, emailTokenId);
	}

	
}
