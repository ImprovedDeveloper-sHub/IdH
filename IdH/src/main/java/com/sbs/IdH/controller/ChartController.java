package com.sbs.IdH.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChartController {

	@GetMapping("/test")
	public void test() throws Exception {}
	
	
	@PostMapping("/test2")
	@ResponseBody
	public List test2(ModelAndView mnv) throws Exception{
		List<Object> test = new ArrayList<Object>();
		List<Object> test2 = new ArrayList<Object>();
		test2.add("Year");
		test2.add("Sales");
		test2.add("Expenses");
		List<Object> test3 = new ArrayList<Object>();
		test3.add("2004");
		test3.add(1000);
		test3.add(400);
		List<Object> test4 = new ArrayList<Object>();
		test4.add("2005");
		test4.add(1200);
		test4.add(450);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		
		return test;
	}
	
	
	@GetMapping("/test3")
	@ResponseBody
	public ModelAndView test3(ModelAndView mnv) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
	
		List<Map<String,Object>> cols = new ArrayList<Map<String,Object>>();
		Map<String, Object> colMap1 = new HashMap<String,Object>();
		Map<String, Object> colMap2 = new HashMap<String,Object>();
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		Map<String, Object> rowMap1 = new HashMap<String,Object>();
		Map<String, Object> rowMap2 = new HashMap<String,Object>();
		
		
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		
		colMap2.put("label","사람수");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		
		rowMap1.put("v","프로젝트계획");
		rowMap1.put("v","10");
		
		rowMap2.put("v","프로젝트현황");
		rowMap2.put("v","13");
		rows.add(rowMap1);
		rows.add(rowMap2);
		
		
		
		dataMap.put("cols",cols);
		dataMap.put("rows",rows);
		
		mnv.setViewName("/test");
		mnv.addAllObjects(dataMap);
		return mnv;
	}

	
	
	@GetMapping("/test4")
	@ResponseBody
	public ModelAndView test4(ModelAndView mnv) throws Exception{
		
		List<Object> test = new ArrayList<Object>();
		List<Object> test2 = new ArrayList<Object>();
		test2.add("Year");
		test2.add("Sales");
		test2.add("Expenses");
		List<Object> test3 = new ArrayList<Object>();
		test3.add("2004");
		test3.add(1000);
		test3.add(400);
		List<Object> test4 = new ArrayList<Object>();
		test4.add("2005");
		test4.add(1200);
		test4.add(450);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		mnv.addObject("test",test);
		
		mnv.setViewName("/test");
		
		
		return mnv;
	}
	
	@GetMapping("/test6")
	@ResponseBody
	public Map<String, Object> test6() throws Exception {
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
		
		
		
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",1000);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",2000);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		
		
		dataMap.put("rows",rows);
		
		
		
		
		
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		
		colMap2.put("label","예산");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		return dataMap;
	}
	
	
	
	
	
	@PostMapping("/budget")
	@ResponseBody
	public Map<String, Object> test5() throws Exception {
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
		rowMap_c1_v1.put("v","프로젝트1");
		rowMap_c1_v2.put("v",1000);
		c1_list.add(rowMap_c1_v1);
		c1_list.add(rowMap_c1_v2);
		rowMap_c1.put("c",c1_list);
		rows.add(rowMap_c1);
		rowMap_c2_v1.put("v","프로젝트2");
		rowMap_c2_v2.put("v",2000);
		c2_list.add(rowMap_c2_v1);
		c2_list.add(rowMap_c2_v2);
		rowMap_c2.put("c",c2_list);
		rows.add(rowMap_c2);
		dataMap.put("rows",rows);
		colMap1.put("label","프로젝트");
		colMap1.put("type","string");
		colMap2.put("label","예산");
		colMap2.put("type","number");
		cols.add(colMap1);
		cols.add(colMap2);
		dataMap.put("cols",cols);
		
		return dataMap;
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


	
	

