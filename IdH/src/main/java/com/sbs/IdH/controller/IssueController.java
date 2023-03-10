package com.sbs.IdH.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.Issue_AttachVO;
import com.sbs.IdH.service.IssueService;
import com.sbs.IdH.utils.MakeFileName;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Resource(name="issueService")
	private IssueService issueService;
	
	@GetMapping("/test")
	public void test()throws Exception {}
	
	@GetMapping("/main")
	public ModelAndView issue(SearchCriteria cri, ModelAndView mnv) throws Exception {
		mnv.addAllObjects(issueService.selectIssueList(cri));
		mnv.addAllObjects(issueService.selectIssueCheckList(cri));
		return mnv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int issue_number, String from, 
								RedirectAttributes rttr,
							    ModelAndView mnv) throws Exception {
		String url = "/issue/detail";

		IssueVO issue = null;
		
		
		issue = issueService.selectIssue(issue_number);
		
		
		// 파일명 재정의
		if (issue != null) {
			List<Issue_AttachVO> attachList = issue.getAttachList();
			if (attachList != null) {
				for (Issue_AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}
		
		mnv.addObject("issue", issue);
		mnv.setViewName(url);

		return mnv;
	}

	@GetMapping("/registForm")
	public String registForm() throws Exception {
		String url="issue/regist";		
		return url;
	}
	
//	@Resource(name = "fileUploadPath")
//	private String fileUploadPath;
//	
//	private List<Issue_AttachVO> saveFileToAttaches(List<MultipartFile> multiFiles,String savePath )throws Exception{
//		List<Issue_AttachVO> attachList = new ArrayList<Issue_AttachVO>();
//		
//		if (multiFiles != null) {
//			for (MultipartFile multi : multiFiles) {
//				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
//				File target = new File(savePath, fileName);
//				target.mkdirs();
//				multi.transferTo(target);
//
//				Issue_AttachVO attach = new Issue_AttachVO();
//				attach.setUploadPath(savePath);
//				attach.setFileName(fileName);
//				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1)
//						.toUpperCase());
//				
//				attachList.add(attach);
//			}
//		}
//		return attachList;
//	}
	
	@PostMapping("/regist")
	public String regist(HttpServletRequest request,RedirectAttributes rttr,IssueVO issue) throws Exception{
		String url="redirect:/issue/main";	
		
		String XSStitle = (String)request.getAttribute("XSStitle");
		if(XSStitle !=null) issue.setIssue_title(XSStitle);
		
		
		
		issueService.registIssue(issue);
		
		rttr.addFlashAttribute("from","regist");
		
		return url;
	}
	
	@GetMapping("/remove")
	public String remove(int issue_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/issue/detail";

		// 첨부파일 삭제
		List<Issue_AttachVO> attachList = issueService.selectIssue(issue_number).getAttachList();
		if (attachList != null) {
			for (Issue_AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		issueService.removeIssue(issue_number);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("issue_number", issue_number);
		
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
