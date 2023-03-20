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

import com.sbs.IdH.command.CompanyruleModifyCommand;
import com.sbs.IdH.command.CompanyruleRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.Co_AttachVO;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.dto.Product_AttachVO;
import com.sbs.IdH.service.CompanyruleService;
import com.sbs.IdH.service.ProductService;
import com.sbs.IdH.utils.MakeFileName;

@RequestMapping("/companyrule")
@Controller
public class CompanyruleController {

	@Resource
	private CompanyruleService companyruleService;
	@Resource
	private ProductService productService;

	public void setCompanyruleService(CompanyruleService companyruleService) {
		this.companyruleService = companyruleService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void fileUploadCompanyrulePath(String UploadPath) {
		this.UploadPath = UploadPath;
	}

	@GetMapping("/main")
	public ModelAndView companyrule(SearchCriteria cri, ModelAndView mnv) throws Exception {

		mnv.addAllObjects(companyruleService.selectCompanyruleList(cri));
		mnv.addAllObjects(productService.selectProductEndList(cri));
		mnv.addObject("dataMap",companyruleService.selectCompanyruleList(cri));
		mnv.addObject("dataMap",productService.selectProductEndList(cri)); 
		return mnv;
	}

	@RequestMapping("/registForm")
	public String registForm() throws Exception {

		String url = "companyrule/regist";
		return url;
	}

	@Resource(name = "UploadPath")
	private String UploadPath;

	private List<Co_AttachVO> saveFileToAttaches(List<MultipartFile> multiFiles, String savePath) throws Exception {
		List<Co_AttachVO> attachList = new ArrayList<Co_AttachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Co_AttachVO attach = new Co_AttachVO();
				attach.setUploadPath(savePath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(CompanyruleRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/companyrule/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.UploadPath;

		List<Co_AttachVO> attachList = saveFileToAttaches(multiFiles, savePath);

		// DB
		CompanyruleVO companyrule = registReq.toCompanyruleVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		String XSScontent = (String) request.getAttribute("XSScontent");
		if (XSStitle != null) {
			companyrule.setCompanyrule_title(XSStitle);
			companyrule.setCompanyrule_content(XSScontent);
		}

		companyrule.setCo_AttachList(attachList);
		companyruleService.registCompanyrule(companyrule);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int companyrule_number, String from, ModelAndView mnv) throws Exception {
		String url = "/companyrule/detail";

		
		CompanyruleVO companyrule = null;

		companyrule = companyruleService.selectCompanyrule(companyrule_number);

		// 파일명 재정의
		if (companyrule != null) {
			List<Co_AttachVO> attachList = companyrule.getAttachList();
			if (attachList != null) {
				for (Co_AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("companyrule", companyrule);

		mnv.setViewName(url);

		return mnv;
	}
	@GetMapping("/product_detail")
	public ModelAndView productdetail(String from, ModelAndView mnv,int product_number) throws Exception {
		String url = "companyrule/product_detail";

		
		ProductVO product = null;

		product = productService.selectProduct(product_number);

		// 파일명 재정의
		if (product != null) {
			List<Product_AttachVO> attachList =product.getAttachList();
			if (attachList != null) {
				for (Product_AttachVO attach : attachList) {
					String fileName = attach.getFileName().split("\\$\\$")[1];
					attach.setFileName(fileName);
				}
			}
		}

		mnv.addObject("product", product);

		mnv.setViewName(url);

		return mnv;
	}


	
		


	@GetMapping("/remove")
	public String remove(int companyrule_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/companyrule/main";

		// 첨부파일 삭제
		List<Co_AttachVO> attachList = companyruleService.selectCompanyrule(companyrule_number).getAttachList();
		if (attachList != null) {
			for (Co_AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		companyruleService.removeCompanyrule(companyrule_number);

		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("companyrule_number", companyrule_number);

		return url;
	}

	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(ModelAndView mnv, int companyrule_number) throws Exception {
		String url = "companyrule/modify";

		mnv = detail(companyrule_number, "modify", mnv);

		mnv.setViewName(url);
		return mnv;
	}

	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public String modifyPOST(CompanyruleModifyCommand modifyReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/companyrule/detail";

		// 파일 삭제
		if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
			for (int ano : modifyReq.getDeleteFile()) {
				Co_AttachVO attach = companyruleService.selectCo_AttachByAno(ano);

				File deleteFile = new File(attach.getUploadPath(), attach.getFileName());

				if (deleteFile.exists()) {
					deleteFile.delete(); // File 삭제
				}
				companyruleService.removeCo_AttachByAno(ano); // DB 삭제

			}
		}

		// 파일저장
		List<Co_AttachVO> attachList = saveFileToAttaches(modifyReq.getUploadFile(), UploadPath);

		CompanyruleVO companyrule = modifyReq.toCompanyruleVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			companyrule.setCompanyrule_title(XSStitle);
		companyrule.setCo_AttachList(attachList);

		// DB 저장
		companyruleService.modifyCompanyrule(companyrule);

		rttr.addFlashAttribute("from", "modify");
		rttr.addAttribute("companyrule_number", companyrule.getCompanyrule_number());

		return url;
	}

	@GetMapping("/getFile")
	public String getFile(int ano, Model model) throws Exception {

		String url = "downloadFile"; // bean name

		Co_AttachVO attach = companyruleService.selectCo_AttachByAno(ano);

		model.addAttribute("savedPath", attach.getUploadPath());
		model.addAttribute("fileName", attach.getFileName());

		return url;
	}
}
