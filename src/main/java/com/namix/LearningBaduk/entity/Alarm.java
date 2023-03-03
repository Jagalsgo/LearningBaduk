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
public class Alarm {

	private int alarmId;
	private String alarmType;
	private String receiver;
	private String sender;
	private Date alarmDate;
	private int boardId;
	private int commentId;
	private int messageId;

}
