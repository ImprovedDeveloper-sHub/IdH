package com.sbs.IdH.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.RequireModifyCommand;
import com.sbs.IdH.command.RequireRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.Require_attachDAO;
import com.sbs.IdH.dao.UnitworkDAO;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.RequireVO;
import com.sbs.IdH.dto.Require_attachVO;
import com.sbs.IdH.service.BusinessService;
import com.sbs.IdH.service.RequireService;
import com.sbs.IdH.service.UnitworkService;
import com.sbs.IdH.utils.MakeFileName;

@RequestMapping("/require")
@Controller
public class RequireController {

	@Resource
	private RequireService requireService;
	@Resource
	private Require_attachDAO require_attachDAO;
	@Resource
	private BusinessService businessService;
	@Resource
	private UnitworkDAO unitworkDAO;
	@Resource
	private UnitworkService unitworkService;

	@GetMapping("/main")
	public ModelAndView main(ModelAndView mnv, SearchCriteria cri ) throws Exception {
		/*
		 * SearchCriteria cri = new SearchCriteria(); cri.setKeyword(keyword);
		 * cri.setSearchType(searchType); cri.setPage(1); cri.setPerPageNum(10);
		 */
		mnv.addObject("dataMap", requireService.selectRequireList(cri));
		mnv.addAllObjects(requireService.selectRequireList(cri));
		
		return mnv;
	}

	@GetMapping("/getUnitworkCalender")
	@ResponseBody
	public List<Map<String, Object>> getUnitworkCalender(HttpServletRequest request) throws Exception {

		SearchCriteria cri = new SearchCriteria();

		/*
		 * MemberVO member = (MemberVO) request.getSession().getAttribute("loginUser");
		 * cri.setMember_id(member.getMember_id());
		 */

		return unitworkService.selectUnitworkListForCalendar(cri);

	}

	@GetMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv, HttpServletRequest request) throws Exception {

		String url = "require/regist";
		SearchCriteria cri = new SearchCriteria();

		MemberVO member = (MemberVO) request.getSession().getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());

		mnv.addAllObjects(businessService.getBusinessList(cri));
		mnv.setViewName(url);
		return mnv;
	}

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;

	private List<Require_attachVO> saveFileToAttaches(List<MultipartFile> multiFiles, String savePath)
			throws Exception {
		List<Require_attachVO> attachList = new ArrayList<Require_attachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Require_attachVO attach = new Require_attachVO();
				attach.setUploadpath(savePath);
				attach.setFilename(fileName);
				attach.setFiletype(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(RequireRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/require/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.fileUploadPath;

		List<Require_attachVO> attachList = saveFileToAttaches(multiFiles, savePath);

		// DB
		RequireVO require = registReq.toRequireVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		String XSSdetail = (String) request.getAttribute("XSSdetail");
		if (XSStitle != null)
			require.setRequire_title(XSStitle);
		if (XSSdetail != null)
			require.setRequire_detail(XSSdetail);

		require.setAttachList(attachList);
		requireService.registRequire(require);

		// output
		rttr.addFlashAttribute("from", "regist");
		return url;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int require_number, String from, ModelAndView mnv) throws Exception {
		String url = "/require/detail";

		RequireVO require = requireService.selectRequire(require_number);

		// 파일명 재정의
		if (require != null) {
			List<Require_attachVO> attachList = require.getAttachList();
			if (attachList != null) {
				for (Require_attachVO attach : attachList) {
					String fileName = attach.getFilename().split("\\$\\$")[1];
					attach.setFilename(fileName);
				}
			}
		}
		mnv.addObject("require", require);
		mnv.setViewName(url);

		return mnv;
	}

	@GetMapping("/remove")
	public String remove(int require_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/require/detail";

		// 첨부파일 삭제
		List<Require_attachVO> attachList = requireService.selectRequire(require_number).getAttachList();
		if (attachList != null) {
			for (Require_attachVO attach : attachList) {
				File target = new File(attach.getUploadpath(), attach.getFilename());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		requireService.removeRequire(require_number);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("require_number", require_number);

		return url;
	}

	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int require_number, HttpServletRequest request) throws Exception {
		String url = "/require/modify";

		mnv = detail(require_number, "modify", mnv);
		SearchCriteria cri = new SearchCriteria();

		MemberVO member = (MemberVO) request.getSession().getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());

		mnv.addAllObjects(businessService.getBusinessList(cri));

		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(RequireModifyCommand modifyReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/require/detail";

		
		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {
				Require_attachVO attach = requireService.getRequire_attachByAno(ano);

				File deleteFile = new File(attach.getUploadpath(), attach.getFilename());

				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				requireService.removeRequire_attach_Ano(ano); // DB 삭제

			}
		}

		// 파일저장
		List<Require_attachVO> attachList = saveFileToAttaches(modifyReq.getUploadFile(), fileUploadPath);

		RequireVO require = modifyReq.toRequireVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			require.setRequire_title(XSStitle);
		require.setAttachList(attachList);

		// DB 저장
		requireService.modifyRequire(require);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("require_number", require.getRequire_number());

		return url;
	}

	@GetMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {

		String url = "downloadFile"; // bean name

		Require_attachVO attach = requireService.getRequire_attachByAno(ano);

		model.addAttribute("savedPath", attach.getUploadpath());
		model.addAttribute("fileName", attach.getFilename());

		return url;
	}

}
