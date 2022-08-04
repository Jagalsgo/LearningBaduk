package com.namix.LearningBaduk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.AlarmDao;
import com.namix.LearningBaduk.dao.MessageDao;
import com.namix.LearningBaduk.entity.Message;
import com.namix.LearningBaduk.entity.MessageView;

@Service
public class MessageServiceImp implements MessageService {

	@Autowired
	MessageDao messageDao;
	@Autowired
	AlarmDao alarmDao;
	
	@Override
	public List<MessageView> getMessages(Integer page, String field, String query, String messageField,
			String messageQuery, String deleted) {
		int size = 10;
		int offset = 0 + (page - 1) * size;

		return messageDao.getMessages(offset, size, field, query, messageField, messageQuery, deleted);
	}

	@Override
	public MessageView getMessage(int id) {
		return messageDao.getMessage(id);
	}

	@Override
	public int getMessageCount(String field, String query, String messageField, String messageQuery, String deleted) {
		return messageDao.getMessageCount(field, query, messageField, messageQuery, deleted);
	}

	@Override
	public void deleteMessage(List<Integer> chkArray, String deleted) {

		for (int i = 0; i < chkArray.size(); i++) {
			int id = chkArray.get(i);
			messageDao.deleteMessage(id, deleted);
			Message message = messageDao.getMessage(id);
			if (message.isDeleteByReceiver() && message.isDeleteBySender()) {
				messageDao.deleteDbMessage(id);
			}
		}

	}

	@Override
	public void deleteMessageDetail(int id, String deleted) {

		messageDao.deleteMessage(id, deleted);
		Message message = messageDao.getMessage(id);
		if (message.isDeleteByReceiver() && message.isDeleteBySender()) {
			messageDao.deleteDbMessage(id);
		}

	}

	@Override
	public int sendMessage(String sender, String receiver, String messageTitle, String messageContent) {
		Message message = new Message();
		message.setSender(sender);
		message.setReceiver(receiver);
		message.setMessageTitle(messageTitle);
		message.setMessageContent(messageContent);
		int result = messageDao.sendMessage(message);
		if (!sender.equals(receiver)) {
			alarmDao.addMessageAlarm(message);
		}

		return result;
	}

}
