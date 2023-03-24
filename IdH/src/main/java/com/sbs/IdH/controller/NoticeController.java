package com.sbs.IdH.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.NoticeModifyCommand;
import com.sbs.IdH.command.NoticeRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.NoticeVO;
import com.sbs.IdH.dto.Notice_attachVO;
import com.sbs.IdH.service.NoticeService;
import com.sbs.IdH.utils.MakeFileName;

@RequestMapping("notice")
@Controller
public class NoticeController {

	@Resource
	private NoticeService noticeService;

	@GetMapping("/main")
	public ModelAndView notice(SearchCriteria cri, ModelAndView mnv) throws SQLException {

		mnv.addObject("dataMap", noticeService.getNoticeList(cri));
		mnv.addAllObjects(noticeService.getNoticeList(cri));

		return mnv;
		
	}

	@GetMapping("/detail")
	public ModelAndView detail(int notice_number, String from, ModelAndView mnv) throws Exception {
		
		String url = "/notice/detail";

		
		NoticeVO notice = noticeService.getNotice(notice_number);
		
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

	@RequestMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv, HttpServletRequest request) throws SQLException {

		String url = "notice/regist";
		
		SearchCriteria cri = new SearchCriteria();

		MemberVO member = (MemberVO) request.getSession().getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());
		
		mnv.addAllObjects(noticeService.getNoticeList(cri));
		mnv.setViewName(url);
		
		return mnv;
	}

	@Resource(name = "UploadPath")
	private String UploadNoticePath;

	private List<Notice_attachVO> saveFileToattaches(List<MultipartFile> multiFiles, String savePath)
			throws SQLException, IllegalStateException, IOException {
		List<Notice_attachVO> attachList = new ArrayList<Notice_attachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Notice_attachVO attach = new Notice_attachVO();
				attach.setUploadpath(savePath);
				attach.setFilename(fileName);
				attach.setFiletype(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(NoticeRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws SQLException, IllegalStateException, IOException {
		String url = "redirect:/notice/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.UploadNoticePath;

		List<Notice_attachVO> attachList = saveFileToattaches(multiFiles, savePath);

		// DB
		NoticeVO notice = registReq.toNoticeVO();
		String XSStitle = (String) request.getAttribute("XSStitle");																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														
		if (XSStitle != null)
			notice.setNotice_title(XSStitle);

		notice.setNotice_attachList(attachList);
		noticeService.regist(notice);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}
	
	@GetMapping("/remove")
	public String remove(int notice_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/notice/main";

		// 첨부파일 삭제
		List<Notice_attachVO> attachList = noticeService.getNotice(notice_number).getNotice_attachList();
		if (attachList != null) {
			for (Notice_attachVO attach : attachList) {
				File target = new File(attach.getUploadpath(), attach.getFilename());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		noticeService.remove(notice_number);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("notice_number", notice_number);

		return url;
	}
		
	
	
	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(int notice_number, ModelAndView mnv) throws Exception{
		
		String url="/notice/modify";
		
		mnv = detail(notice_number, "modify", mnv);
		
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(NoticeModifyCommand modifyReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/notice/detail";

		
		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {
				Notice_attachVO attach = noticeService.getNotice_attachByAno(ano);

				File deleteFile = new File(attach.getUploadpath(), attach.getFilename());

				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				noticeService.removeNotice_attach_Ano(ano); // DB 삭제

			}
		}

		// 파일저장
		List<Notice_attachVO> attachList = saveFileToattaches(modifyReq.getUploadFile(), UploadNoticePath);

		NoticeVO notice = modifyReq.toNoticeVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			notice.setNotice_title(XSStitle);
		notice.setNotice_attachList(attachList);

		// DB 저장
		noticeService.modify(notice);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("require_number", notice.getNotice_number());

		return url;
	}

	@GetMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {

		String url = "downloadFile"; // bean name

		Notice_attachVO attach = noticeService.getNotice_attachByAno(ano);

		model.addAttribute("savedPath", attach.getUploadpath());
		model.addAttribute("fileName", attach.getFilename());

		return url;
	}
	
	
}
