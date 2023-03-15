package com.sbs.IdH.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbs.IdH.service.RequireService;

@RequestMapping("/project")
@Controller
public class ProjectController {

	@Resource
	private RequireService requireService;
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/progress")
	public void test() {}
	
}
