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

@RequestMapping("/require")
@Controller
public class RequireController {

	@Resource
	private RequireService requireService;
	
	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri) throws Exception{
		
		mnv.addAllObjects(requireService.selectRequireList(cri));
		
		return mnv;
	}
	@RequestMapping("/registForm")
	public String registForm() throws Exception {
		String url = "require/regist";
		return url;
	}
	
	@Resource(name = "fileUploadPath")
	private String fileUploadPath;
	
	private List<Require_attachVO> saveFileToAttaches(List<MultipartFile> multiFiles,
											  String savePath )throws Exception{
		List<Require_attachVO> attachList = new ArrayList<Require_attachVO>();
		//저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Require_attachVO attach = new Require_attachVO();
				attach.setUploadpath(savePath);
				attach.setFilename(fileName);
				attach.setFiletype(fileName.substring(fileName.lastIndexOf('.') + 1)
						.toUpperCase());
				
				attachList.add(attach);
			}
		}
		return attachList;
	}
	
	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(RequireRegistCommand registReq, HttpServletRequest request,RedirectAttributes rttr) 
																	throws Exception {
		String url = "redirect:/require/main";		
				
		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.fileUploadPath;		
		
		List<Require_attachVO> attachList = saveFileToAttaches(multiFiles,savePath);
		
		//DB 
		RequireVO require = registReq.toRequireVO();
		String XSStitle = (String)request.getAttribute("XSStitle");
		if(XSStitle !=null) require.setRequire_title(XSStitle);
		
		require.setAttachList(attachList);
		requireService.registRequire(require);
		
		//output
		rttr.addFlashAttribute("from", "regist");
		
		
		return url;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int require_number, String from, 
							    ModelAndView mnv) throws Exception {
		String url = "/require/detail";

		RequireVO require = requireService.selectRequire(require_number);
		
//		// 파일명 재정의
//		if (require != null) {
//			List<Require_attachVO> attachList = require.getAttachList();
//			if (attachList != null) {
//				for (Require_attachVO attach : attachList) {
//					String fileName = attach.getFilename().split("\\$\\$")[1];
//					attach.setFilename(fileName);
//				}
//			}
//		}
		
		mnv.addObject("require", require);
		mnv.setViewName(url);

		return mnv;
	}
//	
//	@GetMapping("/modifyForm")
//	public ModelAndView modifyForm(ModelAndView mnv, int require_number,RedirectAttributes rttr) throws Exception {
//		String url = "/require/modify";
//		
//		mnv = detail(require_number,"modify",rttr,mnv);
//		
//		mnv.setViewName(url);
//		return mnv;
//	}
//	
//	@PostMapping(value="/modify", produces = "text/plain;charset=utf-8")
//	public String modifyPOST(PdsModifyCommand modifyReq,HttpServletRequest request,RedirectAttributes rttr) throws Exception {
//		String url = "redirect:/pds/detail.do";
//		
//		// 파일 삭제
//		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
//			for (int ano : modifyReq.getDeleteFile()) {				
//				AttachVO attach = service.getAttachByAno(ano);
//				
//				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());
//				
//				if (deleteFile.exists()) {
//					deleteFile.delete(); // File 삭제
//				}
//				service.removeAttachByAno(ano); // DB 삭제
//				
//			}
//		}
		
//		//파일저장
//		List<Require_attachVO> attachList 
//			= saveFileToAttaches(modifyReq.getUploadFile(), fileUploadPath);
//		
//		// RequireVO settting
//		RequireVO require = modifyReq.toPdsVO();	
//		String XSStitle = (String)request.getAttribute("XSStitle");
//		if(XSStitle !=null) req.setTitle(XSStitle);
//		pds.setAttachList(attachList);
//		
//		// DB 저장
//		service.modify(pds);
//
//		rttr.addFlashAttribute("from", "modify");
//		rttr.addAttribute("pno", pds.getPno());
//		
//		return url;
//	}
	
//	@GetMapping("/remove")
//	public String remove(int require_number, RedirectAttributes rttr) throws Exception {
//		String url = "redirect:/pds/detail.do";
//
//		// 첨부파일 삭제
//		List<Require_attachVO> attachList = requireService.selectRequire(require_number).getAttachList();
//		if (attachList != null) {
//			for (Require_attachVO attach : attachList) {
//				File target = new File(attach.getUploadpath(), attach.getFilename());
//				if (target.exists()) {
//					target.delete();
//				}
//			}
//		}
//		// DB삭제
//		requireService.removeRequire(require_number);
//		
//		rttr.addFlashAttribute("from", "remove");
//		rttr.addAttribute("require_number", require_number);
//		
//		return url;
//	}
//	
//	@GetMapping("/getFile")
//	public String getFile(int ano,Model model) throws Exception {
//		
//		String url="downloadFile"; //bean name
//		
//		Require_attachVO attach = requireService.getRequire_attachByAno(ano);
//		
//
//		model.addAttribute("savedPath", attach.getUploadpath());
//		model.addAttribute("fileName", attach.getFilename());		
//	
//		return url;
//	}
}
