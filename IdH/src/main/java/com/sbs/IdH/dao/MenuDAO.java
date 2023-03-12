package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

<<<<<<< HEAD
=======
import org.apache.ibatis.session.SqlSession;

>>>>>>> refs/remotes/origin/heo
import com.sbs.IdH.dto.MenuVO;

public interface MenuDAO {

	// 메인메뉴
	List<MenuVO> selectMainMenu() throws SQLException;

	// 서브메뉴
	List<MenuVO> selectSubMenu(String mCode) throws SQLException;

	// 메뉴정보
	MenuVO selectMenuByMcode(String mCode) throws SQLException;

	MenuVO selectMenuByMname(String mName) throws SQLException;
}






