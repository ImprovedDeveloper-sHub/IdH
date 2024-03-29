package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);
		List<WorkforceVO> workforceList = session.selectList("Workforce-Mapper.selectWorkforceList", cri, rowBounds);
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
		return session.selectOne("Workforce-Mapper.selectWorkforceSeqNext");
	}

	

	@Override
	public void insertWorkforce(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.insertWorkforce", workforce);
		
	}

	@Override
	public void updateWorkforceForRegistProject(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.updateWorkforcePlanForProjectStart", workforce);		
		
	}
	@Override
	public void updateWorkforceForProjectEnd(WorkforceVO workforce) throws SQLException {
		session.update("Workforce-Mapper.updateWorkforceForProjectEnd", workforce);
		
	}

	
	@Override
	public void deleteWorkforce(int workforce_number) throws SQLException {
		session.update("Workforce-Mapper.deleteWorkforce", workforce_number);
		
	}
	
	@Override
	public Map<String, Object> selectWorkforceCountForChart(SearchCriteria cri) throws SQLException {
		Map<String,Object> colMap = new HashMap<String, Object>();
		int workforce_count = session.selectOne("Workforce-Mapper.selectSearchWorkforceListCount", cri);
		colMap.put("v",workforce_count);
		return colMap;
	}
	

}
