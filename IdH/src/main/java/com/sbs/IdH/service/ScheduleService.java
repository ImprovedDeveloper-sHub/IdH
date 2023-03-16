package com.sbs.IdH.service;

import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ScheduleVO;

public interface ScheduleService {

	
	public void registSchedule(ScheduleVO schedule) throws Exception;
	
	public void removeSchedule(int schedule_number) throws Exception;
	
	public ScheduleVO selectSchedule(int schedule_number) throws Exception;
	
	public Map<String,Object> selectScheduleList(SearchCriteria cri) throws Exception;

	void modifySchedule(ScheduleVO schedule) throws Exception;

	void updateScheduleForRegistProject(int schedule_number, int project_number)throws Exception;
}
