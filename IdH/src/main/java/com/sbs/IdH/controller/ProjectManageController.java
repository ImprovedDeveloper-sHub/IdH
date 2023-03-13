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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ScheduleVO;
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
	public ModelAndView registbudgetForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registBudget";
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/registBudget")
	public String registBudget(RedirectAttributes rttr, BudgetVO budget) throws Exception{
		budgetService.registBudget(budget);
		//System.out.println(budget);
		String url = "redirect:/projectManage/main";
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}
	

	@GetMapping("/modifyBudgetForm")
	public ModelAndView modifyBudgetForm(ModelAndView mnv, int budget_number) throws Exception{
		String url = "/projectManage/modifyBudget";
		mnv.addObject("budget", budgetService.selectBudget(budget_number));
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/modifyBudget")
	public String modifyBudget(RedirectAttributes rttr, BudgetVO budget) throws Exception{
		String url = "redirect:/projectManage/budgetDetail";
		budgetService.modifyBudget(budget);
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("budget_number", budget.getBudget_number());
		return url;
	}
	
	
	@GetMapping("/budgetDetail")
	public ModelAndView budgetDetail(ModelAndView mnv, int budget_number) throws Exception {
		mnv.addObject("budget", budgetService.selectBudget(budget_number));
		
		return mnv;
	}
	
	
	@GetMapping("/deleteBudget")
	public String deleteBudget(RedirectAttributes rttr, int budget_number) throws Exception {
		String url = "redirect:/projectManage/budgetDetail";
		budgetService.removeBudget(budget_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("budget_number", budget_number);

		return url;
	}
	
	
	
	
	
	
	@GetMapping("/registWorkforceForm") 
	public ModelAndView registWorkforceForm(ModelAndView mnv) {
		String url = "/projectManage/registWorkforce";
		mnv.setViewName(url);
		return mnv;
	}
	@PostMapping("/registWorkforce") 
	public ModelAndView registWorkforce(ModelAndView mnv, WorkforceVO workforce) throws Exception {
		workforceService.registWorkforce(workforce);
		return mnv;
	}
	@GetMapping("/modifyWorkforceForm")
	public ModelAndView modifyWorkforceForm(ModelAndView mnv) {
		String url = "/projectManage/modifyWorkforce";
		mnv.setViewName(url);
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
	
	
	
	
	
	@GetMapping("/registUnitworkForm")
	public ModelAndView registunitworkForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registUnitwork";
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/registUnitwork")
	public String registUnitwork(RedirectAttributes rttr, UnitworkVO unitwork) throws Exception{
		unitworkService.registUnitwork(unitwork);
		//System.out.println(unitwork);
		String url = "redirect:/projectManage/main";
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}
	

	@GetMapping("/modifyUnitworkForm")
	public ModelAndView modifyUnitworkForm(ModelAndView mnv, int unitwork_number) throws Exception{
		String url = "/projectManage/modifyUnitwork";
		mnv.addObject("unitwork", unitworkService.selectUnitwork(unitwork_number));
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/modifyUnitwork")
	public String modifyUnitwork(RedirectAttributes rttr, UnitworkVO unitwork) throws Exception{
		String url = "redirect:/projectManage/unitworkDetail";
		unitworkService.modifyUnitwork(unitwork);
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("unitwork_number", unitwork.getUnitwork_number());
		return url;
	}
	
	
	@GetMapping("/unitworkDetail")
	public ModelAndView unitworkDetail(ModelAndView mnv, int unitwork_number) throws Exception {
		mnv.addObject("unitwork", unitworkService.selectUnitwork(unitwork_number));
		
		return mnv;
	}
	
	
	@GetMapping("/deleteUnitwork")
	public String deleteUnitwork(RedirectAttributes rttr, int unitwork_number) throws Exception {
		String url = "redirect:/projectManage/unitworkDetail";
		unitworkService.removeUnitwork(unitwork_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("unitwork_number", unitwork_number);

		return url;
	}
	
	
	@GetMapping("/registScheduleForm")
	public ModelAndView registscheduleForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registSchedule";
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/registSchedule")
	public String registSchedule(RedirectAttributes rttr, ScheduleVO schedule) throws Exception{
		scheduleService.registSchedule(schedule);
		//System.out.println(schedule);
		String url = "redirect:/projectManage/main";
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}
	

	@GetMapping("/modifyScheduleForm")
	public ModelAndView modifyScheduleForm(ModelAndView mnv, int schedule_number) throws Exception{
		String url = "/projectManage/modifySchedule";
		mnv.addObject("schedule", scheduleService.selectSchedule(schedule_number));
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/modifySchedule")
	public String modifySchedule(RedirectAttributes rttr, ScheduleVO schedule) throws Exception{
		String url = "redirect:/projectManage/scheduleDetail";
		scheduleService.modifySchedule(schedule);
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("schedule_number", schedule.getSchedule_number());
		return url;
	}
	
	
	@GetMapping("/scheduleDetail")
	public ModelAndView scheduleDetail(ModelAndView mnv, int schedule_number) throws Exception {
		mnv.addObject("schedule", scheduleService.selectSchedule(schedule_number));
		
		return mnv;
	}
	
	
	@GetMapping("/deleteSchedule")
	public String deleteSchedule(RedirectAttributes rttr, int schedule_number) throws Exception {
		String url = "redirect:/projectManage/scheduleDetail";
		scheduleService.removeSchedule(schedule_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("schedule_number", schedule_number);

		return url;
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
