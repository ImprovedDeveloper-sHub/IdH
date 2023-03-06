package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProjectVO;

public interface ProjectDAO {

	
	List<ProjectVO> selectSearchProjectList(SearchCriteria cri) throws SQLException;

	List<ProjectVO> selectSearchProjectListForProject(int project_number) throws SQLException;
	
	int selectSearchProjectListCount(SearchCriteria cri) throws SQLException;

	ProjectVO selectProject(int project_number) throws SQLException;	

	int selectProjectSeqNext() throws SQLException;

	void insertProject(ProjectVO project) throws SQLException;

	void updateProjectForProjectStart(ProjectVO project) throws SQLException;

	void updateProjectForProjectEnd(ProjectVO project) throws SQLException;
	
	void deleteProject(int project_number) throws SQLException;
}
