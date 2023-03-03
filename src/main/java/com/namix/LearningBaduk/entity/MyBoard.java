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
public class MyBoard {

	private int myBoardId;
	private String myBoardTitle;
	private String myBoardContent;
	private String myBoardDate;
	private String userId;
	
}
