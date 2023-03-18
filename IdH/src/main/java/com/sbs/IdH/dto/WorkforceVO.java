package com.sbs.IdH.dto;

import java.util.Date;

public class WorkforceVO {
	private int workforce_number;
	private int workforce_status;
	private int workforce_project_number;
	private String workforce_detail;
	private String workforce_member_id;
	private String workforce_name;
	private int workforce_type;
	private Date workforce_regdate;
	private Date workforce_startdate;
	private Date workforce_enddate;
	
	private String workforce_project_name;
	
	
	
	public String getWorkforce_project_name() {
		return workforce_project_name;
	}
	public void setWorkforce_project_name(String workforce_project_name) {
		this.workforce_project_name = workforce_project_name;
	}
	public int getWorkforce_number() {
		return workforce_number;
	}
	public void setWorkforce_number(int workforce_number) {
		this.workforce_number = workforce_number;
	}
	public int getWorkforce_status() {
		return workforce_status;
	}
	public void setWorkforce_status(int workforce_status) {
		this.workforce_status = workforce_status;
	}
	public int getWorkforce_project_number() {
		return workforce_project_number;
	}
	public void setWorkforce_project_number(int workforce_project_number) {
		this.workforce_project_number = workforce_project_number;
	}
	public String getWorkforce_detail() {
		return workforce_detail;
	}
	public void setWorkforce_detail(String workforce_detail) {
		this.workforce_detail = workforce_detail;
	}
	public String getWorkforce_member_id() {
		return workforce_member_id;
	}
	public void setWorkforce_member_id(String workforce_member_id) {
		this.workforce_member_id = workforce_member_id;
	}
	public String getWorkforce_name() {
		return workforce_name;
	}
	public void setWorkforce_name(String workforce_name) {
		this.workforce_name = workforce_name;
	}
	public int getWorkforce_type() {
		return workforce_type;
	}
	public void setWorkforce_type(int workforce_type) {
		this.workforce_type = workforce_type;
	}
	public Date getWorkforce_regdate() {
		return workforce_regdate;
	}
	public void setWorkforce_regdate(Date workforce_regdate) {
		this.workforce_regdate = workforce_regdate;
	}
	public Date getWorkforce_enddate() {
		return workforce_enddate;
	}
	public void setWorkforce_enddate(Date workforce_enddate) {
		this.workforce_enddate = workforce_enddate;
	}
	
	
	public Date getWorkforce_startdate() {
		return workforce_startdate;
	}
	public void setWorkforce_startdate(Date workforce_startdate) {
		this.workforce_startdate = workforce_startdate;
	}
	
	@Override
	public String toString() {
		return "WorkforceVO [workforce_number=" + workforce_number + ", workforce_status=" + workforce_status
				+ ", workforce_project_number=" + workforce_project_number + ", workforce_detail=" + workforce_detail
				+ ", workforce_member_id=" + workforce_member_id + ", workforce_name=" + workforce_name
				+ ", workforce_type=" + workforce_type + ", workforce_regdate=" + workforce_regdate
				+ ", workforce_enddate=" + workforce_enddate + "]";
	}
	
	
	

}
