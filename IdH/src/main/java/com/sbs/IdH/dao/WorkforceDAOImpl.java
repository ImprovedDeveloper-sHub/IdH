package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkforceVO;

public class WorkforceDAOImpl implements WorkforceDAO{

	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<WorkforceVO> selectSearchWorkforceList(SearchCriteria cri) throws SQLException {
		List<WorkforceVO> workforceList = session.selectList("Workforce-Mapper.selectWorkforceList", cri);
		return workforceList;
	}

	@Override
	public List<WorkforceVO> selectSearchWorkforceListForProject(int project_number) throws SQLException {
		List<WorkforceVO> workforceList = session.selectList("Workforce-Mapper.selectWorkforceForProject", project_number);
		return workforceList;
	}

	@Override
	public int selectSearchWorkforceListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Workforce-Mapper.selectSearchWorkforceListCount", cri);
		return count;
	}

	@Override
	public WorkforceVO selectWorkforce(int workforce_number) throws SQLException {
		WorkforceVO workforce = session.selectOne("Workforce-Mapper.selectWorkforce", workforce_number);
		return workforce;
	}
	
	@Override
	public int selectWorkforceSeqNext() throws SQLException {
		session.update("Workforce-Mapper.selectWorkforceSeqNext");
		return 0;
	}

	

	@Override
	public void insertWorkforce(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.insertWorkforce", workforce);
		
	}

	@Override
	public void updateWorkforceForProjectStart(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.updateWorkforceForProjectStart", workforce);		
	}

	@Override
	public void updateWorkforceForProjectEnd(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.updateWorkforceForProjectEnd", workforce);
		
	}

	
	@Override
	public void deleteWorkforce(int workforce_number) throws SQLException {
		session.update("Workforce-Mapper.deleteWorkforce", workforce_number);
		
	}

}
