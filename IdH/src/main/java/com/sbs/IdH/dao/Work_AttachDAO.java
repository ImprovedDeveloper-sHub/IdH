package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Work_AttachVO;

public interface Work_AttachDAO {
	public List<Work_AttachVO> selectAttachesByWork_number(int work_number)throws SQLException;
	public Work_AttachVO selectWork_AttachByAno(int ano)throws SQLException;
	
	public void insertWork_Attach(Work_AttachVO work_Attach) throws SQLException;

	public void deleteWork_Attach(int ano) throws SQLException;

	public void deleteAllWork_Attach(int work_number)throws SQLException;
}
