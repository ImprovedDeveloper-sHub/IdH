package com.sbs.IdH.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BudgetVO;
import com.sbs.IdH.dto.ProjectVO;
import com.sbs.IdH.dto.ScheduleVO;
import com.sbs.IdH.dto.UnitworkVO;
import com.sbs.IdH.dto.WorkforceVO;
import com.sbs.IdH.service.BudgetService;
import com.sbs.IdH.service.BusinessService;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.RequireService;
import com.sbs.IdH.service.ScheduleService;
import com.sbs.IdH.service.UnitworkService;
import com.sbs.IdH.service.WorkforceService;

/**
 * @author seo
 *
 */
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
	@Resource
	private BusinessService businessService;
	@Resource
	private RequireService requireService;
	
	
	
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

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public void setRequireService(RequireService requireService) {
		this.requireService = requireService;
	}
	
	@GetMapping("/main")
	public ModelAndView main(SearchCriteria cri, ModelAndView mnv) throws Exception {
		
		SearchCriteria cri2 = cri.newCri();
		
		mnv.addAllObjects(projectService.selectProjectStatusForChart(cri2));
		
		cri.setPerPageNum(5);
		mnv.addAllObjects(projectService.selectProceedingProject(cri));
		mnv.addAllObjects(projectService.selectEndProject(cri));
		mnv.setViewName("projectManage/main");
		return mnv;
	}
		
		
		
		
		
		
		
		
		
	
	@GetMapping("/manage")
	public ModelAndView manage(ModelAndView mnv, SearchCriteria cri, HttpServletRequest request) throws Exception {
		
		mnv.addAllObjects(projectService.selectProjectList(cri));
		SearchCriteria cri2 = cri.newCri();
		mnv.addAllObjects(budgetService.selectBudgetList(cri2));
		SearchCriteria cri3 = cri.newCri();
		mnv.addAllObjects(workforceService.selectWorkforceList(cri3));
		SearchCriteria cri4 = cri.newCri();
		mnv.addAllObjects(unitworkService.selectUnitworkList(cri4));
		SearchCriteria cri5 = cri.newCri();
		mnv.addAllObjects(scheduleService.selectScheduleList(cri5));
		
		mnv.addObject("project_num", 0);
		return mnv;
	}

	@GetMapping("/registProjectForm")
	public ModelAndView regist(ModelAndView mnv, HttpServletRequest request) throws Exception {
		String url = "/projectManage/registProject";
		SearchCriteria cri = new SearchCriteria();
		HttpSession session = request.getSession();
		String member_id = (String) session.getAttribute("member_id");
		cri.setMember_id(member_id);
		mnv.addAllObjects(businessService.getBusinessListNotRowBound(cri));
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/endProjectForm")
	public ModelAndView endProjectForm(ModelAndView mnv, HttpServletRequest request) throws Exception{
		SearchCriteria cri = new SearchCriteria();
		mnv.addAllObjects(projectService.selectProceedingProject(cri));
		mnv.setViewName("projectManage/endProject");
		
		return mnv;
	}

	
	@GetMapping("/endProject")
	public String endProject(int project_number, RedirectAttributes rttr)throws Exception{
		String url = "redirect:/projectManage/main";

		
		projectService.endProject(project_number);
		
		rttr.addFlashAttribute("from", "end");
		
		
		
		return url;
		
		
	}
	


	@PostMapping("/registProject")
	public String regist(@RequestParam HashMap<String, Object> dataMap, ProjectVO project, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/projectManage/manage";
		String get_budget = dataMap.get("budgetArrayParam").toString();
		String get_workforce = dataMap.get("workforceArrayParam").toString();
		String get_schedule = dataMap.get("scheduleArrayParam").toString();
		String get_unitwork = dataMap.get("unitworkArrayParam").toString();

		projectService.registProject(project);
		int project_number = project.getProject_number();
		
		if(get_budget != null & get_budget !="") {
			String[] budget_array = get_budget.split(",");
			for (String budget : budget_array) {
				budgetService.updateBudgetForRegistProject(Integer.parseInt(budget), project_number);
			}
		}
		if(get_workforce !=null & get_workforce !="") {
			String[] workforce_array = get_workforce.split(",");
			for (String workforce : workforce_array) {
				workforceService.updateWorkforceForRegistProject(Integer.parseInt(workforce) ,project_number);
			}
		}
		if(get_schedule !=null & get_schedule != "") {
			String[] schedule_array = get_schedule.split(",");
			for (String schedule : schedule_array) {
				scheduleService.updateScheduleForRegistProject(Integer.parseInt(schedule), project_number);
			}
		}
		if(get_unitwork !=null & get_unitwork !="") {
			String[] unitwork_array = get_unitwork.split(",");
			for (String unitwork : unitwork_array) {
				unitworkService.updateUnitworkForRegistProject(Integer.parseInt(unitwork), project_number);
			}
			
		}


		// projectService.registProject(project);
		return url;
	}

	



	@GetMapping("/registBudgetForm")
	public ModelAndView registbudgetForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registBudget";
		mnv.setViewName(url);
		return mnv;
	}
	
	
	@GetMapping("/registBudgetPlanForm")
	public ModelAndView registBudgetPlanForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registBudgetPlan";
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/registBudget")
	public String registBudget(RedirectAttributes rttr, BudgetVO budget) throws Exception {
		budgetService.registBudget(budget);
		// System.out.println(budget);
		String url = "redirect:/projectManage/main";
		rttr.addFlashAttribute("from", "regist");
		return url;
	}

	@GetMapping("/modifyBudgetForm")
	public ModelAndView modifyBudgetForm(ModelAndView mnv, int budget_number) throws Exception {
		String url = "/projectManage/modifyBudget";
		mnv.addObject("budget", budgetService.selectBudget(budget_number));
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/modifyBudget")
	public String modifyBudget(RedirectAttributes rttr, BudgetVO budget) throws Exception {
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
		String url = "redirect:/projectManage/manage";
		budgetService.removeBudget(budget_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("budget_number", budget_number);

		return url;
	}

	@GetMapping("/registWorkforceForm")
	public ModelAndView registWorkforceForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registWorkforce";
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/registWorkforcePlanForm")
	public ModelAndView registWorkforcePlanForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registWorkforcePlan";
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/registWorkforce")
	public String registWorkforce(RedirectAttributes rttr, WorkforceVO workforce) throws Exception {
		workforceService.registWorkforce(workforce);
		// System.out.println(workforce);
		String url = "redirect:/projectManage/manage";
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/modifyWorkforceForm")
	public ModelAndView modifyWorkforceForm(ModelAndView mnv, int workforce_number) throws Exception {
		String url = "/projectManage/modifyWorkforce";
		mnv.addObject("workforce", workforceService.selectWorkforce(workforce_number));
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/modifyWorkforce")
	public String modifyWorkforce(RedirectAttributes rttr, WorkforceVO workforce) throws Exception {
		String url = "redirect:/projectManage/workforceDetail";
		workforceService.modifyWorkforce(workforce);
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("workforce_number", workforce.getWorkforce_number());
		return url;
	}

	@GetMapping("/workforceDetail")
	public ModelAndView workforceDetail(ModelAndView mnv, int workforce_number) throws Exception {
		mnv.addObject("workforce", workforceService.selectWorkforce(workforce_number));
		return mnv;
	}

	@GetMapping("/deleteWorkforce")
	public String deleteWorkforce(RedirectAttributes rttr, int workforce_number) throws Exception {
		String url = "redirect:/projectManage/manage";
		workforceService.removeWorkforce(workforce_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("workforce_number", workforce_number);

		return url;
	}

	@GetMapping("/registUnitworkForm")
	public ModelAndView registunitworkForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registUnitwork";
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/registUnitworkPlanForm")
	public ModelAndView registUnitworkPlanForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registUnitworkPlan";
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/registUnitwork")
	public String registUnitwork(RedirectAttributes rttr, UnitworkVO unitwork) throws Exception {
		unitworkService.registUnitwork(unitwork);
		// System.out.println(unitwork);
		String url = "redirect:/projectManage/manage";
		rttr.addFlashAttribute("from", "regist");
		return url;
	}

	@GetMapping("/modifyUnitworkForm")
	public ModelAndView modifyUnitworkForm(ModelAndView mnv, int unitwork_number) throws Exception {
		String url = "/projectManage/modifyUnitwork";
		mnv.addObject("unitwork", unitworkService.selectUnitwork(unitwork_number));
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/modifyUnitwork")
	public String modifyUnitwork(RedirectAttributes rttr, UnitworkVO unitwork) throws Exception {
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
	
	
	@GetMapping("/successUnitwork")
	public String successUnitwork(RedirectAttributes rttr, int unitwork_number) throws Exception {
		String url = "redirect:/projectManage/unitworkDetail";
		UnitworkVO unitwork = unitworkService.selectUnitwork(unitwork_number);
		unitwork.setUnitwork_level(5);
		unitworkService.modifyUnitwork(unitwork);
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("unitwork_number", unitwork_number);
		return url;
	}
	

	@GetMapping("/deleteUnitwork")
	public String deleteUnitwork(RedirectAttributes rttr, int unitwork_number) throws Exception {
		String url = "redirect:/projectManage/manage";
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
	
	@GetMapping("/registSchedulePlanForm")
	public ModelAndView registSchedulePlanForm(ModelAndView mnv) throws Exception {
		String url = "/projectManage/registSchedulePlan";
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/registSchedule")
	public String registSchedule(RedirectAttributes rttr, ScheduleVO schedule) throws Exception {
		scheduleService.registSchedule(schedule);
		// System.out.println(schedule);
		String url = "redirect:/projectManage/manage";
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/modifyScheduleForm")
	public ModelAndView modifyScheduleForm(ModelAndView mnv, int schedule_number) throws Exception {
		String url = "/projectManage/modifySchedule";
		mnv.addObject("schedule", scheduleService.selectSchedule(schedule_number));
		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping("/modifySchedule")
	public String modifySchedule(RedirectAttributes rttr, ScheduleVO schedule) throws Exception {
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
		String url = "redirect:/projectManage/manage";
		scheduleService.removeSchedule(schedule_number);
		rttr.addFlashAttribute("from", "delete");
		rttr.addAttribute("schedule_number", schedule_number);

		return url;
	}

	

	@PostMapping("/getProceeding")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getProceeding(SearchCriteria cri) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = projectService.selectProceedingProject(cri);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}
	
	@PostMapping("/getRequire")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getRequire(SearchCriteria cri) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = requireService.selectRequireList(cri);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}
	
	

	@PostMapping("/getEnd")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getEnd(SearchCriteria cri) throws Exception {

		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = projectService.selectEndProject(cri);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}

	
	
	
	@GetMapping("/getProjectDetail")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getProjectDetail(int project_number) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = new HashMap<String,Object>();
		try {
			dataMap.put("project", projectService.selectProject(project_number));
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}
	
	
	
	@GetMapping("/getBusinessDetail")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getBusinessDetail(int business_number) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = new HashMap<String,Object>();
		try {
			dataMap.put("business", businessService.getBusiness(business_number));
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

		return entity;
	}
	
	@GetMapping("/getPlan")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getPlan(int business_number) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = projectService.selectProjectManageListByBusiness_number(business_number);
			status = HttpStatus.OK;
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String, Object>>(dataMap, status);
		return entity;
	}
	
	
	@GetMapping("/getManage")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getManage(int project_number) throws Exception{
		ResponseEntity <Map<String,Object>> responseEntity = null;
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number);
		HttpStatus status = null;
		Map<String,Object> dataMap = null;
		try {
			dataMap = projectService.selectProjectManageListByProjectNumber(1);
			status = HttpStatus.OK;
		}catch(Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		responseEntity = new ResponseEntity<Map<String,Object>>(dataMap,status);
		return responseEntity;
	}
	
	@PostMapping("/scheduleList")
	@ResponseBody
	public ModelAndView scheduleList(ModelAndView mnv, SearchCriteria cri) throws Exception{
		Map<String,Object> dataMap = null;
		//SearchCriteria cri = new SearchCriteria();
		//cri.setProject_number(project_number);
		dataMap = scheduleService.selectScheduleList(cri);
		mnv.addObject("project_num", cri.getProject_number());
		mnv.addAllObjects(dataMap);
		mnv.setViewName("projectManage/scheduleList");
		return mnv;
	}
	
	@PostMapping("/unitworkList")
	@ResponseBody
	public ModelAndView unitworkList(ModelAndView mnv, SearchCriteria cri) throws Exception{
		Map<String,Object> dataMap = null;
		//SearchCriteria cri = new SearchCriteria();
		//cri.setProject_number(project_number);
		dataMap = unitworkService.selectUnitworkList(cri);
		if(cri.getProject_number()!=0)
		mnv.addObject("project_num", cri.getProject_number());
		mnv.addAllObjects(dataMap);
		mnv.setViewName("projectManage/unitworkList");
		return mnv;
	}
	
	@PostMapping("/workforceList")
	@ResponseBody
	public ModelAndView workforceList(ModelAndView mnv, SearchCriteria cri) throws Exception{
		Map<String,Object> dataMap = null;
		//SearchCriteria cri = new SearchCriteria();
		//cri.setProject_number(project_number);
		dataMap = workforceService.selectWorkforceList(cri);
		mnv.addObject("project_num", cri.getProject_number());
		mnv.addAllObjects(dataMap);
		mnv.setViewName("projectManage/workforceList");
		return mnv;
	}
	
	@PostMapping("/budgetList")
	@ResponseBody
	public ModelAndView budgetList(ModelAndView mnv, SearchCriteria cri) throws Exception{
		Map<String,Object> dataMap = null;
		dataMap = budgetService.selectBudgetList(cri);
		mnv.addAllObjects(dataMap);
		mnv.addObject("project_num", cri.getProject_number());
		mnv.setViewName("projectManage/budgetList");
		return mnv;
	}
	
	
	
	@GetMapping("/getUnitworkDetail")
	@ResponseBody
	public UnitworkVO getUnitworkDetail(Model model, int unitwork_number) throws Exception {
		UnitworkVO unitwork = unitworkService.selectUnitwork(unitwork_number);
		return unitwork;
	}
	
	@GetMapping("/getWorkforceDetail")
	@ResponseBody
	public WorkforceVO getWorkforceDetail(Model model, int workforce_number) throws Exception {
		WorkforceVO workforce = workforceService.selectWorkforce(workforce_number);
		return workforce;
	}
	
	@GetMapping("/getScheduleDetail")
	@ResponseBody
	public ScheduleVO getScheduleDetail(Model model, int schedule_number) throws Exception {
		ScheduleVO schedule = scheduleService.selectSchedule(schedule_number);
		return schedule;
	}
	
	@GetMapping("/getBudgetDetail")
	@ResponseBody
	public BudgetVO getBudgetDetail(Model model, int budget_number) throws Exception {
		BudgetVO budget = budgetService.selectBudget(budget_number);
		return budget;
	}
	
	
}
