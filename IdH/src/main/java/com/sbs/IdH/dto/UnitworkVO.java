package com.sbs.IdH.dto;

import java.util.Date;

public class UnitworkVO {
	private int unitwork_number;
	private int unitwork_status;
	private String unitwork_name;
	private int unitwork_check;
	private int unitwork_project_number;
	private String unitwork_member_id;
	private String unitwork_detail;
	private Date unitwork_regdate;
	private Date unitwork_enddate;
	
	
	
	
	public UnitworkVO(int unitwork_number, int unitwork_status, String unitwork_name, int unitwork_check,
			int unitwork_project_number, String unitwork_member_id, String unitwork_detail, Date unitwork_regdate,
			Date unitwork_enddate) {
		super();
		this.unitwork_number = unitwork_number;
		this.unitwork_status = unitwork_status;
		this.unitwork_name = unitwork_name;
		this.unitwork_check = unitwork_check;
		this.unitwork_project_number = unitwork_project_number;
		this.unitwork_member_id = unitwork_member_id;
		this.unitwork_detail = unitwork_detail;
		this.unitwork_regdate = unitwork_regdate;
		this.unitwork_enddate = unitwork_enddate;
	}
	public int getUnitwork_number() {
		return unitwork_number;
	}
	public void setUnitwork_number(int unitwork_number) {
		this.unitwork_number = unitwork_number;
	}
	public int getUnitwork_status() {
		return unitwork_status;
	}
	public void setUnitwork_status(int unitwork_status) {
		this.unitwork_status = unitwork_status;
	}
	public String getUnitwork_name() {
		return unitwork_name;
	}
	public void setUnitwork_name(String unitwork_name) {
		this.unitwork_name = unitwork_name;
	}
	public int getUnitwork_check() {
		return unitwork_check;
	}
	public void setUnitwork_check(int unitwork_check) {
		this.unitwork_check = unitwork_check;
	}
	public int getUnitwork_project_number() {
		return unitwork_project_number;
	}
	public void setUnitwork_project_number(int unitwork_project_number) {
		this.unitwork_project_number = unitwork_project_number;
	}
	public String getUnitwork_member_id() {
		return unitwork_member_id;
	}
	public void setUnitwork_member_id(String unitwork_member_id) {
		this.unitwork_member_id = unitwork_member_id;
	}
	public String getUnitwork_detail() {
		return unitwork_detail;
	}
	public void setUnitwork_detail(String unitwork_detail) {
		this.unitwork_detail = unitwork_detail;
	}
	public Date getUnitwork_regdate() {
		return unitwork_regdate;
	}
	public void setUnitwork_regdate(Date unitwork_regdate) {
		this.unitwork_regdate = unitwork_regdate;
	}
	public Date getUnitwork_enddate() {
		return unitwork_enddate;
	}
	public void setUnitwork_enddate(Date unitwork_enddate) {
		this.unitwork_enddate = unitwork_enddate;
	}
	@Override
	public String toString() {
		return "UnitworkVO [unitwork_number=" + unitwork_number + ", unitwork_status=" + unitwork_status
				+ ", unitwork_name=" + unitwork_name + ", unitwork_check=" + unitwork_check
				+ ", unitwork_project_number=" + unitwork_project_number + ", unitwork_member_id=" + unitwork_member_id
				+ ", unitwork_detail=" + unitwork_detail + ", unitwork_regdate=" + unitwork_regdate
				+ ", unitwork_enddate=" + unitwork_enddate + "]";
	}
	
	
	
	
	
	
	
	
	
}
