package com.sbs.IdH.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.command.WorkreportModifyCommand;
import com.sbs.IdH.command.WorkreportRegistCommand;
import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.WorkreportVO;
import com.sbs.IdH.dto.Workreport_AttachVO;
import com.sbs.IdH.service.WorkreportService;
import com.sbs.IdH.utils.MakeFileName;

@Controller
@RequestMapping("/workreport")
public class WorkreportController {

	@Resource
	private WorkreportService workreportService;
	
	@GetMapping("/main")
	public ModelAndView main(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request) throws Exception {
//		SearchCriteria cri2 = cri.getNewCri(cri);
//		SearchCriteria cri3 = cri.getNewCri(cri);
//		SearchCriteria cri4 = cri.getNewCri(cri);
		String url = "/workreport/main";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if(member.getMember_rank()==1) {
			url = "/workreport/main2";

		}else {
			SearchCriteria cri2 = cri.newCri();
			mnv.addAllObjects(workreportService.selectGetterWorkreportList(cri2, request));
			SearchCriteria cri4 = cri.newCri();
			mnv.addAllObjects(workreportService.selectGetterCheckList(cri4,request));	
		}
		SearchCriteria cri5 = cri.newCri();
		mnv.addAllObjects(workreportService.selectMyWorkreportList(cri5, request));
		SearchCriteria cri3 = cri.newCri();
		mnv.addAllObjects(workreportService.selectMyCheckList(cri3,request));
		mnv.setViewName(url);
		return mnv;
	}

	@GetMapping("/registForm")
	public String registForm() throws Exception {

		String url = "workreport/regist";
		return url;
	}

	@Resource(name = "UploadPath")
	private String UploadPath;

	private List<Workreport_AttachVO> saveFileToWorkreport_Attaches(List<MultipartFile> multiFiles, String savePath) throws Exception {
		List<Workreport_AttachVO> attachList = new ArrayList<Workreport_AttachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Workreport_AttachVO attach = new Workreport_AttachVO();
				attach.setUploadPath(savePath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(WorkreportRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/workreport/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.UploadPath;

		List<Workreport_AttachVO> attachList = saveFileToWorkreport_Attaches(multiFiles, savePath);

		// DB
		WorkreportVO workreport = registReq.toWorkreportVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			workreport.setWorkreport_title(XSStitle);

		workreport.setAttachList(attachList);
		workreportService.registWorkreport(workreport);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int workreport_number, String from, ModelAndView mnv)
			throws Exception {
		String url = "/workreport/detail";

		WorkreportVO workreport = null;

		workreport = workreportService.selectWorkreport(workreport_number);

		// 파일명 재정의
		if (workreport != null) {
			List<Workreport_AttachVO> attachList = workreport.getAttachList();
			if (attachList != null) {
				for (Workreport_AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("workreport", workreport);
		mnv.setViewName(url);

		return mnv;
	}

	@GetMapping("/remove")
	public String remove(int workreport_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/workreport/main";

		// 첨부파일 삭제
		List<Workreport_AttachVO> attachList = workreportService.selectWorkreport(workreport_number).getAttachList();
		if (attachList != null) {
			for (Workreport_AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		workreportService.removeWorkreport(workreport_number);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("workreport_number", workreport_number);

		return url;
	}

	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int workreport_number, RedirectAttributes rttr) throws Exception {
		String url = "/workreport/modify";

		mnv = detail(workreport_number, "modify", mnv);

		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(WorkreportModifyCommand modifyReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/workreport/detail";

		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {
				Workreport_AttachVO attach = workreportService.selectWorkreport_AttachByAno(ano);

				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());

				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				workreportService.removeWorkreport_AttachByAno(ano); // DB 삭제

			}
		}

		// 파일저장
		List<Workreport_AttachVO> attachList = saveFileToWorkreport_Attaches(modifyReq.getUploadFile(), UploadPath);

		WorkreportVO workreport = modifyReq.toWorkreportVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null) {
			workreport.setWorkreport_title(XSStitle);
			workreport.setAttachList(attachList);			
		}

		// DB 저장
		workreportService.modifyWorkreport(workreport);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("workreport_number", workreport.getWorkreport_number());

		return url;
	}

	@GetMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {

		String url = "downloadFile"; // bean name

		Workreport_AttachVO attach = workreportService.selectWorkreport_AttachByAno(ano);

		model.addAttribute("savedPath", attach.getUploadPath());
		model.addAttribute("fileName", attach.getFileName());

		return url;
	}
	
	 @PostMapping("/getMyworkreportlist")
	 public ModelAndView getMyworkreportlist(ModelAndView mnv,SearchCriteria cri,HttpServletRequest request)throws Exception{
		 mnv.addAllObjects(workreportService.selectMyWorkreportList(cri, request));
		 mnv.setViewName("/workreport/getMyworkreportlist");
		 
		 
		 return mnv;
	 }
	 @PostMapping("/getGetterworkreportlist")
	 public ModelAndView getGetterworkreportlist(ModelAndView mnv,SearchCriteria cri,HttpServletRequest request)throws Exception{
		 mnv.addAllObjects(workreportService.selectGetterWorkreportList(cri, request));
		 mnv.setViewName("/workreport/getGetterworkreportlist");
		 
		 
		 return mnv;
	 }
	 
	 @PostMapping("/workreportEnd")
	   public String workreportEnd(@RequestParam HashMap<String, Object> dataMap) throws Exception {
	      String url = "redirect:/workreport/main";
	      String workreportParamStr = dataMap.get("workreportparam").toString();
	      
	      String[] workreport_array = workreportParamStr.split(",");
	      for (String workreport_number : workreport_array) {
	    	  WorkreportVO workreport = workreportService.selectWorkreport(Integer.parseInt(workreport_number));
	    	  workreport.setWorkreport_check(2);
	    	  workreportService.modifyWorkreportCheck(workreport);
	      }
	      
	      
	      return url;
	   }
	 
	 @PostMapping("/workreportEnd2")
	   public String workreportEnd2(@RequestParam HashMap<String, Object> dataMap) throws Exception {
	      String url = "redirect:/workreport/main";
	      String workreportParamStr = dataMap.get("workreportparam").toString();
	      
	      String[] workreport_array = workreportParamStr.split(",");
	      for (String workreport_number : workreport_array) {
	    	  WorkreportVO workreport = workreportService.selectWorkreport(Integer.parseInt(workreport_number));
	    	  workreport.setWorkreport_check(2);
	    	  workreportService.modifyWorkreportCheck(workreport);
	      }
	      
	      
	      return url;
	   }
	   

}
