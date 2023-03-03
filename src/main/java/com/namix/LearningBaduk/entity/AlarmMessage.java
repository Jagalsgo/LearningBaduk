package com.namix.LearningBaduk.entity;

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
public class AlarmMessage {

	private String type;
	private String receiver;
	private String sender;
	private int boardId;
	private int count;

}
