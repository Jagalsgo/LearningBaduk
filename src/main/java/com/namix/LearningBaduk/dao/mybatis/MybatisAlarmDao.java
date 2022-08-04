package com.namix.LearningBaduk.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namix.LearningBaduk.dao.AlarmDao;
import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;

@Repository
public class MybatisAlarmDao implements AlarmDao {

	private AlarmDao alarmDaoMapper;

	@Autowired
	public MybatisAlarmDao(SqlSession sqlsession) {
		alarmDaoMapper = sqlsession.getMapper(AlarmDao.class);
	}

	@Override
	public List<AlarmView> getAlarms(String receiver) {
		return alarmDaoMapper.getAlarms(receiver);
	}

	@Override
	public int getAlarmCount(String receiver) {
		return alarmDaoMapper.getAlarmCount(receiver);
	}

	@Override
	public int addCommentAlarm(String receiver, String sender, int boardId, int commentId) {
		return alarmDaoMapper.addCommentAlarm(receiver, sender, boardId, commentId);
	}

	@Override
	public int addReCommentAlarm(String receiver, String sender, int commentId, int boardId) {
		return alarmDaoMapper.addReCommentAlarm(receiver, sender, commentId, boardId);
	}

	@Override
	public int addMessageAlarm(Message message) {
		return alarmDaoMapper.addMessageAlarm(message);
	}

	@Override
	public int deleteAlarm(int alarmId) {
		return alarmDaoMapper.deleteAlarm(alarmId);
	}

	@Override
	public int deleteAllAlarm(String receiver) {
		return alarmDaoMapper.deleteAllAlarm(receiver);
	}

}
