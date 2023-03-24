package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.RequireVO;
import com.sbs.IdH.dto.Require_attachVO;

public interface RequireService {

		Map<String, Object> selectRequireList(SearchCriteria cri) throws SQLException;
		
		void registRequire(RequireVO require) throws SQLException;

		RequireVO selectRequire(int require_number) throws SQLException;

		void modifyRequire(RequireVO require) throws SQLException;

		void removeRequire(int require_number) throws SQLException;
		
		Require_attachVO getRequire_attachByAno(int ano)throws SQLException;

		void removeRequire_attach_Ano(int ano)throws SQLException;
	
		
		
		
		
}
