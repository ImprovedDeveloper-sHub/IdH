package com.sbs.IdH.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.BudgetDAO;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dao.ScheduleDAO;
import com.sbs.IdH.dao.UnitworkDAO;
import com.sbs.IdH.dao.WorkforceDAO;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ProjectVO;
import com.sbs.IdH.dto.ScheduleVO;
import com.sbs.IdH.dto.UnitworkVO;

public class ProjectServiceImpl implements ProjectService {

	ProjectDAO projectDAO;
	BudgetDAO budgetDAO;
	UnitworkDAO unitworkDAO;
	WorkforceDAO workforceDAO;
	ScheduleDAO scheduleDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void setBudgetDAO(BudgetDAO budgetDAO) {
		this.budgetDAO = budgetDAO;
	}

	public void setUnitworkDAO(UnitworkDAO unitworkDAO) {
		this.unitworkDAO = unitworkDAO;
	}

	public void setWorkforceDAO(WorkforceDAO workforceDAO) {
		this.workforceDAO = workforceDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	@Override
	public void registProject(ProjectVO project) throws Exception {
		projectDAO.insertProject(project);
	}

	@Override
	public void updateProject(ProjectVO project) throws Exception {
		projectDAO.updateProjectForProjectStart(project);

	}

	@Override
	public void removeProject(int project_number) throws Exception {
		projectDAO.deleteProject(project_number);

	}

	@Override
	public ProjectVO selectProject(int project_number) throws Exception {
		return projectDAO.selectProject(project_number);
	}

	@Override
	public Map<String, Object> selectProjectList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));

		dataMap.put("pageMaker", pageMaker);
		dataMap.put("projectList", projectDAO.selectSearchProjectList(cri));
		return dataMap;
	}

	@Override
	public Map<String, Object> selectProceedingProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		cri.setStatus(1);
		cri.setPerPageNum(5);
		dataMap.put("proceedingProjectList", projectDAO.selectSearchProjectList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));
		dataMap.put("proceedingPageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public Map<String, Object> selectEndProject(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		cri.setStatus(2);
		cri.setPerPageNum(5);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(projectDAO.selectSearchProjectListCount(cri));
		dataMap.put("endProjectList", projectDAO.selectSearchProjectList(cri));
		dataMap.put("endPageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public Map<String, Object> selectProjectPlanByBusiness_number2(int business_number) throws Exception {
		List<Integer> project_numberList = projectDAO.selectProjectByBusinessNumber(business_number);

		SearchCriteria cri = new SearchCriteria();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		cri.setStatus(1);
		List<List<BudgetVO>> budgetList = new ArrayList<List<BudgetVO>>();
		List<List<UnitworkVO>> unitworkList = new ArrayList<List<UnitworkVO>>();
		List<List<ScheduleVO>> scheduleList = new ArrayList<List<ScheduleVO>>();

		for (int project_number : project_numberList) {
			System.out.println(project_number);
			cri.setProject_number(project_number);

			List<BudgetVO> budgetLi = budgetDAO.selectSearchBudgetList(cri);
			if (!budgetLi.isEmpty()) {
				budgetList.add(budgetLi);
			}
			if (!unitworkDAO.selectSearchUnitworkList(cri).isEmpty()) {
				unitworkList.add(unitworkDAO.selectSearchUnitworkList(cri));
			}
			if (!budgetDAO.selectSearchBudgetList(cri).isEmpty()) {
				scheduleList.add(scheduleDAO.selectSearchScheduleList(cri));
			}

		}

		dataMap.put("budgetList", budgetList);
		dataMap.put("unitworkList", unitworkList);
		dataMap.put("scheduleList", scheduleList);
		// dataMap.put("workforceList", workforceDAO.selectSearchWorkforceList(cri));
		return dataMap;
	}

	@Override
	public Map<String, Object> selectProjectPlanByBusiness_number(int business_number) throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setBusiness_number(business_number);
		cri.setStatus(1);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<UnitworkVO> unitworkList = unitworkDAO.selectSearchUnitworkList(cri);
		List<ScheduleVO> scheduleList = scheduleDAO.selectSearchScheduleList(cri);
		List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetList(cri);


		dataMap.put("budgetList", budgetList);
		dataMap.put("unitworkList", unitworkList);
		dataMap.put("scheduleList", scheduleList);
		// dataMap.put("workforceList", workforceDAO.selectSearchWorkforceList(cri));
		return dataMap;
	}

}
