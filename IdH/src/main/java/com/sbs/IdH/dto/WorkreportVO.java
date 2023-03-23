package com.sbs.IdH.dto;

import java.util.Date;
import java.util.List;

public class WorkreportVO {
	private int workreport_number;
	private int workreport_project_number;
	private String workreport_setter;//보낸사람
	private int workreport_check;
	private Date workreport_regdate;
	private Date workreport_enddate;
	private String workreport_getter;//받는사람
	private String workreport_title;
	private String workreport_content;
	private int workreport_memstatus;
	private List<Workreport_AttachVO>attachList;

	public int getWorkreport_memstatus() {
		return workreport_memstatus;
	}

	public void setWorkreport_memstatus(int workreport_memstatus) {
		this.workreport_memstatus = workreport_memstatus;
	}

	public String getWorkreport_content() {
		return workreport_content;
	}

	public void setWorkreport_content(String workreport_content) {
		this.workreport_content = workreport_content;
	}

	public String getWorkreport_title() {
		return workreport_title;
	}

	public void setWorkreport_title(String workreport_title) {
		this.workreport_title = workreport_title;
	}

	public List<Workreport_AttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<Workreport_AttachVO> attachList) {
		this.attachList = attachList;
	}

	public int getWorkreport_number() {
		return workreport_number;
	}

	public void setWorkreport_number(int workreport_number) {
		this.workreport_number = workreport_number;
	}

	public int getWorkreport_project_number() {
		return workreport_project_number;
	}

	public void setWorkreport_project_number(int workreport_project_number) {
		this.workreport_project_number = workreport_project_number;
	}

	public String getWorkreport_setter() {
		return workreport_setter;
	}

	public void setWorkreport_setter(String workreport_setter) {
		this.workreport_setter = workreport_setter;
	}

	public int getWorkreport_check() {
		return workreport_check;
	}

	public void setWorkreport_check(int workreport_check) {
		this.workreport_check = workreport_check;
	}

	public Date getWorkreport_regdate() {
		return workreport_regdate;
	}

	public void setWorkreport_regdate(Date workreport_regdate) {
		this.workreport_regdate = workreport_regdate;
	}

	public Date getWorkreport_enddate() {
		return workreport_enddate;
	}

	public void setWorkreport_enddate(Date workreport_enddate) {
		this.workreport_enddate = workreport_enddate;
	}

	public String getWorkreport_getter() {
		return workreport_getter;
	}

	public void setWorkreport_getter(String workreport_getter) {
		this.workreport_getter = workreport_getter;
	}

	public WorkreportVO() {
	}

	public WorkreportVO(int workreport_number, int workreport_project_number, String workreport_setter,
			int workreport_check, Date workreport_regdate, Date workreport_enddate, String workreport_getter,
			String workreport_title, String workreport_content, List<Workreport_AttachVO> attachList,
			int workreport_memstatus) {
		super();
		this.workreport_number = workreport_number;
		this.workreport_project_number = workreport_project_number;
		this.workreport_setter = workreport_setter;
		this.workreport_check = workreport_check;
		this.workreport_regdate = workreport_regdate;
		this.workreport_enddate = workreport_enddate;
		this.workreport_getter = workreport_getter;
		this.workreport_title = workreport_title;
		this.workreport_content = workreport_content;
		this.attachList = attachList;
		this.workreport_memstatus = workreport_memstatus;
	}

	

}
