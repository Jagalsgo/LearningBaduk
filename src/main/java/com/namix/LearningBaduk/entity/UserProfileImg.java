package com.namix.LearningBaduk.entity;

public class UserProfileImg {

	private int userProfieImgId;
	private String imgName;
	private String imgPath;
	private String userId;
	
	public UserProfileImg() {
		
	}
	
	public UserProfileImg(int userProfileImgId, String imgName, String imgPath, String userId) {
		this.userProfieImgId = userProfileImgId;
		this.imgName = imgName;
		this.imgPath = imgPath;
		this.userId = userId;
	}

	public int getUserProfieImgId() {
		return userProfieImgId;
	}

	public void setUserProfieImgId(int userProfieImgId) {
		this.userProfieImgId = userProfieImgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
