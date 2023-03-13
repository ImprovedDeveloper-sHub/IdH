package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkVO;
import com.sbs.IdH.dto.Work_AttachVO;

public interface WorkService {
	Map<String,Object>selectWorkList(SearchCriteria cri)throws SQLException;
	Map<String,Object>selectWorkListByWriter(HttpServletRequest request,SearchCriteria cri)throws SQLException;
	Map<String,Object>selectWorkListByApprover(HttpServletRequest request,SearchCriteria cri)throws SQLException;
	void registWork(WorkVO work)throws SQLException;
	WorkVO selectWork(int work_number)throws SQLException;
	void modifyWork(WorkVO work)throws SQLException;
	void removeWork(int work_number)throws SQLException;
	Work_AttachVO selectWork_AttachByAno(int ano)throws SQLException;
	void removeWork_AttachByAno(int ano)throws SQLException;
}
