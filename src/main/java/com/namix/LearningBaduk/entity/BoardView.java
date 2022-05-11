package com.namix.LearningBaduk.entity;

public class BoardView extends Board{

	private int commentCount;
	private int likeCount;
	private int dislikeCount;
	private String userNickname;
	
	public BoardView() {
		
	}

	public BoardView(int commentCount, int likeCount, int dislikeCount, String userNickname) {
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.userNickname = userNickname;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
}
