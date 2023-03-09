package com.sbs.IdH.dto;

import java.util.Date;

public class Require_attachVO {
	
	private int ano;
	private String uploadpath;
	private String filename;
	private String filetype;
	private Date regdate;
	private int require_attach_number;
	private String require_attach_attacher;
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRequire_attach_number() {
		return require_attach_number;
	}
	public void setRequire_attach_number(int require_attach_number) {
		this.require_attach_number = require_attach_number;
	}
	public String getRequire_attach_attacher() {
		return require_attach_attacher;
	}
	public void setRequire_attach_attacher(String require_attach_attacher) {
		this.require_attach_attacher = require_attach_attacher;
	}
	
	

}
