package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Companyrule_AttachVO;

public interface Companyrule_AttachDAO {
	
	public List<Companyrule_AttachVO> selectAttachesByCompanyrule_attach_number(int companyrule_attach_number)throws SQLException;
	public Companyrule_AttachVO selectCompanyrule_AttachByAno(int ano)throws SQLException;
	
	public void insertCompanyrule_Attach(Companyrule_AttachVO companyrule_Attach) throws SQLException;

	public void deleteCompanyrule_Attach(int ano) throws SQLException;

	public void deleteAllCompanyrule_Attach(int companyrule_attach_number)throws SQLException;
	
}




