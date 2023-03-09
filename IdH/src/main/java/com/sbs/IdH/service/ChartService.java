
package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.ProjectVO;

public class ChartService {
	
	
	BudgetDAO budgetDAO;
	ProjectDAO projectDAO;
	
	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public HashMap<String, Object> budgetState(int project_number) throws Exception {
		ChartVO chartData = new ChartVO();
		
		List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetListForProject(project_number);
		for(BudgetVO budget : budgetList) {
			Map<String, Object> rowMap_c_name = new HashMap<String,Object>();
			rowMap_c_name.put("v",budget.getBudget_name());
			Map<String, Object> rowMap_c_data = new HashMap<String,Object>();
			rowMap_c_data.put("v",budget.getBudget_price());
			
		}
		ProjectVO project = projectDAO.selectProject(project_number);
		String project_name = project.getProject_name(); 
		
		
		
		return chartData.getDataMap();
	}
	
	
}
