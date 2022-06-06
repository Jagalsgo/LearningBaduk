package com.namix.LearningBaduk.entity;

public class CommentView extends Comment {

	private String imgPath;
	private String userNickname;
	
	public CommentView() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentView(String imgPath, String userNickname) {
		this.imgPath = imgPath;
		this.userNickname = userNickname;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
}
