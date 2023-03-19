package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.DateMaker;
import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dao.ScheduleDAO;
import com.sbs.IdH.dto.ScheduleVO;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDAO scheduleDAO;

	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
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
		ScheduleVO schedule = scheduleDAO.selectSchedule(schedule_number);
		schedule.setSchedule_project_name(projectDAO.selectProjectName(schedule.getSchedule_project_number()));
		return schedule;
	}

	@Override
	public Map<String, Object> selectScheduleList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		PageMaker pageMaker = new PageMaker();
		cri.setPerPageNum(5);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(scheduleDAO.selectSearchScheduleListCount(cri));
		List<ScheduleVO> scheduleList = scheduleDAO.selectSearchScheduleList(cri);
		for(ScheduleVO schedule: scheduleList) {
			schedule.setSchedule_project_name(projectDAO.selectProjectName(schedule.getSchedule_project_number()));
		}
		dataMap.put("scheduleList", scheduleDAO.selectSearchScheduleList(cri));
		dataMap.put("pageMaker",pageMaker);
		return dataMap;
	}

	@Override
	public void updateScheduleForRegistProject(int schedule_number, int project_number) throws Exception {
		ScheduleVO schedule = scheduleDAO.selectSchedule(schedule_number);
		schedule.setSchedule_project_number(project_number);
		scheduleDAO.updateScheduleForRegistProject(schedule);
		// 2. 실제 프로젝트 진행중에 사용할 현황을 위한 단위업무를 등록한다.
		schedule.setSchedule_number(scheduleDAO.selectScheduleSeqNext());
		schedule.setSchedule_status(2);
		scheduleDAO.insertSchedule(schedule);
	}

	@Override
	public List<Map<String,Object>> selectScheduleListForCalendar(SearchCriteria cri) throws Exception {
		DateMaker dateMaker = new DateMaker();
		List<ScheduleVO> scheduleList = scheduleDAO.selectSearchScheduleList(cri);
		for(ScheduleVO schedule : scheduleList) {
			dateMaker.setParamSchedule(schedule);
		}
		return dateMaker.getParamList();
	}
}
