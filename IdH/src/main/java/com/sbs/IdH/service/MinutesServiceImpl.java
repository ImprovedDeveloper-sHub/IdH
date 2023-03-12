package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.MinutesDAO;
import com.sbs.IdH.dto.MinutesVO;

public class MinutesServiceImpl implements MinutesService{
	private MinutesDAO minutesDAO;
	public void setMinutesDAO(MinutesDAO minutesDAO) {
		this.minutesDAO = minutesDAO;
	}

	@Override
	public Map<String, Object> selectMinutesList(SearchCriteria cri) throws SQLException {
		List<MinutesVO>minutesList = minutesDAO.selectSearchMinutesList(cri);
		if(minutesList != null) {
			for(MinutesVO minutes : minutesList);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(minutesDAO.selectMinutesCriteriaTotalCount(cri));
		
		Map<String,Object>dataMap = new HashMap<String,Object>();
		dataMap.put("minutesList",minutesList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public void registMinutes(MinutesVO minutes) throws SQLException {
		minutes.setMinutes_number(2);
		minutesDAO.insertMinutes(minutes);
	}
	

	@Override
	public MinutesVO selectMinutes(int minutes_number) throws SQLException {
		MinutesVO minutes = minutesDAO.selectMinutesByMinutes_Number(minutes_number);
		return minutes;
	}

	@Override
	public void modifyMinutes(MinutesVO minutes) throws SQLException {
		minutesDAO.updateMinutes(minutes);
		
	}

	@Override
	public void removeMinutes(int minutes_number) throws SQLException {
		minutesDAO.deleteMinutes(minutes_number);
		
	}
}
