package com.sbs.IdH.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.IdH.command.BusinessModifyCommand;
import com.sbs.IdH.command.BusinessRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.Business_attachVO;
import com.sbs.IdH.dto.BusinessgroupVO;
import com.sbs.IdH.service.BudgetService;
import com.sbs.IdH.service.BusinessService;
import com.sbs.IdH.service.ProjectService;
import com.sbs.IdH.service.WorkforceService;
import com.sbs.IdH.utils.MakeFileName;

@Controller
@RequestMapping("business")
public class BusinessController {
	
	@Resource(name="businessService")
	private BusinessService businessService;
	
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@Resource(name="projectService")
	private ProjectService projectService;
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@Resource(name="budgetService")
	private BudgetService budgetService;
	
	public void setBudgetService(BudgetService budgetService) {
		this.budgetService = budgetService;
	}
	
	@Resource(name="workforceService")
	private WorkforceService workforceService;
	
	public void setWorkforceService(WorkforceService workforceService) {
		this.workforceService = workforceService;
	}
	
	@Resource(name="fileUploadBusinessPath")
	private String fileUploadBusinessPath;
	
	@GetMapping("/schedule/main")
	public ModelAndView scheduleMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/schedule/getCalendar")
	@ResponseBody
	public List<Map<String, Object>> setParamBusinessSchedule() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		return businessService.selectBusinessScheduleListForCalendar(cri);
	}
	
	@GetMapping("/schedule/registForm")
	public String scheduleRegistForm() throws SQLException {

		String url = "/business/schedule/regist";
		
//		SearchCriteria cri = new SearchCriteria();
//		
//	    MemberVO member = (MemberVO) request.getSession().getAttribute("loginUser");
//	    cri.setMember_id(member.getMember_id());
		
		return url;
		
	}
	
	@PostMapping(value="/schedule/regist", produces="text/plain;charset=UTF-8")
	public String scheduleRegist(BusinessRegistCommand businessreg, HttpServletRequest request, RedirectAttributes rttr) throws SQLException, IllegalStateException, IOException {
		
		String url = "redirect:/business/schedule/main";
		
		List<MultipartFile> multiFiles = businessreg.getBusiness_attachList();
		String savePath = this.fileUploadBusinessPath;
		
		List<Business_attachVO> attachList = saveFiletoattaches(multiFiles, savePath);
		
		BusinessVO business = businessreg.toBusinessVO();
		
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null) {business.setBusiness_name(XSStitle);}
		
		business.setBusiness_attachList(attachList);
		
		businessService.regist(business);
		rttr.addFlashAttribute("from", "regist");
		
		return url;
		
	}
	
	private List<Business_attachVO> saveFiletoattaches(List<MultipartFile> multiFiles, String savePath) throws SQLException, IllegalStateException, IOException {
		
		List<Business_attachVO> attachList = new ArrayList<Business_attachVO>();
		
		if (multiFiles != null) {
			
			for (MultipartFile multi : multiFiles) {
				
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);
				
				Business_attachVO attach = new Business_attachVO();
				
				attach.setUploadpath(savePath);
				attach.setFilename(fileName);
				attach.setFiletype(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());
				
				attachList.add(attach);
				
			}
			
		}
		
		return attachList;
		
	}

	@GetMapping("/schedule/detail")
	public ModelAndView scheduleDetail(ModelAndView mnv, int business_number) throws SQLException {
		
		mnv.addObject("business", businessService.getBusiness(business_number));

		
		
		
		return mnv;
		
	}
	
	@GetMapping("/schedule/modifyForm")
	public ModelAndView scheduleModifyForm(int business_number, ModelAndView mnv) throws SQLException {
		
		String url = "/business/schedule/modify";
		
		BusinessVO business = businessService.getBusinessForModify(business_number);
		
		mnv.addObject("business", business);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	@PostMapping(value="/schedule/modify", produces="text/plain;charset=UTF-8")
	public String scheduleModify(BusinessModifyCommand businessmod, HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> multiFiles) throws SQLException, IllegalStateException, IOException {
		
		String url = "redirect:/business/schedule/detail";
		
		if (businessmod.getDeleteFile() != null && businessmod.getDeleteFile().length > 0) {
			
			for (int ano : businessmod.getDeleteFile()) {
				
				Business_attachVO attach = businessService.getBusiness_attachByAno(ano);
				
				File deleteFile = new File(attach.getUploadpath(), attach.getFilename());
				
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				
				businessService.removeBusiness_attachByAno(ano);
				
			}
		}

		List<Business_attachVO> attachList = saveFiletoattaches(multiFiles, fileUploadBusinessPath);

		BusinessVO business = businessmod.toBusinessVO();
		
		String XSStitle = (String) request.getAttribute("XSStitle");
		
		if (XSStitle != null) {
			business.setBusiness_name(XSStitle);
			business.setBusiness_attachList(attachList);
		}
		
		businessService.modify(business);
		
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("business_number", business.getBusiness_number());
		
		return url;
		
	}
	
	@GetMapping("/schedule/remove")
	public String remove(int business_number, RedirectAttributes rttr) throws SQLException {
		
		String url = "redirect:/business/schedule/main";
		
		List<Business_attachVO> attachList = businessService.getBusiness(business_number).getBusiness_attachList();
		
		if (attachList != null) {
			
			for (Business_attachVO attach : attachList) {
				
				File target = new File(attach.getUploadpath(), attach.getFilename());
				
				if (target.exists()) {target.delete();}
				
			}
			
		}
		
		businessService.remove(business_number);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("business_number", business_number);
		
		return url;
		
	}
	
	@GetMapping("/budget/main")
	public ModelAndView budgetMain(ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/budget/detail")
	public ModelAndView budgetDetail(ModelAndView mnv, int business_number) throws SQLException {
		
		mnv.addObject("business", businessService.getBusiness(business_number));
		
		mnv.addObject("budget", businessService.selectBusinessBudgetList(business_number));
		
		return mnv;
		
	}
	
	@GetMapping("/budget/modifyForm")
	public ModelAndView budgetModifyForm(int business_number, ModelAndView mnv) throws SQLException {
		
		String url = "/business/budget/modify";
		
		BusinessVO business = businessService.getBusinessForModify(business_number);
		
		mnv.addObject("business", business);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	@PostMapping(value="/budget/modify", produces="text/plain;charset=UTF-8")
	public String budgetModify(BusinessModifyCommand businessmod, HttpServletRequest request, RedirectAttributes rttr) throws SQLException {
		
		String url = "redirect:/business/budget/detail";
		
		BusinessVO business = businessmod.toBusinessVO();
		
		businessService.modifyForBudget(business);
		
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("business_number", business.getBusiness_number());
		
		return url;
		
	}
	
	@GetMapping("/group/main")
	public ModelAndView groupMain(ModelAndView mnv, SearchCriteria cri) throws Exception {
		
		mnv.addAllObjects(businessService.getBusinessList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/group/detail")
	public ModelAndView groupDetail(ModelAndView mnv, SearchCriteria cri, int business_number) throws Exception {
		
		mnv.addObject("business", businessService.getBusinessTeamLeader(business_number));
		mnv.addAllObjects(businessService.getWorkforceOfBusinessList(cri));
		mnv.addAllObjects(workforceService.selectWorkforceList(cri));
		
		return mnv;
		
	}
	
	@GetMapping("/group/modifyForm")
	public ModelAndView groupModifyForm(int businessgroup_number, ModelAndView mnv, SearchCriteria cri) throws SQLException {
		
		String url = "/business/group/modify";
		
		BusinessgroupVO businessgroup = (BusinessgroupVO) businessService.getBusinessgroupListForModify(cri);
		
		mnv.addObject("businessgroup", businessgroup);
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	@PostMapping(value="/group/modify", produces="text/plain;charset=UTF-8")
	public String groupModify(BusinessModifyCommand businessmod, HttpServletRequest request, RedirectAttributes rttr) throws SQLException {
		
		String url = "redirect:/business/group/detail";
		
		BusinessgroupVO businessgroup = businessmod.toBusinessgroupVO();
		
		businessService.modifyForGroup(businessgroup);
		
		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("businessgroup_number", businessgroup.getBusinessgroup_number());
		
		return url;
		
	}
	
}
