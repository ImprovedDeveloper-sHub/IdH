package com.sbs.IdH.service;

import java.util.List;
import java.util.Map;

import com.sbs.IdH.dto.BudgetVO;

public interface BudgetService {

	public BudgetVO selectBudget(int budget_number) throws Exception;
	
	public Map<String,Object> selectBudgetListforProject(int project_number) throws Exception;
	
	public Map<String,Object> selectBudgetListByMemberId(int project_member_id) throws Exception;
	
	public void registBudget(BudgetVO budget) throws Exception;
	
	public void removeBudget(int budget_number) throws Exception;
	
	public void updateBudget(BudgetVO budget) throws Exception;
	
	
	
}
