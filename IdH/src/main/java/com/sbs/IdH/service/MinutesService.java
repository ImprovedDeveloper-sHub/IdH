package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MinutesVO;

public interface MinutesService {
	Map<String,Object>selectMinutesList(SearchCriteria cri)throws SQLException;
	void registMinutes(MinutesVO minutes)throws SQLException;
	MinutesVO selectMinutes(int minutes_number)throws SQLException;
	void modifyMinutes(MinutesVO minutes)throws SQLException;
	void removeMinutes(int minutes_number)throws SQLException;
}
