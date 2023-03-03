package com.namix.LearningBaduk.entity;

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
public class UserProfileImg {

	private int userProfieImgId;
	private String imgName;
	private String imgPath;
	private String userId;
	
}
