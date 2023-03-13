
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

import com.sbs.IdH.command.ProductModifyCommand;
import com.sbs.IdH.command.ProductRegistCommand;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CoworkVO;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.dto.Product_AttachVO;
import com.sbs.IdH.service.CoworkService;
import com.sbs.IdH.service.ProductService;
import com.sbs.IdH.utils.MakeFileName;

@RequestMapping("/product")
@Controller

public class ProductController {
	@Resource
	private ProductService productService;
	@Resource
	private CoworkService coworkService;
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCoworkService(CoworkService coworkService) {
		this.coworkService = coworkService;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}




	@GetMapping("/main")
	public ModelAndView main(SearchCriteria cri, ModelAndView mnv) throws Exception {

		mnv.addAllObjects(productService.selectProductList(cri));
		mnv.addAllObjects(coworkService.selectCoworkList(cri));
		return mnv;
	}

	
	

	@RequestMapping("/registForm")
	public String registForm() throws Exception {

		String url = "product/regist";
		return url;
	}

	@Resource(name = "fileUploadPath")
	private String fileUploadPath;

	private List<Product_AttachVO> saveFileToAttaches(List<MultipartFile> multiFiles, String savePath)
			throws Exception {
		List<Product_AttachVO> attachList = new ArrayList<Product_AttachVO>();
		// 저장 -> attachVO -> list.add
		if (multiFiles != null) {
			for (MultipartFile multi : multiFiles) {
				String fileName = MakeFileName.toUUIDFileName(multi.getOriginalFilename(), "$$");
				File target = new File(savePath, fileName);
				target.mkdirs();
				multi.transferTo(target);

				Product_AttachVO attach = new Product_AttachVO();
				attach.setUploadPath(savePath);
				attach.setFileName(fileName);
				attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1).toUpperCase());

				attachList.add(attach);
			}
		}
		return attachList;
	}

	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public String regist(ProductRegistCommand registReq, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		String url = "redirect:/product/main";

		List<MultipartFile> multiFiles = registReq.getUploadFile();
		String savePath = this.fileUploadPath;

		List<Product_AttachVO> attachList = saveFileToAttaches(multiFiles, savePath);

		// DB
		ProductVO Product = registReq.toProductVO();
		String XSStitle = (String) request.getAttribute("XSStitle");
		if (XSStitle != null)
			Product.setProduct_title(XSStitle);

		Product.setProduct_AttachList(attachList);
		productService.registProduct(Product);

		// output
		rttr.addFlashAttribute("from", "regist");

		return url;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int product_number, String from, RedirectAttributes rttr, ModelAndView mnv)
			throws Exception {
		String url = "/product/detail";
		

		ProductVO product = null;

		product = productService.selectProduct(product_number);

		// 파일명 재정의
		if (product != null) {
			List<Product_AttachVO> attachList = product.getAttachList();
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
	
	  @GetMapping("/cowork_detail") public ModelAndView cowork_detail(int cowork_number, String
	  from, RedirectAttributes rttr, ModelAndView mnv) throws Exception { String
	  url = "/product/cowork_detail";
	  
	  CoworkVO cowork = null;
	  
	  cowork = coworkService.selectCowork(cowork_number);
	  
	
	  
	  mnv.addObject("cowork", cowork); mnv.setViewName(url);
	  
	  return mnv; 
	  }
	 

	 @GetMapping("/remove")
	public String remove(int product_number, RedirectAttributes rttr) throws Exception {
		String url = "redirect:/product/main";

		// 첨부파일 삭제
		List<Product_AttachVO> attachList = productService.selectProduct(product_number).getAttachList();
		if (attachList != null) {
			for (Product_AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if (target.exists()) {
					target.delete();
				}
			}
		}
		// DB삭제
		productService.removeProduct(product_number);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("product_number", product_number);
		
		/*
		 * coworkService.removeCowork(product_number);
		 * 
		 * rttr.addFlashAttribute("from", "remove"); rttr.addAttribute("cowork_number",
		 * product_number);
		 */
		
		return url;
	}

	/*
	 * @GetMapping("/remove") public String remove(int cowork_number,
	 * RedirectAttributes rttr) throws Exception { String url =
	 * "redirect:/product/main";
	 * 
	 * 
	 * // DB삭제 coworkService.removeCowork(cowork_number);
	 * 
	 * rttr.addFlashAttribute("from", "remove"); rttr.addAttribute("cowork_number",
	 * cowork_number);
	 * 
	 * return url; }
	 */
	 @GetMapping("/modifyForm")
		public ModelAndView modifyForm(ModelAndView mnv, int product_number,RedirectAttributes rttr) throws Exception {
			String url = "/product/modify";
			
			mnv = detail(product_number,"modify",rttr,mnv);
			
			mnv.setViewName(url);
			return mnv;
		}
	 @PostMapping(value="/modify", produces = "text/plain;charset=utf-8")
		public String modifyPOST(ProductModifyCommand modifyReq,HttpServletRequest request,RedirectAttributes rttr) throws Exception {
			String url = "redirect:/product/main";
			
			// 파일 삭제
			if (modifyReq.getDeleteFile() != null && modifyReq.getDeleteFile().length > 0) {
				for (int ano : modifyReq.getDeleteFile()) {				
					Product_AttachVO attach = productService.selectProduct_AttachByAno(ano);
					
					File deleteFile = new File(attach.getUploadPath(), attach.getFileName());
					
					if (deleteFile.exists()) {
						deleteFile.delete(); // File 삭제
					}
					productService.removeProduct_AttachByAno(ano); // DB 삭제
					
				}
			}
		
			//파일저장
			List<Product_AttachVO> attachList 
				= saveFileToAttaches(modifyReq.getUploadFile(), fileUploadPath);
			
			
			ProductVO product = modifyReq.toProductVO();	
			String XSStitle = (String)request.getAttribute("XSStitle");
			if(XSStitle !=null)  product .setProduct_title(XSStitle);
			product.setProduct_AttachList(attachList);
			
			// DB 저장
			productService.modifyProduct(product);

			rttr.addFlashAttribute("from", "modify");
			rttr.addAttribute("product_number", product.getProduct_number());
			
			return url;
		}
	 @GetMapping("/getFile")
		public String getFile(int ano,Model model) throws Exception {
			
			String url="downloadFile"; //bean name
			
			Product_AttachVO attach = productService.selectProduct_AttachByAno(ano);
			

			model.addAttribute("savedPath", attach.getUploadPath());
			model.addAttribute("fileName", attach.getFileName());		
		
			return url;
		}
}
