package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Project_authorityVO;

public class Project_authorityDAOImpl implements Project_authorityDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<Project_authorityVO> selectSearchProject_authorityList(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<Project_authorityVO> projecet_authorityList 
			= session.selectList("Project_authority-Mapper.selectSearchProject_authorityList",cri,rowBounds);
		return projecet_authorityList;
	}

	@Override
	public Project_authorityVO selectProject_authority(int project_authority_number) throws SQLException {
		Project_authorityVO project_authority = session.selectOne("Project_authority-Mapper.selectProject_authority",project_authority_number);
		return project_authority;
	}

	@Override
	public void insertProject_authority(Project_authorityVO project_authority) throws SQLException {
		session.update("Project_authority-Mapper.insertProject_authority",project_authority);
		
	}

	@Override
	public void updateProject_authority(Project_authorityVO project_authority) throws SQLException {
		session.update("Project_authority-Mapper.updateProject_authority",project_authority);
		
	}

	@Override
	public void deleteProject_authority(int project_authority_number) throws SQLException {
		session.update("Project_authority-Mapper.deleteProject_authority",project_authority_number);
		
	}

	@Override
	public int selectProject_authoritySeqNext() throws SQLException {
		int seq_num = session.selectOne("Project_authority-Mapper.selectProject_authoritySeqNext");
		return seq_num;
	}

}
