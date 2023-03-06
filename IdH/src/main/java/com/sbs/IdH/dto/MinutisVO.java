package com.sbs.IdH.dto;

import java.util.Date;

public class MinutisVO {
	private int minutis_number;
	private String minutis_title;
	private Date minutis_regdate;
	private String minutis_content;
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
	public Date getminutis_regdate() {
		return minutis_regdate;
	}
	public void setminutis_regdate(Date regdate) {
		this.minutis_regdate = regdate;
	}
	public String getminutis_content() {
		return minutis_content;
	}
	public void setminutis_content(String content) {
		this.minutis_content = content;
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
	
	public MinutisVO() {}
	public MinutisVO(int minutis_number, String minutis_title, Date minutis_regdate, String minutis_content, String minutis_member_id,
			int minutis_project_number) {
		super();
		this.minutis_number = minutis_number;
		this.minutis_title = minutis_title;
		this.minutis_regdate = minutis_regdate;
		this.minutis_content = minutis_content;
		this.minutis_member_id = minutis_member_id;
		this.minutis_project_number = minutis_project_number;
	}
	
}
