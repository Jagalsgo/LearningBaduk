package com.namix.LearningBaduk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardView extends Board{

	private int commentCount;
	private int likeCount;
	private int dislikeCount;
	private String userNickname;
	private String imgPath;
	
	public BoardView(int commentCount, int likeCount, int dislikeCount, String userNickname, String imgPath) {
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.userNickname = userNickname;
		this.imgPath = imgPath;
	}

}
