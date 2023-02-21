package com.namix.LearningBaduk.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void addHit(int id) {
		detailDao.addHit(id);
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
	public int getDetailsPage(int id, String category) {

		int detailsRowNumber = boardDao.getDetailsRowNumber(id, category) - 1;
		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public int getMyDetailsPage(int id, String userId) {

		int detailsRowNumber = boardDao.getMyDetailsRowNumber(id, userId) - 1;
		int detailsPage = (int) (Math.ceil(detailsRowNumber / 10) * 10) / 10 + 1;

		if (detailsPage <= 1) {
			detailsPage = 1;
		}

		return detailsPage;
	}

	@Override
	public void checkCookieBeforeAddHit(HttpServletRequest request, HttpServletResponse response, int id) {

		Cookie[] cookies = request.getCookies();
		Cookie viewCookie = null;

		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookie" + id)) {
					viewCookie = cookies[i];
				}
			}
		}
		if (viewCookie == null) {
			Cookie newCookie = new Cookie("cookie" + id, "|" + id + "|");
			response.addCookie(newCookie);
			addHit(id);
		}

	}

}
