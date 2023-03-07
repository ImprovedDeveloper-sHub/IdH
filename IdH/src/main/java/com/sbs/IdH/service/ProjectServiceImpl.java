package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dto.ProjectVO;

public class ProjectServiceImpl implements ProjectService{

	
	ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	@Override
	public void registProject(ProjectVO project) throws Exception {
		projectDAO.insertProject(project);
	}

	@Override
	public void updateProject(ProjectVO project) throws Exception {
		projectDAO.updateProjectForProjectStart(project);
		
	}

	@Override
	public void removeProject(int project_number) throws Exception {
		projectDAO.deleteProject(project_number);
		
	}

	@Override
	public ProjectVO selectProject(int project_number) throws Exception {
		return projectDAO.selectProject(project_number);
	}

	@Override
	public Map<String, Object> selectProjectList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("projectList", projectDAO.selectSearchProjectList(cri));
		return dataMap;
	}

	@Override
	public Map<String, Object> selectProceedingProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setStatus(1);
		dataMap.put("proccedingProjectList", projectDAO.selectSearchProjectList(cri));
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectEndProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setStatus(0);
		dataMap.put("endProjectList", projectDAO.selectSearchProjectList(cri));
		return dataMap;
	}

	
	
	

}
