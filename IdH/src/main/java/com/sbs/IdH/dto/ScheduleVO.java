package com.sbs.IdH.dto;

import java.util.Date;

public class ScheduleVO {

	private int schedule_number;
	private int schedule_status;
	private String schedule_member_id;
	
	private int schedule_project_number;
	
	
	private String schedule_detail;
	private String schedule_type;
	private String schedule_name;
	private Date schedule_regdate;
	private Date schedule_enddate;
	private Date schedule_startdate;
	
	
	public int getSchedule_number() {
		return schedule_number;
	}
	public void setSchedule_number(int schedule_number) {
		this.schedule_number = schedule_number;
	}
	public int getSchedule_status() {
		return schedule_status;
	}
	public void setSchedule_status(int schedule_status) {
		this.schedule_status = schedule_status;
	}
	public Date getSchedule_regdate() {
		return schedule_regdate;
	}
	public void setSchedule_regdate(Date schedule_regdate) {
		this.schedule_regdate = schedule_regdate;
	}
	public Date getSchedule_enddate() {
		return schedule_enddate;
	}
	public void setSchedule_enddate(Date schedule_enddate) {
		this.schedule_enddate = schedule_enddate;
	}
	public int getSchedule_project_number() {
		return schedule_project_number;
	}
	public void setSchedule_project_number(int schedule_project_number) {
		this.schedule_project_number = schedule_project_number;
	}
	public String getSchedule_member_id() {
		return schedule_member_id;
	}
	public void setSchedule_member_id(String schedule_member_id) {
		this.schedule_member_id = schedule_member_id;
	}
	public String getSchedule_detail() {
		return schedule_detail;
	}
	public void setSchedule_detail(String schedule_detail) {
		this.schedule_detail = schedule_detail;
	}
	
	
	public String getSchedule_type() {
		return schedule_type;
	}
	public void setSchedule_type(String schedule_type) {
		this.schedule_type = schedule_type;
	}
	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	public Date getSchedule_startdate() {
		return schedule_startdate;
	}
	public void setSchedule_startdate(Date schedule_startdate) {
		this.schedule_startdate = schedule_startdate;
	}
	public ScheduleVO() {}
	public ScheduleVO(int schedule_number, int schedule_status, String schedule_member_id, int schedule_project_number,
			String schedule_detail, String schedule_type, String schedule_name, Date schedule_regdate,
			Date schedule_enddate, Date schedule_startdate) {
		super();
		this.schedule_number = schedule_number;
		this.schedule_status = schedule_status;
		this.schedule_member_id = schedule_member_id;
		this.schedule_project_number = schedule_project_number;
		this.schedule_detail = schedule_detail;
		this.schedule_type = schedule_type;
		this.schedule_name = schedule_name;
		this.schedule_regdate = schedule_regdate;
		this.schedule_enddate = schedule_enddate;
		this.schedule_startdate = schedule_startdate;
	}
	public CalendarVO MakeCalendarVO() {
		CalendarVO cal = new CalendarVO();
		
		return cal;
	}
	@Override
	public String toString() {
		return "ScheduleVO [schedule_number=" + schedule_number + ", schedule_status=" + schedule_status
				+ ", schedule_member_id=" + schedule_member_id + ", schedule_project_number=" + schedule_project_number
				+ ", schedule_detail=" + schedule_detail + ", schedule_type=" + schedule_type + ", schedule_name="
				+ schedule_name + ", schedule_regdate=" + schedule_regdate + ", schedule_enddate=" + schedule_enddate
				+ ", schedule_startdate=" + schedule_startdate + "]";
	}


	
	
	
}
