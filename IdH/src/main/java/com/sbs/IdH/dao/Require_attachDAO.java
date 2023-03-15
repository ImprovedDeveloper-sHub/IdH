package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Require_attachVO;

public interface Require_attachDAO {

	List<Require_attachVO> selectRequire_attachsByRequire_number(int require_number) throws SQLException;

	Require_attachVO selectAttachByAno(int ano) throws SQLException;

	void insertRequire_attach(Require_attachVO require_attach) throws SQLException;

	void deleteRequire_attach(int ano) throws SQLException;

	void deleteAllRequire_attach(int require_number) throws SQLException;
	
}
