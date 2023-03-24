package com.sbs.IdH.command;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.Issue_AttachVO;

public class IssueRegistCommand {

	private int issue_number;
	private String issue_title;
	private String issue_content;
	private int issue_level;
	private Date issue_regdate;
	private String issue_setter_id;
	private int issue_project_number;
	private String issue_getter_id;
	private List<MultipartFile> uploadFile;
	private int issue_status;
	

	public int getIssue_number() {
		return issue_number;
	}

	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}

	public int getIssue_level() {
		return issue_level;
	}

	public void setIssue_level(int issue_level) {
		this.issue_level = issue_level;
	}

	public Date getIssue_regdate() {
		return issue_regdate;
	}

	public void setIssue_regdate(Date issue_regdate) {
		this.issue_regdate = issue_regdate;
	}

	public int getIssue_project_number() {
		return issue_project_number;
	}

	public void setIssue_project_number(int issue_project_number) {
		this.issue_project_number = issue_project_number;
	}

	

	public int getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(int issue_status) {
		this.issue_status = issue_status;
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

	public String getIssue_setter_id() {
		return issue_setter_id;
	}

	public void setIssue_setter_id(String issue_setter_id) {
		this.issue_setter_id = issue_setter_id;
	}

	public String getIssue_getter_id() {
		return issue_getter_id;
	}

	public void setIssue_getter_id(String issue_getter_id) {
		this.issue_getter_id = issue_getter_id;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}


	public IssueVO toIssueVO(){
		IssueVO issue = new IssueVO();
		issue.setIssue_title(issue_title);
		issue.setIssue_content(this.issue_content);
		issue.setIssue_setter_id(this.issue_setter_id);
		issue.setIssue_getter_id(this.issue_getter_id);
		issue.setIssue_level(this.issue_level);
		issue.setIssue_project_number(this.issue_project_number);
		issue.setIssue_status(this.issue_status);
				
		return issue;
	}

	
}






