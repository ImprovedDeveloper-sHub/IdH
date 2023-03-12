package com.sbs.IdH.dto;

import java.util.Calendar;
import java.util.Date;

public class Notice_attachVO {
	
	private int ano;
	private String uploadpath;
	private String filename;
	private String filetype;
	private Date regdate;
	private int notice_number;
	private String notice_attach_attacher;

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

	public int getnotice_number() {
		return notice_number;
	}

	public void setnotice_number(int notice_number) {
		this.notice_number = notice_number;
	}

	public String getNotice_attach_attacher() {
		return notice_attach_attacher;
	}

	public void setNotice_attach_attacher(String notice_attach_attacher) {
		this.notice_attach_attacher = notice_attach_attacher;
	}

	@Override
	public String toString() {
		return "Notice_attach [ano=" + ano + ", uploadpath=" + uploadpath + ", filename=" + filename + ", filetype="
				+ filetype + ", regdate=" + regdate + ", notice_number=" + notice_number
				+ ", notice_attach_attacher=" + notice_attach_attacher + "]";
	}
	
	/*
	 * public Notice_attachVO(int ano, String uploadpath, String filename, String
	 * filetype, Date regdate, int notice_number, String notice_attach_attacher) {
	 * super(); this.ano = ano; this.uploadpath = uploadpath; this.filename =
	 * filename; this.filetype = filetype; this.regdate = regdate;
	 * this.notice_number = notice_number; this.notice_attach_attacher =
	 * notice_attach_attacher; }
	 * 
	 * public Notice_attachVO testNotice_attachSample() {
	 * 
	 * Calendar cal = Calendar.getInstance(); cal.set(2199, 13, 31);
	 * 
	 * Notice_attachVO testNotice_attach = new Notice_attachVO(9, "첨부경로", "첨부예시",
	 * "첨부형식", new Date(cal.getTimeInMillis()), 999, "IdH");
	 * 
	 * return testNotice_attach;
	 * 
	 * }
	 */

}
