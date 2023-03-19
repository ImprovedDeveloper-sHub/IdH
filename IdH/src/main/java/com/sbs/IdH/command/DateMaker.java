package com.sbs.IdH.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.dto.ScheduleVO;

public class DateMaker {

	private List<Map<String,Object>> paramList;
	
	public static Date makeByYMD(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
	   	cal.set(year, month-1, day);
		return new Date(cal.getTimeInMillis());
	}

	
	public void setParamSchedule(ScheduleVO schedule){
		Map <String, Object> param = new HashMap<String, Object>();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		param.put("title", schedule.getSchedule_name());
		param.put("start", format.format(schedule.getSchedule_startdate()));
		param.put("end", format.format(schedule.getSchedule_enddate()));
		paramList.add(param);
	}
	
	public void setParamString(String title, Date start, Date end) {
		
		
	}
	
	
	public DateMaker() {
		this.paramList = new ArrayList<Map<String,Object>>();
	}

	public List<Map<String, Object>> getParamList() {
		return paramList;
	}

	public void setParamList(List<Map<String, Object>> paramList) {
		this.paramList = paramList;
	}
	
	
	
	
}
