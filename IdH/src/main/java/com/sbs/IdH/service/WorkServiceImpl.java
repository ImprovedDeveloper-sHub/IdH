package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.WorkDAO;
import com.sbs.IdH.dto.WorkVO;

public class WorkServiceImpl implements WorkService{
	private WorkDAO workDAO;
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	@Override
	public Map<String, Object> selectWorkList(SearchCriteria cri) throws SQLException {
		List<WorkVO>workList = workDAO.selectSearchWorkList(cri);
		if(workList != null) {
			for(WorkVO work : workList);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(workDAO.selectWorkCriteriaTotalCount(cri));
		
		Map<String,Object>dataMap = new HashMap<String,Object>();
		dataMap.put("workList",workList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public void registWork(WorkVO work) throws SQLException {
		work.setWork_number(2);
		workDAO.insertWork(work);
	}
	

	@Override
	public WorkVO selectWork(int work_number) throws SQLException {
		WorkVO work = workDAO.selectWorkByWork_Number(work_number);
		return work;
	}

	@Override
	public void modifyWork(WorkVO work) throws SQLException {
		workDAO.updateWork(work);
		
	}

	@Override
	public void removeWork(int work_number) throws SQLException {
		workDAO.deleteWork(work_number);
		
	}
}
