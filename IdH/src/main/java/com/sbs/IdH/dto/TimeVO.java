package com.sbs.IdH.dto;

import java.util.Date;

public class TimeVO {

	private int time_number;
	private String time_name;
	private String time_detail;
	private Date time_regdate;
	private int time_type;
	private String time_setter_id="";
	private String time_getter_id="";
	private String time_work="";
	
	public int getTime_number() {
		return time_number;
	}
	public void setTime_number(int time_number) {
		this.time_number = time_number;
	}
	public String getTime_name() {
		return time_name;
	}
	public void setTime_name(String time_name) {
		this.time_name = time_name;
	}
	public String getTime_detail() {
		return time_detail;
	}
	public void setTime_detail(String time_detail) {
		this.time_detail = time_detail;
	}
	public Date getTime_regdate() {
		return time_regdate;
	}
	public void setTime_regdate(Date time_regdate) {
		this.time_regdate = time_regdate;
	}
	public int getTime_type() {
		return time_type;
	}
	public void setTime_type(int time_type) {
		this.time_type = time_type;
	}
	public String getTime_setter_id() {
		return time_setter_id;
	}
	public void setTime_setter_id(String time_setter_id) {
		this.time_setter_id = time_setter_id;
	}
	public String getTime_getter_id() {
		return time_getter_id;
	}
	public void setTime_getter_id(String time_getter_id) {
		this.time_getter_id = time_getter_id;
	}
	
	public String getTime_work() {
		return time_work;
	}
	public void setTime_work(String time_work) {
		this.time_work = time_work;
	}
	public TimeVO() {}
	public TimeVO(String time_name, int time_type, String time_setter_id, String time_getter_id, String time_work) {
		super();
		this.time_name = time_name;
		this.time_type = time_type;
		this.time_setter_id = time_setter_id;
		this.time_getter_id = time_getter_id;
		this.time_work = time_work;
	}
	
	public TimeVO(int time_number, String time_name, String time_detail, Date time_regdate, int time_type,
			String time_setter_id, String time_getter_id, String time_work) {
		super();
		this.time_number = time_number;
		this.time_name = time_name;
		this.time_detail = time_detail;
		this.time_regdate = time_regdate;
		this.time_type = time_type;
		this.time_setter_id = time_setter_id;
		this.time_getter_id = time_getter_id;
		this.time_work = time_work;
	}
	
	
	
}
