package com.namix.LearningBaduk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentView extends Comment {

	private String imgPath;
	private String userNickname;
	
}
