package com.namix.LearningBaduk.entity;

public class User  {

	private String userId;
	private String userPassword;
	private String userNickname;
	private String userEmail;
	private int userReport;
	private String userRole;
	
	public User() {
		
	}

	public User(String userId, String userPassword, String userNickname, String userEmail, int userReport, String userRole) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userReport = userReport;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
