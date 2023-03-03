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
public class Comment {

	private int commentId;
	private String commentContent;
	private String commentDate;
	private String userId;
	private int boardId;
	private boolean deleted;
	private Date deletedDate;
	private int commentDepth;
	private int parentId;
	private int commentGroup;

}
