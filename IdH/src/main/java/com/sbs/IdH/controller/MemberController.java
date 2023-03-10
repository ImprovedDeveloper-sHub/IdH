package com.sbs.IdH.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.RequireService;

@RequestMapping("/member")
@Controller
public class MemberController {

	@Resource
	private RequireService requireService;
	
	@GetMapping("/loginform")
	public ModelAndView test2(ModelAndView mnv, SearchCriteria cri) throws Exception{
		
		mnv.addAllObjects(requireService.selectRequireList(cri));
		
		return mnv;
	}
 }
