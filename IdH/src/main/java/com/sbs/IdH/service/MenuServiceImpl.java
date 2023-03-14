package com.sbs.IdH.service;


import java.util.List;

import com.sbs.IdH.dao.MenuDAO;
import com.sbs.IdH.dto.MenuVO;

public class MenuServiceImpl implements MenuService{
	
	
	private MenuDAO menuDAO;
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	@Override
	public List<MenuVO> getMainMenuList() throws Exception {
		List<MenuVO> menuList = null;
		menuList = menuDAO.selectMainMenu();
		return menuList;
	}

	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws Exception {

		List<MenuVO> menuList = null;
			menuList = menuDAO.selectSubMenu(mCode);
		return menuList;
	}

	@Override
	public MenuVO getMenuByMcode(String mCode) throws Exception {
		MenuVO menu = null;
			menu = menuDAO.selectMenuByMcode(mCode);
		return menu;
	}

	@Override
	public MenuVO getMenuByMname(String mName) throws Exception {
		MenuVO menu = null;
			return menu = menuDAO.selectMenuByMname(mName);


	}
}
