package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
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
	public Map<String,Object> selectBudgetListforProject(int project_number) throws Exception {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetListForProject(project_number);
		dataMap.put("budgetList", budgetList);
		
		
		return dataMap;
	}

	@Override
	public Map<String,Object> selectBudgetListByMemberId(int project_member_id) throws Exception {
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

	@Override
	public Map<String, Object> selectBudgetList(SearchCriteria cri) throws Exception {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetList(cri);
		dataMap.put("budgetList", budgetList);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(budgetDAO.selectSearchBudgetListCount(cri));
		dataMap.put("pageMaker",pageMaker);
		return dataMap;
	}
	
	
	

}
