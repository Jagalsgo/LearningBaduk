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
public class Board {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String boardCategory;
	private int boardReport;
	private String userId;
	private int boardHit;

}
