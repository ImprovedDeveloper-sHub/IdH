package com.sbs.IdH.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.UnitworkService;

@RequestMapping("/project")
@Controller
public class ProjectController {

	@Resource
	private UnitworkService unitworkService;
	@Resource
	private ProjectService projectService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setUnitworkService(UnitworkService unitworkService) {
		this.unitworkService = unitworkService;
	}

	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri, HttpServletRequest request) throws Exception {

		
		mnv.addAllObjects(unitworkService.selectUnitworkList(cri));

		return mnv;

	}

	@GetMapping("/progress")
	public ModelAndView progress(ModelAndView mnv, SearchCriteria cri) throws Exception {

		mnv.addAllObjects(unitworkService.selectUnitworkList(cri));
		mnv.addAllObjects(projectService.selectProjectUnitwork_level(cri));

		return mnv;
	}
}
