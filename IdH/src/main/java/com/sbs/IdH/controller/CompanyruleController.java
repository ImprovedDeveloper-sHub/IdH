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

import com.sbs.IdH.command.CompanyruleRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Co_AttachVO;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.service.CompanyruleService;
import com.sbs.IdH.utils.MakeFileName;


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
	
	

	  
	  @RequestMapping("/registForm") public String registForm() throws Exception {
		 
				String url = "companyrule/regist";
				return url;
			}
	  @Resource(name = "fileUploadPath")
		private String fileUploadPath;
		
		private List<Co_AttachVO> saveFileToAttaches(List<MultipartFile> multiFiles,
												  String savePath )throws Exception{
			List<Co_AttachVO> attachList = new ArrayList<Co_AttachVO>();
			//저장 -> attachVO -> list.add
			if (multiFiles != null) {
				for (MultipartFile multi : multiFiles) {
					String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
					File target = new File(savePath, fileName);
					target.mkdirs();
					multi.transferTo(target);

					Co_AttachVO attach = new Co_AttachVO();
					attach.setUploadPath(savePath);
					attach.setFileName(fileName);
					attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1)
							.toUpperCase());
					
					attachList.add(attach);
				}
			}
			return attachList;
		}
	  @PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
		public String regist(CompanyruleRegistCommand registReq, HttpServletRequest request,RedirectAttributes rttr) 
																		throws Exception {
			String url = "redirect:/companyrule/main.do";		
					
			
			  List<MultipartFile> multiFiles = registReq.getUploadFile(); String savePath =
			  this.fileUploadPath;
			  
			  List<Co_AttachVO> attachList = saveFileToAttaches(multiFiles,savePath);
			 
			//DB 
			CompanyruleVO companyrule = registReq.toCompanyruleVO();
			String XSStitle = (String)request.getAttribute("XSStitle");
			if(XSStitle !=null) companyrule.setCompanyrule_title(XSStitle);
			
			companyrule.setCo_AttachList(attachList);
			companyruleService.registCompanyrule(companyrule);
			
			//output
			rttr.addFlashAttribute("from", "regist");
			
			
			return url;
		}
	  
	@GetMapping("/detail")
	public void detail() throws Exception {}
}
