package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkreportVO;
import com.sbs.IdH.dto.Workreport_AttachVO;

public interface WorkreportService {
	Map<String,Object>selectWorkreportList(SearchCriteria cri)throws SQLException;
	void registWorkreport(WorkreportVO workreport)throws SQLException;
	WorkreportVO selectWorkreport(int workreport_number)throws SQLException;
	void modifyWorkreport(WorkreportVO workreport)throws SQLException;
	void removeWorkreport(int workreport_number)throws SQLException;
	Map<String, Object> selectGetterWorkreportList(SearchCriteria cri, HttpServletRequest request)throws SQLException;
	Map<String, Object> selectMyWorkreportList(SearchCriteria cri, HttpServletRequest request) throws SQLException;
	Workreport_AttachVO selectWorkreport_AttachByAno(int ano)throws SQLException;
    void removeWorkreport_AttachByAno(int ano)throws SQLException;
}
