package com.sbs.IdH.dto;

import java.util.Date;

public class UnitworkVO {
	private int unitwork_number;
	private int unitwork_status;
	private String unitwork_name;
	private int unitwork_level;
	private int unitwork_project_number;
	private String unitwork_setter_id;
	private String unitwork_getter_id;
	private String unitwork_detail;
	private Date unitwork_regdate;
	private Date unitwork_enddate;
	private Date unitwork_startdate;

	public UnitworkVO() {
	}

	public UnitworkVO(int unitwork_number, int unitwork_status, String unitwork_name, int unitwork_level,
			int unitwork_project_number, String unitwork_setter_id, String unitwork_getter_id, String unitwork_detail,
			Date unitwork_regdate, Date unitwork_enddate, Date unitwork_startdate) {
		super();
		this.unitwork_number = unitwork_number;
		this.unitwork_status = unitwork_status;
		this.unitwork_name = unitwork_name;
		this.unitwork_level = unitwork_level;
		this.unitwork_project_number = unitwork_project_number;
		this.unitwork_setter_id = unitwork_setter_id;
		this.unitwork_getter_id = unitwork_getter_id;
		this.unitwork_detail = unitwork_detail;
		this.unitwork_regdate = unitwork_regdate;
		this.unitwork_enddate = unitwork_enddate;
		this.unitwork_startdate = unitwork_startdate;
	}

	public Date getUnitwork_startdate() {
		return unitwork_startdate;
	}

	public void setUnitwork_startdate(Date unitwork_startdate) {
		this.unitwork_startdate = unitwork_startdate;
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

	public int getUnitwork_level() {
		return unitwork_level;
	}

	public void setUnitwork_level(int unitwork_level) {
		this.unitwork_level = unitwork_level;
	}

	public int getUnitwork_project_number() {
		return unitwork_project_number;
	}

	public void setUnitwork_project_number(int unitwork_project_number) {
		this.unitwork_project_number = unitwork_project_number;
	}

	public String getUnitwork_setter_id() {
		return unitwork_setter_id;
	}

	public void setUnitwork_setter_id(String unitwork_setter_id) {
		this.unitwork_setter_id = unitwork_setter_id;
	}

	public String getUnitwork_getter_id() {
		return unitwork_getter_id;
	}

	public void setUnitwork_getter_id(String unitwork_getter_id) {
		this.unitwork_getter_id = unitwork_getter_id;
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
				+ ", unitwork_name=" + unitwork_name + ", unitwork_level=" + unitwork_level
				+ ", unitwork_project_number=" + unitwork_project_number + ", unitwork_setter_id=" + unitwork_setter_id
				+ ", unitwork_getter_id=" + unitwork_getter_id + ", unitwork_detail=" + unitwork_detail
				+ ", unitwork_regdate=" + unitwork_regdate + ", unitwork_enddate=" + unitwork_enddate
				+ ", unitwork_startdate=" + unitwork_startdate + "]";
	}

	

}
