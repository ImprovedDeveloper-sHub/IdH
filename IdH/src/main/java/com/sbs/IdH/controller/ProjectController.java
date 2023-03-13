package com.sbs.IdH.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.RequireRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.RequireVO;
import com.sbs.IdH.dto.Require_attachVO;
import com.sbs.IdH.service.RequireService;
import com.sbs.IdH.utils.MakeFileName;

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
