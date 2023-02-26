package com.namix.LearningBaduk.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailDao {

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

	int getLikeCount(int id);

	int getDislikeCount(int id);

	void addHit(int id);

}
