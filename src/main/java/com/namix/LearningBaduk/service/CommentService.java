package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.Comment;
import com.namix.LearningBaduk.entity.CommentView;

public interface CommentService {

	// get comment
	List<CommentView> getComments(int id);

	List<CommentView> getComments(int id, int page);

	Comment getComment(int id);

	int getCommentCount(int id);

	// post comment
	Comment postComment(String userId, String commentContent, int id, String receiver);

	Comment postReComment(String userId, String reCommentContent, int boardId, int parentId, String receiver);

	// delete comment
	int deleteComment(int cid);

	void deleteComments(List<Integer> chkArray);

	int getCommentCurrentPage(int commentId, int boardId);

	void deleteAllComment(int boardId);

}
