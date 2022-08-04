package com.namix.LearningBaduk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.dao.DetailDao;

@Service
public class DetailServiceImp implements DetailService {

	@Autowired
	DetailDao detailDao;
	@Autowired
	BoardDao boardDao;
	
	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return detailDao.writeDetail(category, title, content, userId);
	}

	@Override
	public int writeMyDetail(String title, String content, String userId) {
		return detailDao.writeMyDetail(title, content, userId);
	}

	@Override
	public int updateDetail(int id, String title, String content) {
		return detailDao.updateDetail(id, title, content);
	}

	@Override
	public int updateMyDetail(int id, String title, String content) {
		return detailDao.updateMyDetail(id, title, content);
	}

	@Override
	public int deleteDetail(int id) {
		return detailDao.deleteDetail(id);
	}

	@Override
	public int deleteMyDetail(int id) {
		return detailDao.deleteMyDetail(id);
	}

	@Override
	public int likeClicked(int id, String userId) {
		return detailDao.likeClicked(id, userId);
	}

	@Override
	public int DislikeClicked(int id, String userId) {
		return detailDao.dislikeClicked(id, userId);
	}

	@Override
	public int addLike(int id, String userId) {
		return detailDao.addLike(id, userId);
	}

	@Override
	public int addDislike(int id, String userId) {
		return detailDao.addDislike(id, userId);
	}

	@Override
	public int getLikeCount(int id) {
		return detailDao.getLikeCount(id);
	}

	@Override
	public int getDislikeCount(int id) {
		return detailDao.getDislikeCount(id);
	}

	@Override
	public int getDetailsPage(int id) {

		int detailsRowNumber = boardDao.getDetailsRowNumber(id) - 1;
		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public void addHit(int id) {
		detailDao.addHit(id);

	}

}
