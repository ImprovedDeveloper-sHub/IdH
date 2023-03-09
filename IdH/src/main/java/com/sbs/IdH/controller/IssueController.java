package com.sbs.IdH.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.service.IssueService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Resource(name="issueService")
	private IssueService issueService;
	
	@GetMapping("/main")
	public ModelAndView issue(SearchCriteria cri, ModelAndView mnv) throws Exception {
		mnv.addAllObjects(issueService.selectIssueList(cri));
		return mnv;
	}
	
	@GetMapping("/detail")
	public void detail()throws Exception{}

	@GetMapping("/registForm")
	public String registForm() throws Exception {
		String url="issue/regist";		
		return url;
	}
	
	@GetMapping("/regist")
	public String regist(HttpServletRequest request,RedirectAttributes rttr,IssueVO issue) throws Exception{
		String url="redirect:/board/list.do";	
		
		String XSStitle = (String)request.getAttribute("XSStitle");
		if(XSStitle !=null) issue.setIssue_title(XSStitle);
		
		issueService.registIssue(issue);
		
		rttr.addFlashAttribute("from","regist");
		
		return url;
	}
	
	@PostMapping("/remove")
	public String remove(int issue_number,RedirectAttributes rttr)throws Exception{
		String url = "redirect:/board/detail";
		issueService.removeIssue(issue_number);		
		
		rttr.addAttribute("issue_number",issue_number);
		rttr.addFlashAttribute("from","remove");
		return url;	
	}
	
	@PostMapping("/getMyIssueList")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getMyIssueList(SearchCriteria cri,HttpServletRequest request) throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = issueService.selectMyIssueList(cri,request);
			status = HttpStatus.OK;
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String,Object>>(dataMap, status);
		
		return entity;
	}
	
	@PostMapping("/getGetterIssueList")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getGetterIssueList(SearchCriteria cri,HttpServletRequest request) throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		HttpStatus status;
		Map<String, Object> dataMap = null;
		try {
			dataMap = issueService.selectGetterIssueList(cri, request);
			status = HttpStatus.OK;
		}catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		entity = new ResponseEntity<Map<String,Object>>(dataMap, status);
		
		return entity;
	}
	
}
