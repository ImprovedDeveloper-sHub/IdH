package com.sbs.IdH.dto;

public class CalendarVO {

	private String title="test";
	private String start= "2023-03-12";
	private String end= "2023-03-12";
	public String getTitle() {
		return title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CalendarVO() {}
	public CalendarVO(String title, String start, String end) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
	}
	public CalendarVO(ScheduleVO schedule) {
		//schedule.getSchedule_startdate()
	}
	
	
	
	
}
