package com.sbs.IdH.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.UnitworkService;
import com.sbs.IdH.service.WorkforceService;

@RequestMapping("/project")
@Controller
public class ProjectController {

	@Resource
	private UnitworkService unitworkService;
	@Resource
	private ProjectService projectService;
	@Resource
	private WorkforceService workforceService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setUnitworkService(UnitworkService unitworkService) {
		this.unitworkService = unitworkService;
	}

	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri, HttpServletRequest request) throws Exception {

		//mnv.addAllObjects(unitworkService.selectUnitworkList(cri));
		MemberVO member =(MemberVO)request.getSession().getAttribute("loginUser");
		cri.setMember_id((member.getMember_id()));
		
		
		System.out.println((member.getMember_id()));
		
		Map<String,Object> dataMap = projectService.selectListByGetterId(member.getMember_id());
		
		
		
		mnv.addAllObjects(projectService.selectProceedingProject(cri));
		mnv.addAllObjects(dataMap);
		
		return mnv;

	}

	@GetMapping("/selectProject")
	public String selectProject(RedirectAttributes rttr, HttpServletRequest request, int project_number)throws Exception{
		String url="redirect:progress";
		
		HttpSession session = request.getSession();
		session.setAttribute("project_now_number", project_number);
		
		return url;
	}
	
	@GetMapping("/progress")
	public ModelAndView progress(ModelAndView mnv, SearchCriteria cri, HttpServletRequest request) throws Exception {
		
		int project_number = (int)request.getSession().getAttribute("project_now_number");
		cri.setProject_number(project_number);
		
		
		mnv.addAllObjects(unitworkService.selectUnitworkList(cri));
		mnv.addAllObjects(projectService.selectProjectUnitwork_level(cri));
		
		return mnv;
	}
	

	
	
}
