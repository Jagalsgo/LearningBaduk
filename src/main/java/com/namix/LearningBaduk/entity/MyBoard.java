package com.namix.LearningBaduk.entity;

public class MyBoard {

	private int myBoardId;
	private String myBoardTitle;
	private String myBoardContent;
	private String myBoardDate;
	private String userId;
	
	public MyBoard() {
		
	}

	public MyBoard(int myBoardId, String myBoardTitle, String myBoardContent, String myBoardDate, String userId) {
		this.myBoardId = myBoardId;
		this.myBoardTitle = myBoardTitle;
		this.myBoardContent = myBoardContent;
		this.myBoardDate = myBoardDate;
		this.userId = userId;
	}

	public int getMyBoardId() {
		return myBoardId;
	}

	public void setMyBoardId(int myBoardId) {
		this.myBoardId = myBoardId;
	}

	public String getMyBoardTitle() {
		return myBoardTitle;
	}

	public void setMyBoardTitle(String myBoardTitle) {
		this.myBoardTitle = myBoardTitle;
	}

	public String getMyBoardContent() {
		return myBoardContent;
	}

	public void setMyBoardContent(String myBoardContent) {
		this.myBoardContent = myBoardContent;
	}

	public String getMyBoardDate() {
		return myBoardDate;
	}

	public void setMyBoardDate(String myBoardDate) {
		this.myBoardDate = myBoardDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
