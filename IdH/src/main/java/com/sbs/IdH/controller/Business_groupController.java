package com.sbs.IdH.controller;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.BusinessService;

@Controller
@RequestMapping("business/group")
public class Business_groupController {
	
	@Resource(name="businessService")
	private BusinessService businessService;
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@GetMapping("/main")
	public ModelAndView groupMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/detail")
	public ModelAndView groupDetail(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
}
