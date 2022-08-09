package com.namix.LearningBaduk.entity;

public class Category {

	private String ct;
	private String categoryBoard;
	private String categoryDetail;
	private String categoryKor;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(String ct) {
		
		this.ct = ct;
		
		switch(ct) {
		
		case "free" : this.categoryBoard = "freeBoard";
		this.categoryDetail = "freeDetail";
		this.categoryKor = "자유게시판";
		break;
										
		case "rule" : this.categoryBoard = "ruleBoard";
		this.categoryDetail = "ruleDetail";
		this.categoryKor = "룰";
		break;
		
		case "pattern" : this.categoryBoard = "patternBoard";
		this.categoryDetail = "patternDetail";
		this.categoryKor = "정석";
		break;
		
		case "opening" : this.categoryBoard = "openingBoard";
		this.categoryDetail = "openingDetail";
		this.categoryKor = "포석";
		break;
		
		case "endGame" : this.categoryBoard = "endGameBoard";
		this.categoryDetail = "endGameDetail";
		this.categoryKor = "끝내기";
		break;
		
		case "lifeDeath" : this.categoryBoard = "lifeDeathBoard";
		this.categoryDetail = "lifeDeathDetail";
		this.categoryKor = "사활";
		break;
		
		case "quetion" : this.categoryBoard = "quetionBoard";
		this.categoryDetail = "quetionDetail";
		this.categoryKor = "Q&A";
		break;
		
		case "schedule" : this.categoryBoard = "scheduleBoard";
		this.categoryDetail = "scheduleDetail";
		this.categoryKor = "프로바둑일정";
		break;
		
		case "notice" : this.categoryBoard = "noticeBoard";
		this.categoryDetail = "noticeDetail";
		this.categoryKor = "공지";
		break;
	
		}
		
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getCategoryBoard() {
		return categoryBoard;
	}

	public void setCategoryBoard(String categoryBoard) {
		this.categoryBoard = categoryBoard;
	}

	public String getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(String categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public String getCategoryKor() {
		return categoryKor;
	}

	public void setCategoryKor(String categoryKor) {
		this.categoryKor = categoryKor;
	}
	
}
