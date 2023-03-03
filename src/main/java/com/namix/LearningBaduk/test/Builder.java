package com.namix.LearningBaduk.test;

import com.namix.LearningBaduk.entity.Alarm;

public class Builder {
	
	public void build() {
		
		
		  Alarm alarm1 = Alarm.builder() .alarmType("type1") .receiver("receiver")
		  .sender("sender") .build();
		  
		  System.out.println("alarm1 = " + alarm1);
		  
		  Alarm alarm2 = Alarm.builder() .alarmType("type2") .receiver("receiver2")
		  .sender("sender2") .build();
		  
		  System.out.println("alarm2 = " + alarm2);
		 
		
		System.out.println("AAA");

	}
	
}
