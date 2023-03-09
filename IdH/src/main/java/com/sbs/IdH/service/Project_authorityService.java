package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Project_authorityVO;

public interface Project_authorityService {

	Map<String, Object> selectProject_authorityList(SearchCriteria cri) throws SQLException;

	void registProject_authority(Project_authorityVO project_authority) throws SQLException;

	Project_authorityVO selectProject_authority(int project_authority_number) throws SQLException;

	void modifyProject_authority(Project_authorityVO project_authority) throws SQLException;

	void removeProject_authority(int project_authority_number) throws SQLException;
	
}
