package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.RequireVO;

public interface RequireService {

		Map<String, Object> selectRequireList(SearchCriteria cri) throws SQLException;

		void registRequire(RequireVO require) throws SQLException;

		RequireVO selectRequire(int require_number) throws SQLException;

		void modifyRequire(RequireVO require) throws SQLException;

		void removeRequire(int require_number) throws SQLException;
		
//		Require_attachVO getAttachByAno(int require_attach_number)throws SQLException;
//
//		void removeRequire_attach(int require_attach_number)throws SQLException;
	
}
