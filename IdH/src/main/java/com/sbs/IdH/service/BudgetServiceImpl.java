package com.sbs.IdH.service;

import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dto.BudgetVO;

public class BudgetServiceImpl implements BudgetService {

	
	private BudgetDAO budgetDAO;
	
	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}
	
	@Override
	public void selectBudget(int budget_number) throws Exception {
		budgetDAO.selectBudget(budget_number);
	}

	@Override
	public void selectBudgetListforProject(int project_number) throws Exception {
		budgetDAO.selectSearchBudgetListForProject(project_number);
		
	}

	@Override
	public void selectBudgetListByMemberId(int project_member_id) throws Exception {
		
		
	}

	@Override
	public void registBudget(BudgetVO budget) throws Exception {
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
