package com.sbs.IdH.dto;

import java.util.Date;

public class Work_AttachVO {
	private int ano;
	private String uploadPath;
	private String fileName;
	private String fileType;
	private int work_number;
	private String work_attach_attacher; 
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
	public int getWork_number() {
		return work_number;
	}
	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}
	public String getWork_attach_attacher() {
		return work_attach_attacher;
	}
	public void setWork_attach_attacher(String work_attach_attacher) {
		this.work_attach_attacher = work_attach_attacher;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
