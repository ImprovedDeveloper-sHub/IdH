
  package com.sbs.IdH.controller;
  
  import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProductVO;
import com.sbs.IdH.service.ProductService;
  
  @RequestMapping("/product")
  @Controller
  
  public class ProductController {
	  @Resource
		private ProductService productService;
	  

		@GetMapping("/main")
		public ModelAndView product(SearchCriteria cri, ModelAndView mnv)throws Exception{
				
				
				
	            mnv.addAllObjects(productService.selectProductList(cri));
	             
	             return mnv;
		}
  }
  

