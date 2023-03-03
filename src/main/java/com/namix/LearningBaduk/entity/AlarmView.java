package com.namix.LearningBaduk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlarmView extends Alarm {

	private String receiverNickname;
	private String senderNickname;
	
	public AlarmView(String receiverNickname, String senderNickname) {
		super();
		this.receiverNickname = receiverNickname;
		this.senderNickname = senderNickname;
	}

}
