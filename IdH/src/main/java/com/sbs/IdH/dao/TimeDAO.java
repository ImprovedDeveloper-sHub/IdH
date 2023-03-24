package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.TimeVO;

public interface TimeDAO {
	
	public List<TimeVO> selectTimeList(String member_id) throws SQLException;
	
	public int selectTimeSequenceNextValue() throws SQLException;
	
	public void insertTime(TimeVO time) throws SQLException;
	
	
}
