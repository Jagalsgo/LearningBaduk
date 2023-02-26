package com.namix.LearningBaduk.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DetailService {

	int writeDetail(String category, String title, String content, String userId);
	int writeMyDetail(String title, String content, String userId);

	int updateDetail(int id, String title, String content);
	int updateMyDetail(int id, String title, String content);

	int deleteDetail(int id);
	int deleteMyDetail(int id);

	int isLikeClicked(int id, String userId);
	int isDislikeClicked(int id, String userId);

	int addLike(int id, String userId);
	int addDislike(int id, String userId);

	void addHit(int id);
	
	int getLikeCount(int id);
	int getDislikeCount(int id);

	int getDetailsPage(int id, String category);
	int getMyDetailsPage(int id, String userId);

	void checkCookieBeforeAddHit(HttpServletRequest request, HttpServletResponse response, int id);

}
