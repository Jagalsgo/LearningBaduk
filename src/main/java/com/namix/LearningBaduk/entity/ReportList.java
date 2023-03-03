package com.namix.LearningBaduk.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportList {

	private int reportId;
	private String reportContent;
	private String reportedUser;
	private String reporter;
	private String reportType;
	private Date reportDate;

}
