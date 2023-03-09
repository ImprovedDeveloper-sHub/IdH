package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkVO;

public interface WorkService {
	Map<String,Object>selectWorkList(SearchCriteria cri)throws SQLException;
	void registWork(WorkVO work)throws SQLException;
	WorkVO selectWork(int work_number)throws SQLException;
	void modifyWork(WorkVO work)throws SQLException;
	void removeWork(int work_number)throws SQLException;
}
