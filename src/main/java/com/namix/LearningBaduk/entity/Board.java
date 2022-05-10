package com.namix.LearningBaduk.entity;

import java.util.Date;

public class Board {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private String boardCategory;
	private int boardReport;
	private String userId;
	private int boardHit;
	
	public Board() {
		
	}
	
	public Board(int boardId, String boardTitle, String boardContent, Date boardDate, String boardCategory, int boardReport, String userId, int boardHit) {
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCategory = boardCategory;
		this.boardReport = boardReport;
		this.userId = userId;
		this.boardHit = boardHit;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}

	public int getBoardReport() {
		return boardReport;
	}

	public void setBoardReport(int boardReport) {
		this.boardReport = boardReport;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getboardHit() {
		return boardHit;
	}
	
	public void setboardHit(int boardHit) {
		this.boardHit = boardHit;
	}

}
