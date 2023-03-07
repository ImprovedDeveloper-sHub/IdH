package com.sbs.IdH.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MinutesVO;

public class MinutesDAOImpl implements MinutesDAO{

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<MinutesVO> selectSearchMinutesList(SearchCriteria cri) {
		List<MinutesVO>minutesList = session.selectList("Minutes-Mapper.selectSearchMinutesList");
		return minutesList;
	}

	@Override
	public int selectSearchMinutesListCount(SearchCriteria cri) {
		int minutesListCount = session.selectOne("Minutes-Mapper.selectSearchMinutesListCount",cri);
		return minutesListCount;
	}

	@Override
	public MinutesVO selectMinutesByMinutes_Number(int minutes_number) throws Exception {
		MinutesVO minutes = session.selectOne("Minutes-Mapper.selectMinutesByMinutes_Number",minutes_number);
		return minutes;
	}

	@Override
	public void insertMinutes(MinutesVO minutes) {
		session.update("Minutes-Mapper.insertMinutes",minutes);
		
	}

	@Override
	public void updateMinutes(MinutesVO minutes) {
		session.update("Minutes-Mapper.updateMinutes",minutes);
		
	}

	@Override
	public void deleteMinutes(int minutes_number) {
		session.update("Minutes-Mapper.deleteMinutes",minutes_number);
		
	}

}
