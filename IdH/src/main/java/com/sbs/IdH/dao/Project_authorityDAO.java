package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Project_authorityVO;

public interface Project_authorityDAO {

	List<Project_authorityVO> selectSearchProject_authorityList(SearchCriteria cri) throws SQLException;

	public Project_authorityVO selectProject_authority(int project_authority_number) throws SQLException;

	void insertProject_authority(Project_authorityVO project_authority) throws SQLException;

	void updateProject_authority(Project_authorityVO project_authority) throws SQLException;

	void deleteProject_authority(int project_authority_number) throws SQLException;
}
