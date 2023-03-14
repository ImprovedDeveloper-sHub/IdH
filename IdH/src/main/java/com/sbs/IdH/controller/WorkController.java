package com.sbs.IdH.controller;

import java.io.File;
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

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.command.WorkModifyCommand;
import com.sbs.IdH.command.WorkRegistCommand;
import com.sbs.IdH.dto.WorkVO;
import com.sbs.IdH.dto.Work_AttachVO;
import com.sbs.IdH.service.WorkService;
import com.sbs.IdH.utils.MakeFileName;

@Controller
@RequestMapping("/work")
public class WorkController {

	@Resource(name = "workService")
	private WorkService workService;

	@GetMapping("/main")
	public ModelAndView main(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request) throws Exception {
		mnv.addAllObjects(workService.selectGetterWorkList(cri, request));
		mnv.addAllObjects(workService.selectMyWorkList(cri, request));
		return mnv;
	}

	@GetMapping("/registForm")
	public String registForm() throws Exception {

		String url = "work/regist";
		return url;
	}

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;

	private List<Work_AttachVO> saveFileToWork_Attaches(List<MultipartFile> multiFiles, String savePath) throws Exception {
		List<Work_AttachVO> attachList = new ArrayList<Work_AttachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Work_AttachVO attach = new Work_AttachVO();
				attach.setUploadPath(savePath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(WorkRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/work/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.fileUploadPath;

		List<Work_AttachVO> attachList = saveFileToWork_Attaches(multiFiles, savePath);

		// DB
		WorkVO work = registReq.toWorkVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			work.setWork_title(XSStitle);

		work.setAttachList(attachList);
		workService.registWork(work);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int work_number, String from, RedirectAttributes rttr, ModelAndView mnv)
			throws Exception {
		String url = "/work/detail";

		WorkVO work = null;

		work = workService.selectWork(work_number);

		// 파일명 재정의
		if (work != null) {
			List<Work_AttachVO> attachList = work.getAttachList();
			if (attachList != null) {
				for (Work_AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("work", work);
		mnv.setViewName(url);

		return mnv;
	}

	@GetMapping("/remove")
	public String remove(int work_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/work/main";

		// 첨부파일 삭제
		List<Work_AttachVO> attachList = workService.selectWork(work_number).getAttachList();
		if (attachList != null) {
			for (Work_AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		workService.removeWork(work_number);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("work_number", work_number);

		return url;
	}

	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int work_number, RedirectAttributes rttr) throws Exception {
		String url = "/work/modify";

		mnv = detail(work_number, "modify", rttr, mnv);

		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(WorkModifyCommand modifyReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/work/main";

		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {
				Work_AttachVO attach = workService.selectWork_AttachByAno(ano);

				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());

				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				workService.removeWork_AttachByAno(ano); // DB 삭제

			}
		}

		// 파일저장
		List<Work_AttachVO> attachList = saveFileToWork_Attaches(modifyReq.getUploadFile(), fileUploadPath);

		WorkVO work = modifyReq.toWorkVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			work.setWork_title(XSStitle);
		work.setAttachList(attachList);

		// DB 저장
		workService.modifyWork(work);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("work_number", work.getWork_number());

		return url;
	}

	@GetMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {

		String url = "downloadFile"; // bean name

		Work_AttachVO attach = workService.selectWork_AttachByAno(ano);

		model.addAttribute("savedPath", attach.getUploadPath());
		model.addAttribute("fileName", attach.getFileName());

		return url;
	}

}
