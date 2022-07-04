package com.namix.LearningBaduk.entity;

public class AlarmView extends Alarm {

	private String receiverNickname;
	private String senderNickname;
	
	public AlarmView() {
		// TODO Auto-generated constructor stub
	}

	public AlarmView(String receiverNickname, String senderNickname) {
		super();
		this.receiverNickname = receiverNickname;
		this.senderNickname = senderNickname;
	}

	public String getReceiverNickname() {
		return receiverNickname;
	}

	public void setReceiverNickname(String receiverNickname) {
		this.receiverNickname = receiverNickname;
	}

	public String getSenderNickname() {
		return senderNickname;
	}

	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}
	
}
