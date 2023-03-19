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

import com.sbs.IdH.command.IssueModifyCommand;
import com.sbs.IdH.command.IssueRegistCommand;
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
	public ModelAndView main(SearchCriteria cri, ModelAndView mnv,HttpServletRequest request) throws Exception {
		mnv.addAllObjects(issueService.selectGetterIssueList(cri, request));
		mnv.addAllObjects(issueService.selectMyIssueList(cri, request));
		mnv.addAllObjects(issueService.selectIssueCheckList(cri));
		return mnv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int issue_number, String from, 
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
	
	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	private List<Issue_AttachVO> saveFileToIssue_Attaches(List<MultipartFile> multiFiles, String savePath) throws Exception {
		List<Issue_AttachVO> attachList = new ArrayList<Issue_AttachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Issue_AttachVO attach = new Issue_AttachVO();
				attach.setUploadPath(savePath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}
	
	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(IssueRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/issue/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.fileUploadPath;

		List<Issue_AttachVO> attachList = saveFileToIssue_Attaches(multiFiles, savePath);

		// DB
		IssueVO issue = registReq.toIssueVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		String XSScontent = (String) request.getAttribute("XSScontent");
		if (XSStitle != null) {
			issue.setIssue_title(XSStitle);
			issue.setIssue_content(XSScontent);
		}

		issue.setAttachList(attachList);
		issueService.registIssue(issue);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}
	
	@GetMapping("/remove")
	public String remove(int issue_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/issue/main";

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
			dataMap = issueService.selectMyIssueList(cri, request);
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
	
	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int issue_number) throws Exception {
		String url = "/issue/modify";
		
		mnv = detail(issue_number,"modify",mnv);
		
		mnv.setViewName(url);
		return mnv;
	}
 @PostMapping(value="/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(IssueModifyCommand modifyReq,HttpServletRequest request,RedirectAttributes rttr) throws Exception {
		String url = "redirect:/issue/detail";
		
		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {				
				Issue_AttachVO attach = issueService.selectIssue_AttachByAno(ano);
				
				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());
				
				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				issueService.removeIssue_AttachByAno(ano); // DB 삭제
				
			}
		}
	
		//파일저장
		List<Issue_AttachVO> attachList
			= saveFileToIssue_Attaches(modifyReq.getUploadFile(), fileUploadPath);
		
		
		IssueVO issue = modifyReq.toIssueVO();	
		String XSStitle = (String)request.getAttribute("XSStitle");
		String XSScontent = (String)request.getAttribute("XSScontent");
		if(XSStitle !=null) {
			issue.setIssue_title(XSStitle);
			issue.setAttachList(attachList);
			issue.setIssue_content(XSScontent);
		}
		
		// DB 저장
		issueService.modifyIssue(issue);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("issue_number", issue.getIssue_number());
		
		return url;
	}
 
 
 @PostMapping("/getMy")
 @ResponseBody
 public ResponseEntity<Map<String, Object>> getMy(SearchCriteria cri, HttpServletRequest request) throws Exception {

    ResponseEntity<Map<String, Object>> entity = null;
    HttpStatus status;
    Map<String, Object> dataMap = null;
    try {
       dataMap = issueService.selectMyIssueList(cri,request);
       status = HttpStatus.OK;
    } catch (Exception e) {
       status = HttpStatus.BAD_REQUEST;
    }
    entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

    return entity;
 }
 @PostMapping("/getGetter")
 @ResponseBody
 public ResponseEntity<Map<String, Object>> getGetter(SearchCriteria cri, HttpServletRequest request) throws Exception {

    ResponseEntity<Map<String, Object>> entity = null;
    HttpStatus status;
    Map<String, Object> dataMap = null;
    try {
       dataMap = issueService.selectGetterIssueList(cri,request);
       status = HttpStatus.OK;
    } catch (Exception e) {
       status = HttpStatus.BAD_REQUEST;
    }
    entity = new ResponseEntity<Map<String, Object>>(dataMap, status);

    return entity;
 }
	
}
