
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

	@GetMapping("/main")
	public ModelAndView product(SearchCriteria cri, ModelAndView mnv) throws Exception {

		mnv.addAllObjects(productService.selectProductList(cri));

		return mnv;
	}

	public ModelAndView cowork(SearchCriteria cri, ModelAndView mnv) throws Exception {

		mnv.addAllObjects(productService.selectProductList(cri));

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
	/*
	 * @GetMapping("/detail") public ModelAndView detail(int cowork_number, String
	 * from, RedirectAttributes rttr, ModelAndView mnv) throws Exception { String
	 * url = "/cowork/detail";
	 * 
	 * CoworkVO cowork = null;
	 * 
	 * cowork = coworkService.selectCowork(cowork_number);
	 * 
	 * // 파일명 재정의 if (cowork != null) { List<Cowork_AttachVO> attachList =
	 * cowork.getAttachList(); if (attachList != null) { for (Cowork_AttachVO attach
	 * : attachList) { String fileName = attach.getFileName().split("\\$\\$")[1];
	 * attach.setFileName(fileName); } } }
	 * 
	 * mnv.addObject("cowork", cowork); mnv.setViewName(url);
	 * 
	 * return mnv; }
	 */

}
