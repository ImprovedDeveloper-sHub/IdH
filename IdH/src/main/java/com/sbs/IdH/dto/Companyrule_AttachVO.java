package com.sbs.IdH.dto;

import java.util.Date;

public class Companyrule_AttachVO {
	
	private int ano; 			 //고유번호
	private String uploadPath;	 //저장경로
	private String fileName;  	 //파일명
	private String fileType; 	 //파일형식
	private int companyrule_attach_number;          	 //자료실 글번호
	private String companyrule_attach_attacher; 	 //등록자
	private Date regDate;    	 //등록일
	
	
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
	public int getCompanyrule_attach_number() {
		return companyrule_attach_number;
	}
	public void setCompanyrule_attach_number(int companyrule_attach_number) {
		this.companyrule_attach_number =companyrule_attach_number;
	}
	public String getCompanyrule_attach_attacher() {
		return companyrule_attach_attacher;
	}
	public void setCompanyrule_attach_attacher(String companyrule_attach_attacher) {
		this.companyrule_attach_attacher = companyrule_attach_attacher;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}


