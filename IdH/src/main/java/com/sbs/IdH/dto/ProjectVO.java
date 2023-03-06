package com.sbs.IdH.dto;

import java.util.Date;

public class ProjectVO {

	private int project_number;
	private String project_name;
	private Date project_regdate;
	private Date proejct_enddate;
	private int project_status;
	private  int project_require_number;
	private int project_business_number;
	private String project_member_id;
	private String project_discription;
	
	
	public int getProject_number() {
		return project_number;
	}
	public void setProject_number(int project_number) {
		this.project_number = project_number;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Date getProject_regdate() {
		return project_regdate;
	}
	public void setProject_regdate(Date project_regdate) {
		this.project_regdate = project_regdate;
	}
	public Date getProejct_enddate() {
		return proejct_enddate;
	}
	public void setProejct_enddate(Date proejct_enddate) {
		this.proejct_enddate = proejct_enddate;
	}
	
	
	
	public int getProject_status() {
		return project_status;
	}
	public void setProject_status(int project_status) {
		this.project_status = project_status;
	}
	public int getProject_require_number() {
		return project_require_number;
	}
	public void setProject_require_number(int project_require_number) {
		this.project_require_number = project_require_number;
	}
	public int getProject_business_number() {
		return project_business_number;
	}
	public void setProject_business_number(int project_business_number) {
		this.project_business_number = project_business_number;
	}
	public String getProject_member_id() {
		return project_member_id;
	}
	public void setProject_member_id(String project_member_id) {
		this.project_member_id = project_member_id;
	}
	public String getProject_discription() {
		return project_discription;
	}
	public void setProject_discription(String project_discription) {
		this.project_discription = project_discription;
	}
	
	
	public ProjectVO() {}
	public ProjectVO(int project_number, String project_name, Date project_regdate, Date proejct_enddate,
			int project_status, int project_require_number, int project_business_number, String project_member_id,
			String project_discription) {
		super();
		this.project_number = project_number;
		this.project_name = project_name;
		this.project_regdate = project_regdate;
		this.proejct_enddate = proejct_enddate;
		this.project_status = project_status;
		this.project_require_number = project_require_number;
		this.project_business_number = project_business_number;
		this.project_member_id = project_member_id;
		this.project_discription = project_discription;
	}
	
	
	
	
	
}
