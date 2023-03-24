package com.sbs.IdH.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.BusinessService;
import com.sbs.IdH.service.IssueService;
import com.sbs.IdH.service.MemberService;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.ScheduleService;
import com.sbs.IdH.service.UnitworkService;
import com.sbs.IdH.service.WorkreportService;

@Controller
@RequestMapping("/dashBoard")
public class DashBoardController {

	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "businessService")
	private BusinessService businessService;
	
	//@Resource(name = "scheduleService")
	//private ScheduleService scheduleService;
	
	@Resource(name = "projectService")
	private ProjectService projectService;
	
	@Resource(name = "issueService")
	private IssueService issueService;
	
	//@Resource(name = "cowork")
	//private CoworkService coworkService;
	
	@Resource(name = "unitworkService")
	private UnitworkService unitworkService;
	
	@Resource(name = "scheduleService")
	private ScheduleService scheduleService;
	
	@Resource(name = "workreportService")
	private WorkreportService workreportService;
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/executives")
	public ModelAndView executives(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request, @RequestParam(defaultValue="1")int business_number, @RequestParam(defaultValue="1")int project_number) throws Exception {
		
		//맴버정보
		//HttpSession session = request.getSession();
		//MemberVO member = (MemberVO)session.getAttribute("loginUser");
		//mnv.addObject("member", (memberService.selectMember(member.getMember_id())));
		//사업예산
		mnv.addAllObjects(businessService.getBusinessList(cri));
		if(business_number != 0)mnv.addObject("business", businessService.getBusiness(business_number));
		//업무보고
		
		//프로젝트 진행도
		mnv.addAllObjects(projectService.selectProjectList(cri));
		if(project_number != 0)mnv.addObject("project", projectService.selectProject(project_number));
		
		return mnv;
	}
	
	@GetMapping("/teamLeader")
	public ModelAndView teamLeader(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request) throws Exception {
		
		//프로젝트 진행현황
		mnv.addAllObjects(unitworkService.selectUnitworkList(cri));
		mnv.addAllObjects(projectService.selectProjectUnitwork_level(cri));
		mnv.addAllObjects(scheduleService.selectScheduleList(cri));
		//이슈
		mnv.addAllObjects(issueService.selectIssueCheckList(cri));
		//세부계획
		
		
		return mnv;
	}
	
	@GetMapping("/teamMember")
	public ModelAndView teamMember(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request) throws Exception {

		//납기일
		
		//내이슈
		mnv.addAllObjects(issueService.selectMyIssueList(cri, request));
		//내작업
		
		
		return mnv;
	}
	
	@GetMapping("/getBusinessCalendar")
	@ResponseBody
	public List<Map<String, Object>> getBusinessCalendar() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		
		return businessService.selectBusinessListForCalendar(cri);
	}
	
	@GetMapping("/getProjectCalendar")
	@ResponseBody
	public List<Map<String, Object>> getProjectCalendar() throws Exception{
		SearchCriteria cri = new SearchCriteria();
		return projectService.selectProjectListForCalendar(cri);
	}
	
	@GetMapping("/getBusiness")
	public ModelAndView getBusiness(ModelAndView mnv, int business_number) throws Exception{
		if(business_number != 0)mnv.addObject("business", businessService.getBusiness(business_number));
		mnv.setViewName("/dashBoard/businessBudget");
		
		return mnv;
	}
	
	@GetMapping("/getProject")
	public ModelAndView getProject(ModelAndView mnv, int project_number) throws Exception{
		if(project_number != 0)mnv.addObject("project", projectService.selectProject(project_number));
		mnv.setViewName("/dashBoard/projectRun");
		
		return mnv;
	}
	
	@PostMapping("/getMyworkreportlist")
	 public ModelAndView getMyworkreportlist(ModelAndView mnv,SearchCriteria cri,HttpServletRequest request)throws Exception{
		 mnv.addAllObjects(workreportService.selectMyWorkreportList(cri, request));
		 mnv.setViewName("/dashBoard/getMyworkreportlist");
		 
		 
		 return mnv;
	 }
	
}
