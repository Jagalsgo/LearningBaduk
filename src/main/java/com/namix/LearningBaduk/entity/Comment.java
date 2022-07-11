package com.namix.LearningBaduk.entity;

import java.util.Date;

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

	public Comment() {

	}

	public Comment(int commentId, String commentContent, String commentDate, String userId, int boardId,
			boolean deleted, Date deletedDate, int commentDepth, int parentId) {
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.userId = userId;
		this.boardId = boardId;
		this.deleted = deleted;
		this.deletedDate = deletedDate;
		this.commentDepth = commentDepth;
		this.parentId = parentId;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public int getCommentDepth() {
		return commentDepth;
	}

	public void setCommentDepth(int commentDepth) {
		this.commentDepth = commentDepth;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
