package com.sbs.IdH.service;

import java.util.List;

import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dto.BudgetVO;

public class BudgetServiceImpl implements BudgetService {

	
	private BudgetDAO budgetDAO;
	
	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}
	
	@Override
	public BudgetVO selectBudget(int budget_number) throws Exception {
		BudgetVO budget = budgetDAO.selectBudget(budget_number);
		return budget;
	}

	@Override
	public List<BudgetVO> selectBudgetListforProject(int project_number) throws Exception {
		List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetListForProject(project_number);
		return budgetList;
	}

	@Override
	public List<BudgetVO> selectBudgetListByMemberId(int project_member_id) throws Exception {
		
		return null;
	}

	@Override
	public void registBudget(BudgetVO budget) throws Exception {
		budget.setBudget_number(budgetDAO.selectBudgetSeqNext());
		budgetDAO.insertBudget(budget);
		
	}

	@Override
	public void removeBudget(int budget_number) throws Exception {
		budgetDAO.deleteBudget(budget_number);
	}

	@Override
	public void updateBudget(BudgetVO budget) throws Exception {
		budgetDAO.updateBudget(budget);
	}
	
	
	

}
