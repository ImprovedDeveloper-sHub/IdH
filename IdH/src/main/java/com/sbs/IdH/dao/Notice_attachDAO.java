package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Notice_attachVO;

public interface Notice_attachDAO {

	List<Notice_attachVO> selectNotice_attachsByNotice_number(int notice_number) throws SQLException;

	Notice_attachVO selectAttachByAno(int ano) throws SQLException;

	void insertNotice_attach(Notice_attachVO notice_attach) throws SQLException;

	void deleteNotice_attach(int ano) throws SQLException;

	void deleteAllNotice_attach(int notice_number) throws SQLException;
	
}
