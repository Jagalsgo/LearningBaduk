package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.BoardDao;
import com.namix.LearningBaduk.entity.BoardView;
import com.namix.LearningBaduk.entity.Comment;

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
	public List<Comment> getComments(int id) {
		return boardDaoMapper.getComments(id);
	}

	@Override
	public int getCommentCount(int id) {
		return boardDaoMapper.getCommentCount(id);
	}

	@Override
	public int getUsersLastBoardId(String userId) {
		return boardDaoMapper.getUsersLastBoardId(userId);
	}

}
