package com.sbs.IdH.dto;

import java.util.Date;

public class Workreport_AttachVO {
	private int ano;
	private String uploadPath;
	private String fileName;
	private String fileType;
	private int workreport_number;
	private String workreport_attach_attacher; 
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
	public int getWorkreport_number() {
		return workreport_number;
	}
	public void setWorkreport_number(int workreport_number) {
		this.workreport_number = workreport_number;
	}
	public String getWorkreport_attach_attacher() {
		return workreport_attach_attacher;
	}
	public void setWorkreport_attach_attacher(String workreport_attach_attacher) {
		this.workreport_attach_attacher = workreport_attach_attacher;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
