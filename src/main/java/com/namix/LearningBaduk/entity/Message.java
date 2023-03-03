package com.namix.LearningBaduk.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

	private int messageId;
	private String sender;
	private String receiver;
	private String messageTitle;
	private String messageContent;
	private Date messageSendDate;
	private boolean deleteBySender;
	private boolean deleteByReceiver;

	public boolean isDeleteBySender() {
		return deleteBySender;
	}

	public boolean isDeleteByReceiver() {
		return deleteByReceiver;
	}

}
