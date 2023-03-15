package com.sbs.IdH.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dao.WorkforceDAO;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.WorkforceVO;

public class WorkforceServiceImpl implements WorkforceService {

	private WorkforceDAO workforceDAO;
	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public void setWorkforceDAO(WorkforceDAO workforceDAO) {
		this.workforceDAO = workforceDAO;
	}

	@Override
	public void registWorkforce(WorkforceVO workforce) throws Exception {
		workforceDAO.insertWorkforce(workforce);
	}

	@Override
	public void modifyWorkforce(WorkforceVO workforce) throws Exception {
	}

	@Override
	public void removeWorkforce(int workforce_number) throws Exception {
		workforceDAO.deleteWorkforce(workforce_number);

	}

	@Override
	public WorkforceVO selectWorkforce(int workforce_number) throws Exception {
		return workforceDAO.selectWorkforce(workforce_number);
	}

	@Override
	public Map<String, Object> selectWorkforceList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("workforceList", workforceDAO.selectSearchWorkforceList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(workforceDAO.selectSearchWorkforceListCount(cri));
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public ChartVO selectChart(int project_number) throws Exception {

		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c3 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c4 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c5 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c6 = new HashMap<String, Object>();

		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number);

		// 인력 계획 총 인력 인수. status 1
		cri.setStatus(1);
		List<Map<String, Object>> c1_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", "계획 인수");
		c1_list.add(c1_list_label);
		c1_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		// 현재 일하고 있는 인력. status 2
		cri.setStatus(2);
		List<Map<String, Object>> c2_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c2_list_label = new HashMap<String, Object>();
		c2_list_label.put("v", "현재 인력");
		c2_list.add(c2_list_label);
		c2_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		// type이 1면 기획
		cri.setType(1);
		List<Map<String, Object>> c3_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c3_list_label = new HashMap<String, Object>();
		c3_list_label.put("v", "기획");
		c3_list.add(c3_list_label);
		c3_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		// 설계
		cri.setType(2);
		List<Map<String, Object>> c4_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c4_list_label = new HashMap<String, Object>();
		c4_list_label.put("v", "설계");
		c4_list.add(c4_list_label);
		c4_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		// 구현
		cri.setType(3);
		List<Map<String, Object>> c5_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c5_list_label = new HashMap<String, Object>();
		c5_list_label.put("v", "구현");
		c5_list.add(c5_list_label);
		c5_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		// 테스트
		cri.setType(4);
		List<Map<String, Object>> c6_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c6_list_label = new HashMap<String, Object>();
		c6_list_label.put("v", "테스트");
		c6_list.add(c6_list_label);
		c6_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		rowMap_c1.put("c", c1_list);
		rowMap_c2.put("c", c2_list);
		rowMap_c3.put("c", c3_list);
		rowMap_c4.put("c", c4_list);
		rowMap_c5.put("c", c5_list);
		rowMap_c6.put("c", c6_list);

		ChartVO chart = new ChartVO();
		chart.workforceColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		chart.rowSet(rowMap_c3);
		chart.rowSet(rowMap_c4);
		chart.rowSet(rowMap_c5);
		chart.rowSet(rowMap_c6);

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
		List<Map<String, Object>> c0_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();

		c0_list_label.put("v", projectDAO.selectProject(project_number1).getProject_name());
		c0_list.add(c0_list_label);
		c0_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		cri.setProject_number(project_number2);
		List<Map<String, Object>> c1_list = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", projectDAO.selectProject(project_number2).getProject_name());
		c1_list.add(c1_list_label);
		c1_list.add(workforceDAO.selectWorkforceCountForChart(cri));

		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);

		ChartVO chart = new ChartVO();
		chart.workforceColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);

		chart.resultSet();
		return chart;

	}

}
