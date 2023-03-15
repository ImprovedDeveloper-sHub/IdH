package com.sbs.IdH.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sbs.IdH.dto.IssueVO;

public class IssueRegistCommand {

	private String issue_title;
	private String issue_content;
	private String issue_setter_id;
	private String issue_getter_id;
	private List<MultipartFile> uploadFile;
	

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
		
		return issue;
	}
}






