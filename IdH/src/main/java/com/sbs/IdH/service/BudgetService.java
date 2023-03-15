package com.sbs.IdH.service;

import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ChartVO;

public interface BudgetService {

	public BudgetVO selectBudget(int budget_number) throws Exception;
	
	public Map<String,Object> selectBudgetListforProject(int project_number) throws Exception;
	
	public Map<String,Object> selectBudgetListByMemberId(String member_id) throws Exception;
	
	public void registBudget(BudgetVO budget) throws Exception;
	
	public void removeBudget(int budget_number) throws Exception;
	
	public void modifyBudget(BudgetVO budget) throws Exception;

	public Map<String, Object> selectBudgetList(SearchCriteria cri) throws Exception;
	
	public ChartVO selectChart(int project_number)throws Exception;

	public ChartVO selectChartForComparison(int project_number, int project_number2)throws Exception;


}
