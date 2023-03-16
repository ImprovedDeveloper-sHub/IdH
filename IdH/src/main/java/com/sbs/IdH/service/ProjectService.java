package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProjectVO;

public interface ProjectService {

	
	public void registProject(ProjectVO project) throws Exception;
	
	public void updateProject(ProjectVO project) throws Exception;
	
	public void removeProject(int project_number) throws Exception;
	
	public ProjectVO selectProject(int project_number) throws Exception;
	
	public Map<String,Object> selectProjectList(SearchCriteria cri) throws Exception;
	
	//public Map<String,Object> selectProjectByStatus(SearchCriteria cri, int status) throws Exception; 
	
	public Map<String,Object> selectProceedingProject(SearchCriteria cri) throws Exception;

	public Map<String,Object> selectEndProject(SearchCriteria cri) throws Exception;
	
	public Map<String,Object> selectProjectPlanByBusiness_number2(int business_number) throws Exception;
	
	public Map<String,Object> selectProjectPlanByBusiness_number(int business_number) throws Exception;
	
	public Map<String,Object> selectProjectProgressByproject_number(int project_number) throws Exception;
	
//	public Map<String, Object> selectProcessunitworkList(SearchCriteria cri) throws SQLException;
	
	public Map<String, Object> selectProjectUnitwork_level(SearchCriteria cri) throws SQLException;
	
}
