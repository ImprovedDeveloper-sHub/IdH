package com.sbs.IdH.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.ProjectVO;

public class BudgetServiceImpl implements BudgetService {

	
	private BudgetDAO budgetDAO;
	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
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
	public void modifyBudget(BudgetVO budget) throws Exception {
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

	@Override
	public ChartVO selectChart(int project_number) throws Exception {

		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c3 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c4 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c5 = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number);
		//계획예산.
		cri.setStatus(1);
		List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		c0_list_label.put("v", "계획 예산");
		c0_list.add(c0_list_label);
		c0_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		//사용예산. status가 2
		cri.setStatus(2);
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", "사용 예산");
		c1_list.add(c1_list_label);
		c1_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		//type이 1면 인건비
		cri.setType(1);
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c2_list_label = new HashMap<String, Object>();
		c2_list_label.put("v", "인건비");
		c2_list.add(c2_list_label);
		c2_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		//비품비
		cri.setType(2);
		List<Map<String,Object>> c3_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c3_list_label = new HashMap<String, Object>();
		c3_list_label.put("v", "비품비");
		c3_list.add(c3_list_label);
		c3_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		//교통비
		cri.setType(3);
		List<Map<String,Object>> c4_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c4_list_label = new HashMap<String, Object>();
		c4_list_label.put("v", "교통비");
		c4_list.add(c4_list_label);
		c4_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);
		rowMap_c3.put("c", c2_list);
		rowMap_c4.put("c", c3_list);
		rowMap_c5.put("c", c4_list);
		
		ChartVO chart = new ChartVO();
		chart.budgetColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		chart.rowSet(rowMap_c3);
		chart.rowSet(rowMap_c4);
		chart.rowSet(rowMap_c5);
		
		chart.resultSet();
		return chart;
	}
	
	
	@Override
	public ChartVO selectChartForComparison(int project_number1, int project_number2) throws Exception {
		
		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number1);
		cri.setStatus(2);
		List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		
		
		c0_list_label.put("v", projectDAO.selectProject(project_number1).getProject_name());
		c0_list.add(c0_list_label);
		c0_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		cri.setProject_number(project_number2);
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", projectDAO.selectProject(project_number2).getProject_name());
		c1_list.add(c1_list_label);
		c1_list.add(budgetDAO.selectBudgetPriceForChart(cri));
		
		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);
		
		
		ChartVO chart = new ChartVO();
		chart.budgetColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		
		
		chart.resultSet();
		return chart;
		
	}

}
