package com.sbs.IdH.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.DateMaker;
import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dao.UnitworkDAO;
import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.dto.UnitworkVO;

public class UnitworkServiceImpl implements UnitworkService{

	
	private UnitworkDAO unitworkDAO;
	
	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public void setUnitworkDAO(UnitworkDAO unitworkDAO) {
		this.unitworkDAO = unitworkDAO;
	}
	
	@Override
	public void registUnitwork(UnitworkVO unitwork) throws Exception {
		unitwork.setUnitwork_number(unitworkDAO.selectUnitworkSeqNext());
		unitworkDAO.insertUnitwork(unitwork);
	}
	
	@Override
	public void registUnitworkPlan(UnitworkVO unitwork) throws Exception {
		unitwork.setUnitwork_status(1);
		unitwork.setUnitwork_number(unitworkDAO.selectUnitworkSeqNext());
		unitworkDAO.insertUnitwork(unitwork);
	}
	

	@Override
	public void modifyUnitwork(UnitworkVO unitwork) throws Exception {
		unitworkDAO.updateUnitwork(unitwork);
	}

	@Override
	public void removeUnitwork(int unitwork_number) throws Exception {
		unitworkDAO.deleteUnitwork(unitwork_number);
		
	}

	@Override
	public UnitworkVO selectUnitwork(int unitwork_number) throws Exception {
		return unitworkDAO.selectUnitwork(unitwork_number);
	}

	
	@Override
	public void updateUnitworkForRegistProject(int unitwork_number, int project_number) throws Exception {
		//1. 계획에 프로젝트 번호를 넣어준다.
		UnitworkVO unitwork = unitworkDAO.selectUnitwork(unitwork_number);
		unitwork.setUnitwork_project_number(project_number);
		unitworkDAO.updateUnitworkForRegistProject(unitwork);
		//2. 실제 프로젝트 진행중에 사용할 현황을 위한 단위업무를 등록한다.
		unitwork.setUnitwork_number(unitworkDAO.selectUnitworkSeqNext());
		unitwork.setUnitwork_status(2);
		unitworkDAO.insertUnitwork(unitwork);
	}
	
	
	@Override
	public Map<String, Object> selectUnitworkList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setPerPageNum(5);
		dataMap.put("unitworkList", unitworkDAO.selectSearchUnitworkList(cri));
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(unitworkDAO.selectSearchUnitworkListCount(cri));
		dataMap.put("pageMaker",pageMaker);
		return dataMap;
	}

	@Override
	public Map<String, Object> selectUnitworkList1(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		cri.setPerPageNum(10);
		dataMap.put("unitworkList", unitworkDAO.selectSearchUnitworkList(cri));
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(unitworkDAO.selectSearchUnitworkListCount(cri));
		dataMap.put("pageMaker",pageMaker);
		return dataMap;
	}

	@Override
	public ChartVO selectChart(int project_number) throws Exception {
		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c3 = new HashMap<String, Object>();
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number);
		//계획 단위업무
		cri.setStatus(1);
		List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		c0_list_label.put("v", "계획 단위업무");
		c0_list.add(c0_list_label);
		c0_list.add(unitworkDAO.selectUnitworkCountForChart(cri));
		
		//진행 단위업무
		cri.setStatus(2);
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", "진행 단위업무");
		c1_list.add(c1_list_label);
		c1_list.add(unitworkDAO.selectUnitworkCountForChart(cri));
		
		//종료 단위업무
		cri.setStatus(3);
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c2_list_label = new HashMap<String, Object>();
		c2_list_label.put("v", "종료 단위업무");
		c2_list.add(c2_list_label);
		c2_list.add(unitworkDAO.selectUnitworkCountForChart(cri));
		
		
		
		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);
		rowMap_c3.put("c", c2_list);
		
		ChartVO chart = new ChartVO();
		chart.unitworkColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		chart.rowSet(rowMap_c3);
		
		chart.resultSet();
		return chart;
	}

	@Override
	public ChartVO selectChartForComparison(int project_number1, int project_number2) throws Exception {
		
		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		
		
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number1);
		List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		
		
		c0_list_label.put("v", projectDAO.selectProject(project_number1).getProject_name());
		c0_list.add(c0_list_label);
		c0_list.add(unitworkDAO.selectUnitworkCountForChart(cri));
		
		cri.setProject_number(project_number2);
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", projectDAO.selectProject(project_number2).getProject_name());
		c1_list.add(c1_list_label);
		c1_list.add(unitworkDAO.selectUnitworkCountForChart(cri));
		
		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);
		
		
		ChartVO chart = new ChartVO();
		chart.unitworkColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		
		
		chart.resultSet();
		return chart;
	}
	
	@Override
	   public List<Map<String,Object>> selectUnitworkListForCalendar(SearchCriteria cri) throws Exception {
	      DateMaker dateMaker = new DateMaker();
	      List<UnitworkVO> unitworkList = unitworkDAO.selectSearchUnitworkList(cri);
	      for(UnitworkVO unitwork : unitworkList) {
	         dateMaker.setParamUnitwork(unitwork);
	      }
	      return dateMaker.getParamList();
	   }
	
}
