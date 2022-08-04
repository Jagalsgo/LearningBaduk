package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.CommentDao;
import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;

@Repository
public class MybatisCommentDao implements CommentDao {

	private CommentDao commentDaoMapper;

	@Autowired
	public MybatisCommentDao(SqlSession sqlsession) {
		commentDaoMapper = sqlsession.getMapper(CommentDao.class);
	}
	
	@Override
	public List<CommentView> getComments(int id, int size, int offset) {
		return commentDaoMapper.getComments(id, size, offset);
	}

	@Override
	public Comment getComment(int id) {
		return commentDaoMapper.getComment(id);
	}

	@Override
	public int getCommentCount(int id) {
		return commentDaoMapper.getCommentCount(id);
	}

	@Override
	public int postComment(Comment comment) {
		return commentDaoMapper.postComment(comment);
	}

	@Override
	public int postReComment(Comment comment) {
		return commentDaoMapper.postReComment(comment);
	}

	@Override
	public int deleteComment(int cid) {
		return commentDaoMapper.deleteComment(cid);
	}

	@Override
	public int getChildCount(int cid) {
		return commentDaoMapper.getChildCount(cid);
	}

	@Override
	public int setCommentDeletedTrue(int cid) {
		return commentDaoMapper.setCommentDeletedTrue(cid);
	}

	@Override
	public int setCommentGroup(int commentId, int commentGroup) {
		return commentDaoMapper.setCommentGroup(commentId, commentGroup);
	}

	@Override
	public int getCommentCurrentPage(int commentId, int boardId) {
		return commentDaoMapper.getCommentCurrentPage(commentId, boardId);
	}

}
