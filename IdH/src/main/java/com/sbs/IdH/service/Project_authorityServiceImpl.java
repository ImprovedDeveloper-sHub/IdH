package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.Project_authorityDAO;
import com.sbs.IdH.dto.Project_authorityVO;

public class Project_authorityServiceImpl implements Project_authorityService{

	private Project_authorityDAO project_authorityDAO;
	public void setProject_authorityDAO(Project_authorityDAO project_authorityDAO) {
		this.project_authorityDAO = project_authorityDAO;
	}

	@Override
	public Map<String, Object> selectProject_authorityList(SearchCriteria cri) throws SQLException {
	
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<Project_authorityVO> project_authorityList = project_authorityDAO.selectSearchProject_authorityList(cri);
		dataMap.put("project_authorityList", project_authorityList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public void registProject_authority(Project_authorityVO project_authority) throws SQLException {
	
		int project_authority_number = project_authorityDAO.selectProject_authoritySeqNext();

		project_authority.setProject_authority_number(project_authority_number);
		project_authorityDAO.insertProject_authority(project_authority);
		
	}

	@Override
	public Project_authorityVO selectProject_authority(int project_authority_number) throws SQLException {
		Project_authorityVO project_authority = project_authorityDAO.selectProject_authority(project_authority_number);
		return project_authority;
	}

	@Override
	public void modifyProject_authority(Project_authorityVO project_authority) throws SQLException {
		project_authorityDAO.updateProject_authority(project_authority);
		
	}

	@Override
	public void removeProject_authority(int project_authority_number) throws SQLException {
		project_authorityDAO.deleteProject_authority(project_authority_number);
		
	}

	
	
}
