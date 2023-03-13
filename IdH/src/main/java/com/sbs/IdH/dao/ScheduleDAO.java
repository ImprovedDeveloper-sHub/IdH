package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ScheduleVO;

public interface ScheduleDAO {

	
	List<ScheduleVO> selectSearchScheduleList(SearchCriteria cri) throws SQLException;

	List<ScheduleVO> selectSearchScheduleListForProject(int project_number) throws SQLException;
	
	int selectSearchScheduleListCount(SearchCriteria cri) throws SQLException;

	ScheduleVO selectSchedule(int schedule_number) throws SQLException;	

	int selectScheduleSeqNext() throws SQLException;

	void insertSchedule(ScheduleVO schedule) throws SQLException;

	void updateScheduleForProjectStart(ScheduleVO schedule) throws SQLException;

	void updateScheduleForProjectEnd(ScheduleVO schedule) throws SQLException;
	
	void deleteSchedule(int schedule_number) throws SQLException;
}
