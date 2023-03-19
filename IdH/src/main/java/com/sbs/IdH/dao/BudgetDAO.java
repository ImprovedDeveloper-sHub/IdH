package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;

public interface BudgetDAO {

	
	List<BudgetVO> selectSearchBudgetList(SearchCriteria cri) throws SQLException;

	List<BudgetVO> selectSearchBudgetListForProject(int project_number) throws SQLException;
	
	int selectSearchBudgetListCount(SearchCriteria cri) throws SQLException;

	BudgetVO selectBudget(int budget_number) throws SQLException;	

	int selectBudgetSeqNext() throws SQLException;

	void insertBudget(BudgetVO budget) throws SQLException;

	void updateBudget(BudgetVO budget) throws SQLException;
	
	void updateBudgetForRegistProject(BudgetVO budget) throws SQLException;

	void updateBudgetForProjectEnd(BudgetVO budget) throws SQLException;
	
	void deleteBudget(int budget_number) throws SQLException;
	
	Map<String,Object> selectBudgetPriceForChart(SearchCriteria cri)throws SQLException;
	
}
