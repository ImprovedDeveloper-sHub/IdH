package com.sbs.IdH.service;

import java.util.List;

import com.sbs.IdH.dto.MenuVO;

public interface MenuService {
	

	List<MenuVO> getMainMenuList()throws Exception;
	
	List<MenuVO> getSubMenuList(String mCode)throws Exception;
	
	MenuVO getMenuByMcode(String mCode)throws Exception;
	
	MenuVO getMenuByMname(String mName)throws Exception;
}