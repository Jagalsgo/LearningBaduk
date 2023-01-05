package com.namix.LearningBaduk.service;

public interface DetailService {

	// write detail
	int writeDetail(String category, String title, String content, String userId);

	int writeMyDetail(String title, String content, String userId);

	// update detail
	int updateDetail(int id, String title, String content);

	int updateMyDetail(int id, String title, String content);

	// delete detail
	int deleteDetail(int id);

	int deleteMyDetail(int id);

	// like, dislike
	int likeClicked(int id, String userId);

	int DislikeClicked(int id, String userId);

	int addLike(int id, String userId);

	int addDislike(int id, String userId);

	int getLikeCount(int id);

	int getDislikeCount(int id);

	int getDetailsPage(int id, String category);

	void addHit(int id);

	int getMyDetailsPage(int id, String userId);

}
