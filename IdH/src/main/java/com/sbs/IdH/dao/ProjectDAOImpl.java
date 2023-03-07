package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProjectVO;

public class ProjectDAOImpl implements ProjectDAO{

	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<ProjectVO> selectSearchProjectList(SearchCriteria cri) throws SQLException {
		List<ProjectVO> projectList = session.selectList("Project-Mapper.selectProjectList", cri);
		return projectList;
	}

	@Override
	public List<ProjectVO> selectSearchProjectListForProject(int project_number) throws SQLException {
		List<ProjectVO> projectList = session.selectList("Project-Mapper.selectProjectForProject", project_number);
		return projectList;
	}

	@Override
	public int selectSearchProjectListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Project-Mapper.selectSearchProjectListCount", cri);
		return count;
	}

	
	@Override
	public ProjectVO selectProject(int project_number) throws SQLException {
		ProjectVO project = session.selectOne("Project-Mapper.selectProject", project_number);
		return project;
	}
	
	@Override
	public int selectProjectSeqNext() throws SQLException {
		session.update("Project-Mapper.selectProjectSeqNext");
		return 0;
	}

	

	@Override
	public void insertProject(ProjectVO project) throws SQLException {
		session.update("Project-Mapper.insertProject", project);
		
	}

	@Override
	public void updateProjectForProjectStart(ProjectVO project) throws SQLException {
		session.update("Project-Mapper.updateProjectForProjectStart", project);		
	}

	@Override
	public void updateProjectForProjectEnd(ProjectVO project) throws SQLException {
		session.update("Project-Mapper.updateProjectForProjectEnd", project);
		
	}

	
	@Override
	public void deleteProject(int project_number) throws SQLException {
		session.update("Project-Mapper.deleteProject", project_number);
		
	}


}
