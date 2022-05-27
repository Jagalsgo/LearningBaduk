package com.namix.LearningBaduk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardView> getBoards(String category, int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size;
		
		return boardDao.getBoards(category, offset, size, field, query);
	}
	
	@Override
	public int getPageCount(String category) {
		return getPageCount(category, "boardTitle", "");
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDao.getPageCount(category, field, query);
	}

	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return boardDao.writeDetail(category, title, content, userId);
	}

	@Override
	public BoardView getDetailBoard(int id) {
		return boardDao.getDetailBoard(id);
	}

	@Override
	public int updateDetail(int id, String title, String content) {
		return boardDao.updateDetail(id, title, content);
	}

	@Override
	public int deleteDetail(int id) {
		return boardDao.deleteDetail(id);
	}

	@Override
	public List<Comment> getComments(int id) {
		return boardDao.getComments(id);
	}

	@Override
	public int getCommentCount(int id) {
		return boardDao.getCommentCount(id);
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDao.getUsersLastBoardId(userId);
	}

	@Override
	public void addHit(int id) {
		boardDao.addHit(id);
		
	}

	@Override
	public String getBoardsUser(int id) {
		return boardDao.getBoardsUser(id);
	}
	
	@Override
	public int likeClicked(int id, String userId) {
		return boardDao.likeClicked(id, userId);
	}

	@Override
	public int DislikeClicked(int id, String userId) {
		return boardDao.dislikeClicked(id, userId);
	}
	
	@Override
	public int addLike(int id, String userId) {
		return boardDao.addLike(id, userId);
	}

	@Override
	public int addDislike(int id, String userId) {
		return boardDao.addDislike(id, userId);
	}

	@Override
	public int getLikeCount(int id) {
		return boardDao.getLikeCount(id);
	}


	@Override
	public int getDislikeCount(int id) {
		return boardDao.getDislikeCount(id);
	}


}
