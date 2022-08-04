package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.MessageView;

public interface MessageDao {

	List<MessageView> getMessages(int offset, int size, String field, String query, String messageField,
			String messageQuery, String deleted);

	MessageView getMessage(int id);

	int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted);

	int deleteMessage(int id, String deleted);

	int deleteDbMessage(int id);
	
	int sendMessage(Message message);

}
