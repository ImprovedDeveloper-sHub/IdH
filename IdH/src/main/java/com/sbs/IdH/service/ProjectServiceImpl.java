package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
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
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));
		
		dataMap.put("pageMaker",pageMaker);
		dataMap.put("projectList", projectDAO.selectSearchProjectList(cri));
		return dataMap;
	}

	
	
	
	@Override
	public Map<String, Object> selectProceedingProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setStatus(1);
		dataMap.put("proceedingProjectList", projectDAO.selectSearchProjectList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));
		dataMap.put("proceedingPageMaker",pageMaker);
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectEndProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setStatus(2);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));
		dataMap.put("endProjectList", projectDAO.selectSearchProjectList(cri));
		dataMap.put("endPageMaker",pageMaker);
		return dataMap;
	}


	
	

}
