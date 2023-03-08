package com.sbs.IdH.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbs.IdH.dto.MenuVO;
import com.sbs.IdH.service.MenuService;

@Controller
public class MenuController {

	
	@Resource(name="menuService")
	private MenuService menuService;
	
	
	
	public void index(@RequestParam(defaultValue = "M000000") String mCode, Model model) throws Exception {
		List<MenuVO> menuList = menuService.getMainMenuList();
		MenuVO menu = menuService.getMenuByMcode(mCode);
		model.addAttribute("menuList", menuList);
		model.addAttribute("menu", menu);
	}
	
}
