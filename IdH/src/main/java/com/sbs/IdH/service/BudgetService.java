package com.sbs.IdH.service;

import com.sbs.IdH.dto.BudgetVO;

public interface BudgetService {

	public void selectBudget(int budget_number) throws Exception;
	
	public void selectBudgetListforProject(int project_number) throws Exception;
	
	public void selectBudgetListByMemberId(int project_member_id) throws Exception;
	
	public void registBudget(BudgetVO budget) throws Exception;
	
	public void removeBudget(int budget_number) throws Exception;
	
	public void updateBudget(BudgetVO budget) throws Exception;
	
	
	
}
