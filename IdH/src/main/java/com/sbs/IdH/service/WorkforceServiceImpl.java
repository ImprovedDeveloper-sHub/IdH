package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.WorkforceDAO;
import com.sbs.IdH.dto.WorkforceVO;

public class WorkforceServiceImpl implements WorkforceService{

	
	WorkforceDAO workforceDAO;
	
	public void setWorkforceDAO(WorkforceDAO workforceDAO) {
		this.workforceDAO = workforceDAO;
	}
	
	
	
	@Override
	public void registWorkforce(WorkforceVO workforce) throws Exception {
		workforceDAO.insertWorkforce(workforce);
	}

	@Override
	public void updateWorkforce(WorkforceVO workforce) throws Exception {
	}

	@Override
	public void removeWorkforce(int workforce_number) throws Exception {
		workforceDAO.deleteWorkforce(workforce_number);
		
	}

	@Override
	public WorkforceVO selectWorkforce(int workforce_number) throws Exception {
		return workforceDAO.selectWorkforce(workforce_number);
	}

	@Override
	public Map<String, Object> selectWorkforceList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("workforceList", workforceDAO.selectSearchWorkforceList(cri));
		return dataMap;
	}

}
