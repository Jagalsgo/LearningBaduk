package com.namix.LearningBaduk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageView extends Message {
	
	private String receiverNickname;
	private String senderNickname;
	
	public MessageView(String receiverNickname, String senderNickname) {
		this.receiverNickname = receiverNickname;
		this.senderNickname = senderNickname;
	}

}
