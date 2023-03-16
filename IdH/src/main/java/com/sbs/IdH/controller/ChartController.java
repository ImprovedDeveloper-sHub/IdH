package com.sbs.IdH.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.IdH.dto.ChartVO;
import com.sbs.IdH.service.BudgetService;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.UnitworkService;

@Controller
public class ChartController {

	
	@Resource(name="budgetService")
	private BudgetService budgetService;
	@Resource(name="unitworkService")
	private UnitworkService unitworkService;
	@Resource(name="projectService")
	private ProjectService projectService;
	
	@GetMapping("/subMenuTest")
	public void subMenuTest() {}
	
	
	
	
	
	@PostMapping("/budget")
	@ResponseBody
	public Map<String, Object> budget(@RequestParam int project_number) throws Exception {
		ChartVO chart = budgetService.selectChart(project_number);
		return chart.getResult();
	}
	
	@PostMapping("/budgetComparison")
	@ResponseBody
	public Map<String, Object> budgetComparison() throws Exception {
		ChartVO chart = budgetService.selectChartForComparison(1, 2);
		return chart.getResult();
	}


	@PostMapping("/unitwork")
	@ResponseBody
	public Map<String, Object> unitwork() throws Exception {
		ChartVO chart = unitworkService.selectChart(1);
		return chart.getResult();
	}
	
	@PostMapping("/unitworkComparison")
	@ResponseBody
	public Map<String, Object> unitworkComparison() throws Exception {
		ChartVO chart = unitworkService.selectChartForComparison(1, 2);
		return chart.getResult();
	}
	
	
	@PostMapping("/workforce")
	@ResponseBody
	public Map<String, Object> workforce() throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
	
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		Map<String, Object> colMap1 = new HashMap<String,Object>();
		Map<String, Object> colMap2 = new HashMap<String,Object>();
		
		
		
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2 = new HashMap<String,Object>();
		
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c1_v2 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v2 = new HashMap<String,Object>();
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		colMap2.put("label","인력");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		
		
		
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",20);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",17);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		dataMap.put("rows",rows);
		
		
		return dataMap;
	}
	
	
	@PostMapping("/issue")
	@ResponseBody
	public Map<String, Object> issue() throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
	
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		Map<String, Object> colMap1 = new HashMap<String,Object>();
		Map<String, Object> colMap2 = new HashMap<String,Object>();
		
		
		
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2 = new HashMap<String,Object>();
		
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c1_v2 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v2 = new HashMap<String,Object>();
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		colMap2.put("label","이슈");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		
		
		
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",20);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",17);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		dataMap.put("rows",rows);
		
		
		return dataMap;
	}
	
	
	@PostMapping("/product")
	@ResponseBody
	public Map<String, Object> product() throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
	
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		Map<String, Object> colMap1 = new HashMap<String,Object>();
		Map<String, Object> colMap2 = new HashMap<String,Object>();
		
		
		
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2 = new HashMap<String,Object>();
		
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c1_v2 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v2 = new HashMap<String,Object>();
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		colMap2.put("label","산출물");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		
		
		
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",20);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",17);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		dataMap.put("rows",rows);
		
		
		return dataMap;
	}
	
	
	@PostMapping("/schedule")
	@ResponseBody
	public Map<String, Object> schedule() throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
	
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		Map<String, Object> colMap1 = new HashMap<String,Object>();
		Map<String, Object> colMap2 = new HashMap<String,Object>();
		
		
		
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2 = new HashMap<String,Object>();
		
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap_c1_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c1_v2 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v1 = new HashMap<String,Object>();
		Map<String, Object> rowMap_c2_v2 = new HashMap<String,Object>();
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		colMap2.put("label","일정");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		
		
		
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",20);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",17);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		dataMap.put("rows",rows);
		
		
		return dataMap;
	}
	
}


	
	

