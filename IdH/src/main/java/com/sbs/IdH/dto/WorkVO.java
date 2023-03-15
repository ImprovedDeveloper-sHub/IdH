package com.sbs.IdH.dto;

import java.util.Date;
import java.util.List;

public class WorkVO {
	private int work_number;
	private int work_project_number;
	private String work_member_id;//보낸사람
	private int work_check;
	private Date work_regdate;
	private Date work_enddate;
	private String work_member_approver;//받는사람
	private String work_title;
	private String work_content;
	//private List<Work_AttachVO>attachList;

	public String getWork_content() {
		return work_content;
	}

	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}

	public String getWork_title() {
		return work_title;
	}

	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}

	/*
	 * public List<Work_AttachVO> getAttachList() { return attachList; }
	 * 
	 * public void setAttachList(List<Work_AttachVO> attachList) { this.attachList =
	 * attachList; }
	 */

	public int getWork_number() {
		return work_number;
	}

	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}

	public int getWork_project_number() {
		return work_project_number;
	}

	public void setWork_project_number(int work_project_number) {
		this.work_project_number = work_project_number;
	}

	public String getWork_member_id() {
		return work_member_id;
	}

	public void setWork_member_id(String work_member_id) {
		this.work_member_id = work_member_id;
	}

	public int getWork_check() {
		return work_check;
	}

	public void setWork_check(int work_check) {
		this.work_check = work_check;
	}

	public Date getWork_regdate() {
		return work_regdate;
	}

	public void setWork_regdate(Date work_regdate) {
		this.work_regdate = work_regdate;
	}

	public Date getWork_enddate() {
		return work_enddate;
	}

	public void setWork_enddate(Date work_enddate) {
		this.work_enddate = work_enddate;
	}

	public String getWork_member_approver() {
		return work_member_approver;
	}

	public void setWork_member_approver(String work_member_approver) {
		this.work_member_approver = work_member_approver;
	}

	public WorkVO() {
	}

	/*
	 * public WorkVO(int work_number, int work_project_number, String
	 * work_member_id, int work_check, Date work_regdate, Date work_enddate, String
	 * work_member_approver, String work_title, String work_content,
	 * List<Work_AttachVO> attachList) { super(); this.work_number = work_number;
	 * this.work_project_number = work_project_number; this.work_member_id =
	 * work_member_id; this.work_check = work_check; this.work_regdate =
	 * work_regdate; this.work_enddate = work_enddate; this.work_member_approver =
	 * work_member_approver; this.work_title = work_title; this.work_content =
	 * work_content; this.attachList = attachList; }
	 */

}
