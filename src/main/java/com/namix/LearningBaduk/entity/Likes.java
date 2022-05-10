package com.namix.LearningBaduk.entity;

public class Likes {

	private int likeId;
	private int boardId;
	private String userId;
	private int likeCheck;
	
	public Likes() {
		
	}

	public Likes(int likeId, int boardId, String userId, int likeCheck) {
		this.likeId = likeId;
		this.boardId = boardId;
		this.userId = userId;
		this.likeCheck = likeCheck;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}
	
}
