package com.sbs.IdH.dto;

import java.util.Date;

public class MinutisVO {
	private int minutis_number;
	private String minutis_title;
	private Date regdate;
	private String content;
	private String minutis_member_id;
	private int minutis_project_number;
	
	public int getMinutis_number() {
		return minutis_number;
	}
	public void setMinutis_number(int minutis_number) {
		this.minutis_number = minutis_number;
	}
	public String getMinutis_title() {
		return minutis_title;
	}
	public void setMinutis_title(String minutis_title) {
		this.minutis_title = minutis_title;
	}
	public Date getregdate() {
		return regdate;
	}
	public void setregdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMinutis_member_id() {
		return minutis_member_id;
	}
	public void setMinutis_member_id(String minutis_member_id) {
		this.minutis_member_id = minutis_member_id;
	}
	public int getMinutis_project_number() {
		return minutis_project_number;
	}
	public void setMinutis_project_number(int minutis_project_number) {
		this.minutis_project_number = minutis_project_number;
	}
	
}
