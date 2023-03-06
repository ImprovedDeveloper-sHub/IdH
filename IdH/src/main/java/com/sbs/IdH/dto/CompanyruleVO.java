package com.sbs.IdH.dto;

import java.util.Date;

public class CompanyruleVO {

	private int companyrule_number;
	private String companyrule_title;
	private String companyrule_content;
	private Date companyrule_regdate;
	private String companyrule_member_id;
	
	
	public int getCompanyrule_number() {
		return companyrule_number;
	}
	public void setCompanyrule_number(int companyrule_number) {
		this.companyrule_number = companyrule_number;
	}
	public String getCompanyrule_title() {
		return companyrule_title;
	}
	public void setCompanyrule_title(String companyrule_title) {
		this.companyrule_title = companyrule_title;
	}
	public String getCompanyrule_content() {
		return companyrule_content;
	}
	public void setCompanyrule_content(String companyrule_content) {
		this.companyrule_content = companyrule_content;
	}
	public Date getCompanyrule_regdate() {
		return companyrule_regdate;
	}
	public void setCompanyrule_regdate(Date companyrule_regdate) {
		this.companyrule_regdate = companyrule_regdate;
	}
	public String getCompanyrule_member_id() {
		return companyrule_member_id;
	}
	public void setCompanyrule_member_id(String companyrule_member_id) {
		this.companyrule_member_id = companyrule_member_id;
	}
	public CompanyruleVO() {}
	public CompanyruleVO(int companyrule_number, String companyrule_title, String companyrule_content,
			Date companyrule_regdate, String companyrule_member_id) {
		super();
		this.companyrule_number = companyrule_number;
		this.companyrule_title = companyrule_title;
		this.companyrule_content = companyrule_content;
		this.companyrule_regdate = companyrule_regdate;
		this.companyrule_member_id = companyrule_member_id;
	}
}
