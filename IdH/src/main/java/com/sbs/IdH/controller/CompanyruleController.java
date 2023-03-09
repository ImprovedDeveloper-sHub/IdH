	package com.sbs.IdH.controller;

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

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.service.CompanyruleService;


@RequestMapping("/companyrule")
@Controller
public class CompanyruleController {
	
	@Resource
	private CompanyruleService companyruleService;
	
	@GetMapping("/main")
	public ModelAndView companyrule(SearchCriteria cri, ModelAndView mnv)throws Exception{
			
             mnv.addAllObjects(companyruleService.selectCompanyruleList(cri));
             
             return mnv;
	}
	/*
	 * public void regist() throws Exception {}
	 * 
	 * @PostMapping(value = "/regist", produces = "text/plain;charset=utf-8") public
	 * String regist(CompanyruleRegistCommand registReq, HttpServletRequest
	 * request,RedirectAttributes rttr) throws Exception { String url =
	 * "redirect:/companyrule/detail";
	 * 
	 * List<MultipartFile> multiFiles = registReq.getUploadFile(); String savePath =
	 * this.fileUploadPath;
	 * 
	 * List<AttachVO> attachList = saveFileToAttaches(multiFiles,savePath);
	 * 
	 * //DB PdsVO pds = registReq.toPdsVO(); String XSStitle =
	 * (String)request.getAttribute("XSStitle"); if(XSStitle !=null)
	 * pds.setTitle(XSStitle);
	 * 
	 * pds.setAttachList(attachList); service.regist(pds);
	 * 
	 * //output rttr.addFlashAttribute("from", "regist");
	 * 
	 * 
	 * return url; }
	 * 
	 * @RequestMapping("/registForm") public String registForm() throws Exception {
	 * String url = "pds/regist"; return url; }
	 */
	@GetMapping("/detail")
	public void detail() throws Exception {}
}
