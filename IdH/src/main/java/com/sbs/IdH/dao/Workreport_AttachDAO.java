package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Workreport_AttachVO;

public interface Workreport_AttachDAO {
	public List<Workreport_AttachVO> selectAttachesByWorkreport_number(int workreport_number)throws SQLException;
	public Workreport_AttachVO selectWorkreport_AttachByAno(int ano)throws SQLException;
	
	public void insertWorkreport_Attach(Workreport_AttachVO workreport_Attach) throws SQLException;

	public void deleteWorkreport_Attach(int ano) throws SQLException;

	public void deleteAllWorkreport_Attach(int workreport_number)throws SQLException;
}
