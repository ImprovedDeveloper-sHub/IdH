package com.sbs.IdH.dto;

import java.util.Calendar;
import java.util.Date;

public class Business_attachVO {
	
	private int ano;
	private String uploadpath;
	private String filename;
	private String filetype;
	private Date regdate;
	private int business_number;
	private String business_attach_attacher;

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

	public int getbusiness_number() {
		return business_number;
	}

	public void setbusiness_number(int business_number) {
		this.business_number = business_number;
	}

	public String getBusiness_attach_attacher() {
		return business_attach_attacher;
	}

	public void setBusiness_attach_attacher(String business_attach_attacher) {
		this.business_attach_attacher = business_attach_attacher;
	}

	@Override
	public String toString() {
		return "Business_attachVO [ano=" + ano + ", uploadpath=" + uploadpath + ", filename=" + filename + ", filetype="
				+ filetype + ", regdate=" + regdate + ", business_number=" + business_number
				+ ", business_attach_attacher=" + business_attach_attacher + "]";
	}
	
	public Business_attachVO() {}

	public Business_attachVO(int ano, String uploadpath, String filename, String filetype, Date regdate,
			int business_number, String business_attach_attacher) {
		super();
		this.ano = ano;
		this.uploadpath = uploadpath;
		this.filename = filename;
		this.filetype = filetype;
		this.regdate = regdate;
		this.business_number = business_number;
		this.business_attach_attacher = business_attach_attacher;
	}
	
	public Business_attachVO testBusiness_attachSample() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2199, 13, 31);
		
		Business_attachVO testBusiness_attach = new Business_attachVO(9, "첨부경로", "첨부예시", "첨부형식", new Date(cal.getTimeInMillis()), 999, "IdH");
		
		return testBusiness_attach;
		
	}
	
}
