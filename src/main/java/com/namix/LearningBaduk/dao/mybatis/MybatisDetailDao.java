package com.namix.LearningBaduk.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.DetailDao;

@Repository
public class MybatisDetailDao implements DetailDao {

	private DetailDao detailDaoMapper;

	@Autowired
	public MybatisDetailDao(SqlSession sqlsession) {
		detailDaoMapper = sqlsession.getMapper(DetailDao.class);
	}
	
	@Override
	public int writeDetail(String category, String title, String content, String userId) {
		return detailDaoMapper.writeDetail(category, title, content, userId);
	}

	@Override
	public int writeMyDetail(String title, String content, String userId) {
		return detailDaoMapper.writeMyDetail(title, content, userId);
	}

	@Override
	public int updateDetail(int id, String title, String content) {
		return detailDaoMapper.updateDetail(id, title, content);
	}
	
	@Override
	public int updateMyDetail(int id, String title, String content) {
		return detailDaoMapper.updateMyDetail(id, title, content);
	}

	@Override
	public int deleteDetail(int id) {
		return detailDaoMapper.deleteDetail(id);
	}

	@Override
	public int deleteMyDetail(int id) {
		return detailDaoMapper.deleteMyDetail(id);
	}

	@Override
	public int likeClicked(int id, String userId) {
		return detailDaoMapper.likeClicked(id, userId);
	}

	@Override
	public int dislikeClicked(int id, String userId) {
		return detailDaoMapper.dislikeClicked(id, userId);
	}

	@Override
	public int addLike(int id, String userId) {
		return detailDaoMapper.addLike(id, userId);
	}

	@Override
	public int addDislike(int id, String userId) {
		return detailDaoMapper.addDislike(id, userId);
	}

	@Override
	public int getLikeCount(int id) {
		return detailDaoMapper.getLikeCount(id);
	}

	@Override
	public int getDislikeCount(int id) {
		return detailDaoMapper.getDislikeCount(id);
	}

	@Override
	public void addHit(int id) {
		detailDaoMapper.addHit(id);

	}

}
