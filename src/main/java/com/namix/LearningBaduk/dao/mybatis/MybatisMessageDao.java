package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.MessageDao;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.MessageView;

@Repository
public class MybatisMessageDao implements MessageDao {
	
	private MessageDao messageDaoMapper;

	@Autowired
	public MybatisMessageDao(SqlSession sqlsession) {
		messageDaoMapper = sqlsession.getMapper(MessageDao.class);
	}

	@Override
	public List<MessageView> getMessages(int offset, int size, String field, String query, String messageField, String messageQuery, String deleted) {
		return messageDaoMapper.getMessages(offset, size, field, query, messageField, messageQuery, deleted);
	}

	@Override
	public MessageView getMessage(int id) {
		return messageDaoMapper.getMessage(id);
	}

	@Override
	public int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted) {
		return messageDaoMapper.getMessageCount(field, query, messageField, messageQuery, deleted);
	}

	@Override
	public int deleteMessage(int id, String deleted) {
		return messageDaoMapper.deleteMessage(id, deleted);
	}

	@Override
	public int deleteDbMessage(int id) {
		return messageDaoMapper.deleteDbMessage(id);
	}

	@Override
	public int sendMessage(Message message) {
		return messageDaoMapper.sendMessage(message);
	}

}
