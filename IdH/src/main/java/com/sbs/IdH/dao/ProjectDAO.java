package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProjectVO;

public interface ProjectDAO {

	
	List<ProjectVO> selectSearchProjectList(SearchCriteria cri) throws SQLException;

	List<ProjectVO> selectSearchProjectListForProject(int project_number) throws SQLException;
	
	//List<ProjectVO> selectSearchProjectListByStatus(SearchCriteria cri, int project_status) throws SQLException;
	
	int selectSearchProjectListCount(SearchCriteria cri) throws SQLException;

	ProjectVO selectProject(int project_number) throws SQLException;	

	int selectProjectSeqNext() throws SQLException;

	void insertProject(ProjectVO project) throws SQLException;

	void updateProjectForProjectStart(ProjectVO project) throws SQLException;

	void updateProjectForProjectEnd(ProjectVO project) throws SQLException;
	
	
	
	void deleteProject(int project_number) throws SQLException;
	//추가
	List<Integer> selectProjectByBusinessNumber(int business_number)throws SQLException;
	
	String selectProjectName(int project_number)throws Exception;
}
