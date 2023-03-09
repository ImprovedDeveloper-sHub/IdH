package com.sbs.IdH.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.BudgetService;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.ScheduleService;
import com.sbs.IdH.service.UnitworkService;
import com.sbs.IdH.service.WorkforceService;


@Controller
@RequestMapping("projectManage")
public class ProjectManageController {

	
	@Resource
	private ProjectService projectService;
	@Resource
	private BudgetService budgetService;
	@Resource
	private UnitworkService unitworkService;
	@Resource
	private ScheduleService scheduleService;
	@Resource
	private WorkforceService workforceService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public void setBudgetService(BudgetService budgetService) {
		this.budgetService = budgetService;
	}
	public void setUnitworkService(UnitworkService unitworkService) {
		this.unitworkService = unitworkService;
	}
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	public void setWorkforceService(WorkforceService workforceService) {
		this.workforceService = workforceService;
	}
	@GetMapping("/main")
	public ModelAndView projectManage(SearchCriteria cri, ModelAndView mnv) throws Exception {
		mnv.addAllObjects(projectService.selectProceedingProject(cri));
		mnv.addAllObjects(projectService.selectEndProject(cri));
		mnv.setViewName("projectManage/main");
		return mnv;
	}
	
	
	@GetMapping("/regist")
	public ModelAndView regist(ModelAndView mnv) {
		
		return mnv;
	}
	
	@GetMapping("/manage")
	public ModelAndView manage(ModelAndView mnv, SearchCriteria cri, int project_number) throws Exception {
		mnv.addAllObjects( budgetService.selectBudgetListforProject(project_number));
		mnv.addAllObjects( workforceService.selectWorkforceList(cri));
		mnv.addAllObjects( unitworkService.selectUnitworkList(cri));
		mnv.addAllObjects( scheduleService.selectScheduleList(cri));
		return mnv;
	}
	
	
	
	
	@PostMapping("/getProceeding")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getProceeding(SearchCriteria cri) throws Exception{
		System.out.println("searchType" + cri.getSearchType());
		System.out.println("keyword" + cri.getKeyword());
		
		ResponseEntity<Map<String,Object>> entity =null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = projectService.selectProceedingProject(cri);
			status = HttpStatus.OK;
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String,Object>>(dataMap, status);
		
		return entity;
	}
	
	
	@PostMapping("/getEnd")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getEnd(SearchCriteria cri) throws Exception{
		
		
		ResponseEntity<Map<String,Object>> entity =null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = projectService.selectEndProject(cri);
			status = HttpStatus.OK;
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String,Object>>(dataMap, status);
		
		return entity;
	}
	
	
	

	
	
	
}
