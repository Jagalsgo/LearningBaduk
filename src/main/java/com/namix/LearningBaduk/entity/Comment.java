package com.namix.LearningBaduk.entity;

public class Comment {

	private int commentId;
	private String commentContent;
	private String commentDate;
	private String userId;
	private int boardId;
	
	public Comment() {
		
	}

	public Comment(int commentId, String commentContent, String commentDate, String userId, int boardId) {
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.userId = userId;
		this.boardId = boardId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

}
