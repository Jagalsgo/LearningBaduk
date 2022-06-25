package com.namix.LearningBaduk.entity;

public class MessageView extends Message {
	
	private String receiverNickname;
	private String senderNickname;
	
	public MessageView() {
		
	}
	
	public MessageView(String receiverNickname, String senderNickname) {
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
