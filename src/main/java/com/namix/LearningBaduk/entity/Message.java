package com.namix.LearningBaduk.entity;

import java.util.Date;

public class Message {

	private int messageId;
	private String sender;
	private String receiver;
	private String messageTitle;
	private String messageContent;
	private Date messageSendDate;
	private boolean deleteBySender;
	private boolean deleteByReceiver;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int messageId, String sender, String receiver, String messageTitle, String messageContent,
			Date messageSendDate, boolean deleteBySender, boolean deleteByReceiver) {
		super();
		this.messageId = messageId;
		this.sender = sender;
		this.receiver = receiver;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.messageSendDate = messageSendDate;
		this.deleteBySender = deleteBySender;
		this.deleteByReceiver = deleteByReceiver;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageSendDate() {
		return messageSendDate;
	}

	public void setMessageSendDate(Date messageSendDate) {
		this.messageSendDate = messageSendDate;
	}

	public boolean isDeleteBySender() {
		return deleteBySender;
	}

	public void setDeleteBySender(boolean deleteBySender) {
		this.deleteBySender = deleteBySender;
	}

	public boolean isDeleteByReceiver() {
		return deleteByReceiver;
	}

	public void setDeleteByReceiver(boolean deleteByReceiver) {
		this.deleteByReceiver = deleteByReceiver;
	}

}
