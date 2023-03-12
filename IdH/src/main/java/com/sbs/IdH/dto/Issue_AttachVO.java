package com.sbs.IdH.dto;

import java.util.Date;

public class Issue_AttachVO {
	private int ano;
	private String uploadPath;
	private String fileName;
	private String fileType;
	private int issue_number;
	private String issue_attach_attacher; 
	private Date regDate;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getIssue_number() {
		return issue_number;
	}
	public void setIssue_number(int issue_number) {
		this.issue_number = issue_number;
	}
	public String getIssue_attach_attacher() {
		return issue_attach_attacher;
	}
	public void setIssue_attach_attacher(String issue_attach_attacher) {
		this.issue_attach_attacher = issue_attach_attacher;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
