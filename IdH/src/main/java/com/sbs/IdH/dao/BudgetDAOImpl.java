package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);
		List<BudgetVO> budgetList = session.selectList("Budget-Mapper.selectBudgetList", cri, rowBounds);
		return budgetList;
	}

	@Override
	public List<BudgetVO> selectSearchBudgetListForProject(int project_number) throws SQLException {
		List<BudgetVO> budgetList = session.selectList("Budget-Mapper.selectBudgetForProject", project_number);
		return budgetList;
	}

	@Override
	public int selectSearchBudgetListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Budget-Mapper.selectSearchBudgetListCount", cri);
		return count;
	}

	@Override
	public BudgetVO selectBudget(int budget_number) throws SQLException {
		BudgetVO budget = session.selectOne("Budget-Mapper.selectBudget", budget_number);
		return budget;
	}
	
	@Override
	public int selectBudgetSeqNext() throws SQLException {
		return session.selectOne("Budget-Mapper.selectBudgetSeqNext");
	}

	

	@Override
	public void insertBudget(BudgetVO budget) throws SQLException {
		session.update("Budget-Mapper.insertBudget", budget);
		
	}

	@Override
	public void updateBudget(BudgetVO budget) throws SQLException {
		session.update("Budget-Mapper.updateBudget", budget);
	}
	

	@Override
	public void updateBudgetForProjectEnd(BudgetVO budget) throws SQLException {
		session.update("Budget-Mapper.updateBudgetForProjectEnd", budget);
		
	}

	
	@Override
	public void deleteBudget(int budget_number) throws SQLException {
		session.update("Budget-Mapper.deleteBudget", budget_number);
	}

	@Override
	public Map<String, Object> selectBudgetPriceForChart(SearchCriteria cri) throws SQLException {
		Map<String,Object> colMap = new HashMap<String, Object>();
		int price_total = session.selectOne("Budget-Mapper.selectBudgetPriceTotal", cri);
		colMap.put("v",price_total);
		return colMap;
	}

	@Override
	public void updateBudgetForRegistProject(BudgetVO budget) throws SQLException {
		session.update("Budget-Mapper.updateBudgetPlanForProjectStart", budget);
	}
	
	
	public int selectBudgetByType(SearchCriteria cri) throws SQLException{
		int price = session.selectOne("Budget-Mapper.selectSearchBudgetPrice", cri);
		return price;
	}
	

}
