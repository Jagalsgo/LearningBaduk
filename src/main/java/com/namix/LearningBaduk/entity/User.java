package com.namix.LearningBaduk.entity;

public class User {

	private String userId;
	private String userpassword;
	private String userNickname;
	private String userEmail;
	private String userProfileImg;
	private int userReport;
	private String userRole;
	
	public User() {
		
	}

	public User(String userId, String userpassword, String userNickname, String userEmail, String userProfileImg,
			int userReport, String userRole) {
		this.userId = userId;
		this.userpassword = userpassword;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userProfileImg = userProfileImg;
		this.userReport = userReport;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserProfileImg() {
		return userProfileImg;
	}

	public void setUserProfileImg(String userProfileImg) {
		this.userProfileImg = userProfileImg;
	}

	public int getUserReport() {
		return userReport;
	}

	public void setUserReport(int userReport) {
		this.userReport = userReport;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
