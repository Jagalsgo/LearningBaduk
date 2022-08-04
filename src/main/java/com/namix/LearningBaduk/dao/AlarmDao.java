package com.namix.LearningBaduk.dao;

import java.util.List;

import com.namix.LearningBaduk.entity.AlarmView;
import com.namix.LearningBaduk.entity.Message;

public interface AlarmDao {

	List<AlarmView> getAlarms(String receiver);

	int getAlarmCount(String receiver);

	int addCommentAlarm(String receiver, String sender, int boardId, int commentId);

	int addReCommentAlarm(String receiver, String sender, int commentId, int boardId);

	int addMessageAlarm(Message message);

	int deleteAlarm(int alarmId);

	int deleteAllAlarm(String receiver);

}
