package com.sbs.IdH.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.IdH.dto.MemberVO;
import com.sbs.IdH.dto.MenuVO;
import com.sbs.IdH.service.MenuService;

@Controller
public class MenuController {

	
	@Resource(name="menuService")
	private MenuService menuService;
	
	
	@GetMapping("/index")
	public String index(@RequestParam(defaultValue = "M000000") String mCode, Model model, HttpServletRequest request) throws Exception {
		String url = "/common/indexPage";
		
		HttpSession session = request.getSession();
		MemberVO member =(MemberVO)session.getAttribute("loginUser");
		int rank = member.getMember_rank();
		List<MenuVO> menuList = menuService.getMainMenuList(rank);
		MenuVO menu = menuService.getMenuByMcode(mCode);
		model.addAttribute("menuList", menuList);
		model.addAttribute("menu", menu);
		return url;
	}
	
	@GetMapping("/subMenu")
	@ResponseBody
	public ResponseEntity<List<MenuVO>> subMenuToJSON(String mCode) {
		ResponseEntity<List<MenuVO>> entity = null;
		List<MenuVO> subMenu = null;
		try {
			subMenu = menuService.getSubMenuList(mCode);

			entity = new ResponseEntity<List<MenuVO>>(subMenu, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<MenuVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return entity;
	}	
}
