package com.namix.LearningBaduk.service;

import java.util.List;

import com.namix.LearningBaduk.entity.AlarmView;

public interface AlarmService {

	// get alarm
	List<AlarmView> getAlarms(String receiver);
	
	int getAlarmCount(String receiver);

	// delete alarm
	int deleteAlarm(int alarmId);

	int deleteAllAlarm(String receiver);
	
}
