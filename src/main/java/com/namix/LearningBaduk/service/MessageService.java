package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.MessageView;

public interface MessageService {

	List<MessageView> getMessages(Integer page, String field, String query, String messageField, String messageQuery,
			String string);
	MessageView getMessage(int id);

	int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted);

	void deleteMessage(List<Integer> chkArray, String deleted);
	void deleteMessageDetail(int id, String deleted);

	int sendMessage(String sender, String receiver, String messageTitle, String messageContent);

}
