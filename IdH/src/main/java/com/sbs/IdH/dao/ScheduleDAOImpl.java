package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ScheduleVO;

public class ScheduleDAOImpl implements ScheduleDAO{

	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<ScheduleVO> selectSearchScheduleList(SearchCriteria cri) throws SQLException {
		List<ScheduleVO> schduleList = session.selectList("Schedule-Mapper.selectScheduleList", cri);
		return schduleList;
	}

	@Override
	public List<ScheduleVO> selectSearchScheduleListForProject(int project_number) throws SQLException {
		List<ScheduleVO> schduleList = session.selectList("Schedule-Mapper.selectScheduleForProject", project_number);
		return schduleList;
	}

	@Override
	public int selectSearchScheduleListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Schedule-Mapper.selectSearchScheduleListCount", cri);
		return count;
	}

	@Override
	public ScheduleVO selectSchedule(int schdule_number) throws SQLException {
		ScheduleVO schdule = session.selectOne("Schedule-Mapper.selectSchedule", schdule_number);
		return schdule;
	}
	
	@Override
	public int selectScheduleSeqNext() throws SQLException {
		session.update("Schedule-Mapper.selectScheduleSeqNext");
		return 0;
	}

	

	@Override
	public void insertSchedule(ScheduleVO schdule) throws SQLException {
		session.update("Schedule-Mapper.insertSchedule", schdule);
		
	}

	@Override
	public void updateScheduleForProjectStart(ScheduleVO schdule) throws SQLException {
		session.update("Schedule-Mapper.updateScheduleForProjectStart", schdule);		
	}

	@Override
	public void updateScheduleForProjectEnd(ScheduleVO schdule) throws SQLException {
		session.update("Schedule-Mapper.updateScheduleForProjectEnd", schdule);
		
	}

	
	@Override
	public void deleteSchedule(int schdule_number) throws SQLException {
		session.update("Schedule-Mapper.deleteSchedule", schdule_number);
		
	}

	@Override
	public void updateSchedule(ScheduleVO schedule) throws SQLException {
		session.update("Schedule-Mapper.updateSchedule", schedule);
		
	}

}
