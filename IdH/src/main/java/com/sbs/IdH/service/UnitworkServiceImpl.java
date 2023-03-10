package com.sbs.IdH.service;

import java.util.HashMap;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.UnitworkDAO;
import com.sbs.IdH.dto.UnitworkVO;

public class UnitworkServiceImpl implements UnitworkService{

	
	UnitworkDAO unitworkDAO;
	
	public void setUnitworkDAO(UnitworkDAO unitworkDAO) {
		this.unitworkDAO = unitworkDAO;
	}
	
	@Override
	public void registUnitwork(UnitworkVO unitwork) throws Exception {
		unitworkDAO.insertUnitwork(unitwork);
	}

	@Override
	public void updateUnitwork(UnitworkVO unitwork) throws Exception {
	}

	@Override
	public void removeUnitwork(int unitwork_number) throws Exception {
		unitworkDAO.deleteUnitwork(unitwork_number);
		
	}

	@Override
	public UnitworkVO selectUnitwork(int unitwork_number) throws Exception {
		return unitworkDAO.selectUnitwork(unitwork_number);
	}

	@Override
	public Map<String, Object> selectUnitworkList(SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("unitworkList", unitworkDAO.selectSearchUnitworkList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(unitworkDAO.selectSearchUnitworkListCount(cri));
		dataMap.put("pageMaker",pageMaker);
		return dataMap;
	}

}
