package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.MyBoard;

@Repository
public class MybatisBoardDao implements BoardDao {

	private BoardDao boardDaoMapper;
	
	@Autowired
	public MybatisBoardDao(SqlSession sqlsession) {
		boardDaoMapper = sqlsession.getMapper(BoardDao.class);
	}
	
	@Override
	public List<BoardView> getBoards(String category, int offset, int size, String field, String query) {
		return boardDaoMapper.getBoards(category, offset, size, field, query);
	}

	@Override
	public int getPageCount(String category, String field, String query) {
		return boardDaoMapper.getPageCount(category, field, query);
	}

	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return boardDaoMapper.writeDetail(category, title, content, userId);
	}

	@Override
	public BoardView getDetailBoard(int id) {
		return boardDaoMapper.getDetailBoard(id);
	}

	@Override
	public int updateDetail(int id, String title, String content) {
		return boardDaoMapper.updateDetail(id, title, content);
	}

	@Override
	public int deleteDetail(int id) {
		return boardDaoMapper.deleteDetail(id);
	}

	@Override
	public List<Comment> getComments(int id, int size, int offset) {
		return boardDaoMapper.getComments(id, size, offset);
	}

	@Override
	public int getCommentCount(int id) {
		return boardDaoMapper.getCommentCount(id);
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDaoMapper.getUsersLastBoardId(userId);
	}

	@Override
	public void addHit(int id) {
		boardDaoMapper.addHit(id);
		
	}

	@Override
	public String getBoardsUser(int id) {
		return boardDaoMapper.getBoardsUser(id);
	}

	@Override
	public int likeClicked(int id, String userId) {
		return boardDaoMapper.likeClicked(id, userId);
	}
	
	@Override
	public int dislikeClicked(int id, String userId) {
		return boardDaoMapper.dislikeClicked(id, userId);
	}

	@Override
	public int addLike(int id, String userId) {
		return boardDaoMapper.addLike(id, userId);
	}

	@Override
	public int addDislike(int id, String userId) {
		return boardDaoMapper.addDislike(id, userId);
	}

	@Override
	public int getLikeCount(int id) {
		return boardDaoMapper.getLikeCount(id);
	}


	@Override
	public int getDislikeCount(int id) {
		return boardDaoMapper.getDislikeCount(id);
	}

	@Override
	public int postComment(String userId, String commentContent, int id) {
		return boardDaoMapper.postComment(userId, commentContent, id);
	}

	@Override
	public int deleteComment(int cid) {
		return boardDaoMapper.deleteComment(cid);
	}

	@Override
	public int getDetailsRowNumber(int id) {
		return boardDaoMapper.getDetailsRowNumber(id);
	}

	@Override
	public List<BoardView> getMyWritingBoards(int page, String query, String userId, int size, int offset) {
		return boardDaoMapper.getMyWritingBoards(page, query, userId, size, offset);
	}

	@Override
	public int getMyWritingPageCount(String query, String userId) {
		return boardDaoMapper.getMyWritingPageCount(query, userId);
	}

	@Override
	public List<BoardView> getMyOwnBoards(Integer page, String query, String userId, int size, int offset) {
		return boardDaoMapper.getMyOwnBoards(page, query, userId, size, offset);
	}

	@Override
	public int getMyOwnPageCount(String query, String userId) {
		return boardDaoMapper.getMyOwnPageCount(query, userId);
	}

	@Override
	public int writeMyDetail(String title, String content, String userId) {
		return boardDaoMapper.writeMyDetail(title, content, userId);
	}

	@Override
	public int getUsersLastMyBoardId(String userId) {
		return boardDaoMapper.getUsersLastMyBoardId(userId);
	}

	@Override
	public MyBoard getMyDetailBoard(int id) {
		return boardDaoMapper.getMyDetailBoard(id);
	}

	@Override
	public int getMyDetailsRowNumber(int id) {
		return boardDaoMapper.getMyDetailsRowNumber(id);
	}

}
