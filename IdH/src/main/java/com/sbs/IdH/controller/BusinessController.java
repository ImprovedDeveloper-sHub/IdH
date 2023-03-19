package com.sbs.IdH.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.service.BusinessService;

@Controller
@RequestMapping("business")
public class BusinessController {
	
	@Resource(name="businessService")
	private BusinessService businessService;
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@GetMapping("/schedule/main")
	public ModelAndView scheduleMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@PostMapping("/schedule/main")
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
	
	@RequestMapping("/schedule/registForm")
	public String scheduleRegistForm() throws SQLException {

		String url = "/business/schedule/regist";
		
		return url;
		
	}
	
	@PostMapping(value="/schedule/regist", produces="text/plain;charset=UTF-8")
	public String scheduleRegist(HttpServletRequest request, RedirectAttributes rttr, BusinessVO business) throws SQLException {
		
		String url = "redirect:/business/schedule/main";
		
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null) business.setBusiness_name(XSStitle);
		
		businessService.regist(business);
		rttr.addFlashAttribute("from", "regist");
		
		return url;
		
	}
	
	@GetMapping("/schedule/detail")
	public ModelAndView scheduleDetail(ModelAndView mnv, int business_number) throws SQLException {
		
		mnv.addObject("business", businessService.getBusiness(business_number));
		
		return mnv;
		
	}
	
	@GetMapping("/schedule/modifyForm")
	public ModelAndView scheduleModifyForm(int business_number, ModelAndView mnv) throws SQLException {
		
		String url = "/business/schedule/modify";
		
		BusinessVO business = businessService.getBusinessForModify(business_number);
		
		mnv.addObject("business", business);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	@PostMapping(value="/schedule/modify", produces="text/plain;charset=UTF-8")
	public ModelAndView scheduleModify(int business_number, ModelAndView mnv) throws SQLException {
		
		String url = "redirect:/business/schedule/detail";
		
		
		
		return mnv;
	}
	
	@GetMapping("/budget/main")
	public ModelAndView budgetMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/budget/detail")
	public ModelAndView budgetDetail(ModelAndView mnv, int business_number) throws SQLException {
		
		mnv.addObject("business", businessService.getBusiness(business_number));
		
		return mnv;
		
	}
	
	@GetMapping("/group/main")
	public ModelAndView groupMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/group/detail")
	public ModelAndView groupDetail(ModelAndView mnv, int business_number) throws SQLException {
		
		mnv.addObject("business", businessService.getBusiness(business_number));
		
//		mnv.addObject("businessMember", businessService.getBusiness(business_number).getBusiness_member_id());
		
		return mnv;
		
	}
	
}
