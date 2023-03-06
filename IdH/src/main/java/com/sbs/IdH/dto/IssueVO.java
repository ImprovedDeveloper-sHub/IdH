package com.sbs.IdH.dto;

import java.util.Date;

public class IssueVO {
	private int issue_number;
	private String issue_title;
	private String issue_content;
	private int issue_level;
	private Date issue_regdate;
	private String issue_setter_id;
	private int issue_project_number;
	private String issue_getter_id;
	
	public int getIssue_number() {
		return issue_number;
	}
	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}
	public String getIssue_title() {
		return issue_title;
	}
	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}
	public String getIssue_content() {
		return issue_content;
	}
	public void setIssue_content(String issue_content) {
		this.issue_content = issue_content;
	}
	public int getIssue_level() {
		return issue_level;
	}
	public void setIssue_level(int issue_level) {
		this.issue_level = issue_level;
	}
	public Date getIssue_regDate() {
		return issue_regdate;
	}
	public void setIssue_regDate(Date issue_regDate) {
		this.issue_regdate = issue_regDate;
	}
	public String getIssue_setter_id() {
		return issue_setter_id;
	}
	public void setIssue_setter_id(String issue_setter_id) {
		this.issue_setter_id = issue_setter_id;
	}
	public int getIssue_project_number() {
		return issue_project_number;
	}
	public void setIssue_project_number(int issue_project_number) {
		this.issue_project_number = issue_project_number;
	}
	public String getIssue_getter_id() {
		return issue_getter_id;
	}
	public void setIssue_getter_id(String issue_getter_id) {
		this.issue_getter_id = issue_getter_id;
	}
	public IssueVO() {}
	public IssueVO(int issue_number, String issue_title, String issue_content, int issue_level,
			Date issue_regdate, String issue_setter_id, int issue_project_number, String issue_getter_id) {
		super();
		this.issue_number = issue_number;
		this.issue_title = issue_title;
		this.issue_content = issue_content;
		this.issue_level = issue_level;
		this.issue_regdate = issue_regdate;
		this.issue_regdate = issue_regdate;
		this.issue_setter_id = issue_setter_id;
		this.issue_project_number = issue_project_number;
		this.issue_getter_id = issue_getter_id;
	}
	
}
