package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.RequireVO;

public interface RequireDAO {

	List<RequireVO> selectSearchRequireList(SearchCriteria cri) throws SQLException;
	
	int selectSearchRequireListCount(SearchCriteria cri) throws SQLException;

	public RequireVO selectRequire(int require_number)throws SQLException;

	void insertRequire(RequireVO require) throws SQLException;

	void updateRequire(RequireVO require) throws SQLException;

	void deleteRequire(int require_number) throws SQLException;

	int selectRequireSeqNext() throws SQLException;
}
