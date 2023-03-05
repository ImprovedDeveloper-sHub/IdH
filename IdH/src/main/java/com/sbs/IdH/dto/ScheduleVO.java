package com.sbs.IdH.dto;

import java.util.Date;

public class ScheduleVO {

	private int schedule_number;
	private int schedule_status;
	private Date schedule_regdate;
	private Date schedule_enddate;
	private int schedule_project_number;
	private int schedule_member_id;
	
	
	
	
	public ScheduleVO(int schedule_number, int schedule_status, Date schedule_regdate, Date schedule_enddate,
			int schedule_project_number, int schedule_member_id) {
		super();
		this.schedule_number = schedule_number;
		this.schedule_status = schedule_status;
		this.schedule_regdate = schedule_regdate;
		this.schedule_enddate = schedule_enddate;
		this.schedule_project_number = schedule_project_number;
		this.schedule_member_id = schedule_member_id;
	}
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
	public int getSchedule_member_id() {
		return schedule_member_id;
	}
	public void setSchedule_member_id(int schedule_member_id) {
		this.schedule_member_id = schedule_member_id;
	}
	@Override
	public String toString() {
		return "ScheduleVO [schedule_number=" + schedule_number + ", schedule_status=" + schedule_status
				+ ", schedule_regdate=" + schedule_regdate + ", schedule_enddate=" + schedule_enddate
				+ ", schedule_project_number=" + schedule_project_number + ", schedule_member_id=" + schedule_member_id
				+ "]";
	}
	
	
	
}
