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

import com.sbs.IdH.command.NoticeRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.NoticeVO;
import com.sbs.IdH.dto.Notice_attachVO;
import com.sbs.IdH.service.NoticeService;
import com.sbs.IdH.utils.MakeFileName;


@RequestMapping("/notice")
@Controller
public class NoticeController {
	
	@Resource
	private NoticeService noticeService;
	
	@GetMapping("/main")
	public ModelAndView notice(SearchCriteria cri, ModelAndView mnv)throws Exception{
			
             mnv.addAllObjects(noticeService.getNoticeList(cri));
             
             return mnv;
	}
	
	  
	  @RequestMapping("/registForm") public String registForm() throws Exception {
		 
				String url = "notice/regist";
				return url;
			}
	  @Resource(name = "fileUploadNoticePath")
		private String fileUploadNoticePath;
		
		private List<Notice_attachVO> saveFileToattaches(List<MultipartFile> multiFiles,
												  String savePath )throws Exception{
			List<Notice_attachVO> attachList = new ArrayList<Notice_attachVO>();
			//저장 -> attachVO -> list.add
			if (multiFiles != null) {
				for (MultipartFile multi : multiFiles) {
					String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
					File target = new File(savePath, fileName);
					target.mkdirs();
					multi.transferTo(target);

					Notice_attachVO attach = new Notice_attachVO();
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
		public String regist(NoticeRegistCommand registReq, HttpServletRequest request,RedirectAttributes rttr) 
																		throws Exception {
			String url = "redirect:/notice/main";		
					
			
			  List<MultipartFile> multiFiles = registReq.getUploadFile(); String savePath =
			  this.fileUploadNoticePath;
			  
			  List<Notice_attachVO> attachList = saveFileToattaches(multiFiles,savePath);
			 
			//DB 
			NoticeVO notice = registReq.toNoticeVO();
			String XSStitle = (String)request.getAttribute("XSStitle");
			if(XSStitle !=null) notice.setNotice_title(XSStitle);
			
			notice.setNotice_attachList(attachList);
			noticeService.regist(notice);
			
			//output
			rttr.addFlashAttribute("from", "regist");
			
			
			return url;
		}
	  
		@GetMapping("/detail")
		public ModelAndView detail(int notice_number, String from, 
									RedirectAttributes rttr,
								    ModelAndView mnv) throws Exception {
			String url = "/notice/detail";

			NoticeVO notice = null;
			
			
			notice = noticeService.getNotice(notice_number);
			
			
			// 파일명 재정의
			if (notice != null) {
				List<Notice_attachVO> attachList = notice.getNotice_attachList();
				if (attachList != null) {
					for (Notice_attachVO attach : attachList) {
						String fileName = attach.getFilename().split("\\$\\$")[1];
						attach.setFilename(fileName);
					}
				}
			}
			
			mnv.addObject("notice", notice);
			mnv.setViewName(url);

			return mnv;
		}
}
