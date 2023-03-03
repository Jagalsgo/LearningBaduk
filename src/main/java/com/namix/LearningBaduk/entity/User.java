package com.namix.LearningBaduk.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private String userId;
	private String userPassword;
	private String userNickname;
	private String userEmail;
	private int userReport;
	private String userRole;
	private Date userDate;
	private String userProfileImg;
	private boolean emailAuth;


	public boolean isEmailAuth() {
		return emailAuth;
	}

}
