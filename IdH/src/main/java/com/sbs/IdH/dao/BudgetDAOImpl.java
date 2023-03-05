package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;

public class BudgetDAOImpl implements BudgetDAO{

	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<BudgetVO> selectSearchBudgetList(SearchCriteria cri) throws SQLException {
		session.selectList("Budget-Mapper.selectBudgetList", cri);
		return null;
	}

	@Override
	public List<BudgetVO> selectSearchBudgetListForProject(int project_number) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectSearchBudgetListCount(SearchCriteria cri) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BudgetVO selectBudget(int budget_number) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBudget(BudgetVO board) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBudgetForProjectStart(BudgetVO board) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBudgetForProjectEnd(BudgetVO board) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteBudget() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}