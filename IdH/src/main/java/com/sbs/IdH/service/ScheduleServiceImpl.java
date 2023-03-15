package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ScheduleDAO;
import com.sbs.IdH.dto.ScheduleVO;

public class ScheduleServiceImpl implements ScheduleService{

	
	ScheduleDAO scheduleDAO;
	
	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}
	
	
	
	@Override
	public void registSchedule(ScheduleVO schedule) throws Exception {
		schedule.setSchedule_number(scheduleDAO.selectScheduleSeqNext());
		scheduleDAO.insertSchedule(schedule);
	}

	@Override
	public void modifySchedule(ScheduleVO schedule) throws Exception {
		scheduleDAO.updateSchedule(schedule);
	
	}

	@Override
	public void removeSchedule(int schedule_number) throws Exception {
		scheduleDAO.deleteSchedule(schedule_number);
		
	}

	@Override
	public ScheduleVO selectSchedule(int schedule_number) throws Exception {
		return scheduleDAO.selectSchedule(schedule_number);
	}

	@Override
	public Map<String, Object> selectScheduleList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("scheduleList", scheduleDAO.selectSearchScheduleList(cri));
		return dataMap;
	}

}
