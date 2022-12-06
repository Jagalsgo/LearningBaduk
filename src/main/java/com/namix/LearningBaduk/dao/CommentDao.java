package com.namix.LearningBaduk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;

@Mapper
public interface CommentDao {

	List<CommentView> getComments(int id, int size, int offset);

	Comment getComment(int id);

	int getCommentCount(int id);

	int postComment(Comment comment);

	int postReComment(Comment comment);

	int deleteComment(int cid);

	int getChildCount(int cid);

	int setCommentDeletedTrue(int cid);

	int setCommentGroup(int commentId, int commentGroup);

	int getCommentCurrentPage(int commentId, int boardId);

	int deleteAllComment(int boardId);

}
