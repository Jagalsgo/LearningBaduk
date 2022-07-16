package com.namix.LearningBaduk.entity;

public class AlarmMessage {

	private String type;
	private String receiver;
	private String sender;
	private int boardId;
	private int count;

	public AlarmMessage() {
	}

	public AlarmMessage(String type, String receiver, String sender, int boardId, int count) {
		this.type = type;
		this.receiver = receiver;
		this.sender = sender;
		this.boardId = boardId;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AlarmMessage [type=" + type + ", receiver=" + receiver + ", sender=" + sender + ", boardId=" + boardId
				+ ", count=" + count + "]";
	}

}
