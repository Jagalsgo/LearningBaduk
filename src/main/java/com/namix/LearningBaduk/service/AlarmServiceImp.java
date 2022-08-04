package com.namix.LearningBaduk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namix.LearningBaduk.dao.AlarmDao;
import com.namix.LearningBaduk.entity.AlarmView;

@Service
public class AlarmServiceImp implements AlarmService {

	@Autowired
	AlarmDao alarmDao;
	
	@Override
	public List<AlarmView> getAlarms(String receiver) {
		return alarmDao.getAlarms(receiver);
	}

	@Override
	public int getAlarmCount(String receiver) {
		return alarmDao.getAlarmCount(receiver);
	}

	@Override
	public int deleteAlarm(int alarmId) {
		return alarmDao.deleteAlarm(alarmId);
	}

	@Override
	public int deleteAllAlarm(String receiver) {
		return alarmDao.deleteAllAlarm(receiver);
	}

}
