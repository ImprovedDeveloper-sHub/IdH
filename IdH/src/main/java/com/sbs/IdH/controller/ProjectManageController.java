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
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.UnitworkVO;
import com.sbs.IdH.dto.WorkforceVO;
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
	
	
	
	@GetMapping("/registBudgetForm")
	public ModelAndView registBudgetForm(ModelAndView mnv) {
		return mnv;
	}
	@PostMapping("/registBudget")
	public ModelAndView registBudget(ModelAndView mnv, BudgetVO budget) throws Exception{
		budgetService.registBudget(budget);
		return mnv;
	}
	@GetMapping("/modifyBudgetForm")
	public ModelAndView modifyBudgetForm(ModelAndView mnv, int budget_number) throws Exception {
		mnv.addObject("budget", budgetService.selectBudget(budget_number));
		return mnv;
	}
	@PostMapping("/modifyBudget")
	public ModelAndView modifyBudget(ModelAndView mnv, BudgetVO budget)throws Exception {
		budgetService.modifyBudget(budget);
		return mnv;
	}
	
	@GetMapping("/budgetDetail")
	public ModelAndView budgetDetail(ModelAndView mnv, int budget_number) throws Exception {
		mnv.addObject("budget", budgetService.selectBudget(budget_number));
		return mnv;
	}
	
	@GetMapping("/registWorkforceForm") 
	public ModelAndView registworkforceForm(ModelAndView mnv) {
		return mnv;
	}
	@PostMapping("/registWorkforce") 
	public ModelAndView registWorkforce(ModelAndView mnv, WorkforceVO workforce) throws Exception {
		workforceService.registWorkforce(workforce);
		return mnv;
	}
	@GetMapping("/modifyWorkforceForm")
	public ModelAndView registWorkforceForm(ModelAndView mnv) {
		return mnv;
	}
	@PostMapping("/modifyWorkforce")
	public ModelAndView modifyWorkforce(ModelAndView mnv, WorkforceVO workforce) throws Exception{
		workforceService.modifyWorkforce(workforce);
		return mnv;
	}
	@GetMapping("/workforceDetail")
	public ModelAndView workforceDetail(ModelAndView mnv, int workforce_number) throws Exception {
		mnv.addObject("workforce", workforceService.selectWorkforce(workforce_number));
		return mnv;
	}
	
	
	@PostMapping("/registUnitwork")
	public ModelAndView registUnitwork(ModelAndView mnv, UnitworkVO unitwork) throws Exception {
		unitworkService.registUnitwork(unitwork);
		return mnv;
	}
	
	@GetMapping("/registUnitworkForm")
	public ModelAndView registUnitworkForm(ModelAndView mnv) {
		return mnv;
	}
	
	@GetMapping("/modifyUnitwork")
	public ModelAndView modifyUnitwork(ModelAndView mnv, UnitworkVO unitwork) throws Exception{
		unitworkService.modifyUnitwork(unitwork);
		return mnv;
	}
	
	@GetMapping("/modifyUnitworkForm")
	public ModelAndView modifyUnitworkForm(ModelAndView mnv) {
		return mnv;
	}
	
	
	@GetMapping("/registScheduleForm")
	public ModelAndView registscheduleForm(ModelAndView mnv) {
		
		return mnv;
	}
	
	@GetMapping("/registSchedule")
	public ModelAndView registSchedule(ModelAndView mnv) throws Exception{
		
		return mnv;
	}
	@GetMapping("/modifyScheduleForm")
	public ModelAndView modifyScheduleForm(ModelAndView mnv) {
		return mnv;
	}
	
	@GetMapping("/modifySchedule")
	public ModelAndView modifySchedule(ModelAndView mnv) throws Exception{
		return mnv;
	}
	
	
	
	@GetMapping("/manage")
	public ModelAndView manage(ModelAndView mnv, SearchCriteria cri) throws Exception {
		  mnv.addAllObjects( budgetService.selectBudgetList(cri));
		  //mnv.addAllObjects( workforceService.selectWorkforceList(cri));
		  mnv.addAllObjects( unitworkService.selectUnitworkList(cri));
		  mnv.addAllObjects( scheduleService.selectScheduleList(cri));
		return mnv;
	}
	
	
	
	
	@PostMapping("/getProceeding")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getProceeding(SearchCriteria cri) throws Exception{
		
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
