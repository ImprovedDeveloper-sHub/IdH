package com.sbs.IdH.dto;

import java.util.Date;

public class MinutesVO {
	private int minutes_number;
	private String minutes_title;
	private Date minutes_regdate;
	private String minutes_content;
	private String minutes_member_id;
	private int minutes_project_number;
	
	public int getMinutes_number() {
		return minutes_number;
	}
	public void setMinutes_number(int minutes_number) {
		this.minutes_number = minutes_number;
	}
	public String getMinutes_title() {
		return minutes_title;
	}
	public void setMinutes_title(String minutes_title) {
		this.minutes_title = minutes_title;
	}
	public Date getminutes_regdate() {
		return minutes_regdate;
	}
	public void setminutes_regdate(Date regdate) {
		this.minutes_regdate = regdate;
	}
	public String getminutes_content() {
		return minutes_content;
	}
	public void setminutes_content(String content) {
		this.minutes_content = content;
	}
	public String getMinutes_member_id() {
		return minutes_member_id;
	}
	public void setMinutes_member_id(String minutes_member_id) {
		this.minutes_member_id = minutes_member_id;
	}
	public int getMinutes_project_number() {
		return minutes_project_number;
	}
	public void setMinutes_project_number(int minutes_project_number) {
		this.minutes_project_number = minutes_project_number;
	}
	
	public MinutesVO() {}
	public MinutesVO(int minutes_number, String minutes_title, Date minutes_regdate, String minutes_content, String minutes_member_id,
			int minutes_project_number) {
		super();
		this.minutes_number = minutes_number;
		this.minutes_title = minutes_title;
		this.minutes_regdate = minutes_regdate;
		this.minutes_content = minutes_content;
		this.minutes_member_id = minutes_member_id;
		this.minutes_project_number = minutes_project_number;
	}
	
}
