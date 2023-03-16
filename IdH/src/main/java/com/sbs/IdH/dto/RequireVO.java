package com.sbs.IdH.dto;

import java.util.Date;
import java.util.List;

public class RequireVO {

	private int require_number;
	private int require_level;
	private String require_title;
	private String require_source;
	private Date require_regdate;
	private String require_business;
	private String require_project;
	private String require_detail;
	private String require_setter_id;
	private int require_business_number;
	private String require_getter_id;
	
	private List<Require_attachVO> attachList;
	
	public List<Require_attachVO> getAttachList() {
		return attachList;
	}
	public void setAttachList(List<Require_attachVO> attachList) {
		this.attachList = attachList;
	}
	public int getRequire_number() {
		return require_number;
	}
	public void setRequire_number(int require_number) {
		this.require_number = require_number;
	}
	public int getRequire_level() {
		return require_level;
	}
	public void setRequire_level(int require_level) {
		this.require_level = require_level;
	}
	public String getRequire_title() {
		return require_title;
	}
	public void setRequire_title(String require_title) {
		this.require_title = require_title;
	}
	public String getRequire_source() {
		return require_source;
	}
	public void setRequire_source(String require_source) {
		this.require_source = require_source;
	}
	public Date getRequire_regdate() {
		return require_regdate;
	}
	public void setRequire_regdate(Date require_regdate) {
		this.require_regdate = require_regdate;
	}
	public String getRequire_business() {
		return require_business;
	}
	public void setRequire_business(String require_business) {
		this.require_business = require_business;
	}
	public String getRequire_project() {
		return require_project;
	}
	public void setRequire_project(String require_project) {
		this.require_project = require_project;
	}
	public String getRequire_detail() {
		return require_detail;
	}
	public void setRequire_detail(String require_detail) {
		this.require_detail = require_detail;
	}
	public String getRequire_setter_id() {
		return require_setter_id;
	}
	public void setRequire_setter_id(String require_setter_id) {
		this.require_setter_id = require_setter_id;
	}
	public int getRequire_business_number() {
		return require_business_number;
	}
	public void setRequire_business_number(int require_business_number) {
		this.require_business_number = require_business_number;
	}
	public String getRequire_getter_id() {
		return require_getter_id;
	}
	public void setRequire_getter_id(String require_getter_id) {
		this.require_getter_id = require_getter_id;
	}
	
	public RequireVO() {}
	public RequireVO(int require_number, int require_level, String require_title, String require_source,
			Date require_regdate, String require_business, String require_project, String require_detail,
			String require_setter_id, int require_business_number, String require_getter_id,
			List<Require_attachVO> attachList) {
		super();
		this.require_number = require_number;
		this.require_level = require_level;
		this.require_title = require_title;
		this.require_source = require_source;
		this.require_regdate = require_regdate;
		this.require_business = require_business;
		this.require_project = require_project;
		this.require_detail = require_detail;
		this.require_setter_id = require_setter_id;
		this.require_business_number = require_business_number;
		this.require_getter_id = require_getter_id;
		this.attachList = attachList;
	}

	


}
