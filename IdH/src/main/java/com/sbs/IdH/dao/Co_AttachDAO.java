package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Co_AttachVO;

public interface Co_AttachDAO {

	public List<Co_AttachVO> selectAttachesByCo_number(int co_number)throws SQLException;
	public Co_AttachVO selectCo_AttachByAno(int ano)throws SQLException;
	
	public void insertCo_Attach(Co_AttachVO co_Attach) throws SQLException;

	public void deleteCo_Attach(int ano) throws SQLException;

	public void deleteAllCo_Attach(int co_number)throws SQLException;
	 
	//public int selectCo_AttachSeqNextValue() throws SQLException ;
}
