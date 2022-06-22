package com.namix.LearningBaduk.entity;

import java.util.Date;

public class ReportList {

	private int reportId;
	private String reportContent;
	private String reportedUser;
	private String reporter;
	private String reportType;
	private Date reportDate;

	public ReportList() {

	}

	public ReportList(int reportId, String reportContent, String reportedUser, String reporter, String reportType,
			Date reportDate) {
		this.reportId = reportId;
		this.reportContent = reportContent;
		this.reportedUser = reportedUser;
		this.reporter = reporter;
		this.reportType = reportType;
		this.reportDate = reportDate;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportedUser() {
		return reportedUser;
	}

	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

}
