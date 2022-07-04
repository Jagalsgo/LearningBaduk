package com.namix.LearningBaduk.entity;

import java.util.Date;

public class Alarm {

	private int alarmId;
	private String alarmType;
	private String receiver;
	private String sender;
	private Date alarmDate;
	private int boardId;
	private int commentId;
	private int messageId;

	public Alarm() {
		// TODO Auto-generated constructor stub
	}

	public Alarm(int alarmId, String alarmType, String receiver, String sender, Date alarmDate, int boardId,
			int commentId, int messageId) {
		this.alarmId = alarmId;
		this.alarmType = alarmType;
		this.receiver = receiver;
		this.sender = sender;
		this.alarmDate = alarmDate;
		this.boardId = boardId;
		this.commentId = commentId;
		this.messageId = messageId;
	}

	public int getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

}
