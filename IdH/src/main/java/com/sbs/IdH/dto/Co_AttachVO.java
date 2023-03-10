package com.sbs.IdH.dto;

import java.util.Date;

public class Co_AttachVO {
	
	private int ano; 			 //고유번호
	private String uploadPath;	 //저장경로
	private String fileName;  	 //파일명
	private String fileType;
	private Date regDate;
	private int co_number;          	
	private String co_attach_attacher;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCo_number() {
		return co_number;
	}
	public void setCo_number(int co_number) {
		this.co_number = co_number;
	}
	public String getCo_attach_attacher() {
		return co_attach_attacher;
	}
	public void setCo_attach_attacher(String co_attach_attacher) {
		this.co_attach_attacher = co_attach_attacher;
	} 	
	    	
	
}
