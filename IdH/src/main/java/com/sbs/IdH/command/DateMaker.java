package com.sbs.IdH.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.ScheduleVO;
import com.sbs.IdH.dto.UnitworkVO;

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
	
	
	public void setParamUnitwork(UnitworkVO unitwork){
		Map <String, Object> param = new HashMap<String, Object>();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		param.put("title", unitwork.getUnitwork_name());
		param.put("start", format.format(unitwork.getUnitwork_regdate()));
		param.put("end", format.format(unitwork.getUnitwork_enddate()));
		paramList.add(param);
	}
	
	public void setParamBusinessSchedule(BusinessVO business){
		Map <String, Object> param = new HashMap<String, Object>();
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		param.put("title", business.getBusiness_name());
		param.put("start", format.format(business.getBusiness_begin()));
		param.put("end", format.format(business.getBusiness_end()));
		paramList.add(param);
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
