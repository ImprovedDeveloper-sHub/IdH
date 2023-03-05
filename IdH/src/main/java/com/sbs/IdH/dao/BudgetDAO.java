package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;

public interface BudgetDAO {

	
	List<BudgetVO> selectSearchBudgetList(SearchCriteria cri) throws SQLException;

	List<BudgetVO> selectSearchBudgetListForProject(int project_number) throws SQLException;
	
	int selectSearchBudgetListCount(SearchCriteria cri) throws SQLException;

	BudgetVO selectBudget(int budget_number) throws SQLException;	

	void insertBudget(BudgetVO board) throws SQLException;

	void updateBudgetForProjectStart(BudgetVO board) throws SQLException;

	void updateBudgetForProjectEnd(BudgetVO board) throws SQLException;

	int selectBoardSeqNext() throws SQLException;
	
	void deleteBudget() throws SQLException;
}
