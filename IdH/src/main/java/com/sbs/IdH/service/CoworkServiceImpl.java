package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.CoworkDAO;
import com.sbs.IdH.dto.CoworkVO;
import com.sbs.IdH.dto.ProductVO;


public class CoworkServiceImpl implements CoworkService{
	
	private CoworkDAO coworkDAO;
	

	public void setCoworkDAO(CoworkDAO coworkDAO) {
		this.coworkDAO = coworkDAO;
	}

	@Override
	public Map<String, Object> selectCoworkList(SearchCriteria cri) throws SQLException {
		List<CoworkVO> coworkList = coworkDAO.selectCoworkCriteria(cri);
		if (coworkList != null)
			for (CoworkVO cowork : coworkList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(coworkDAO.selectCoworkCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("coworkList", coworkList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	
}

	@Override
	public void registCowork(CoworkVO cowork) throws SQLException {
		
		cowork.setCowork_number(2);
		coworkDAO.insertCowork(cowork);

	
	}

	@Override
	public CoworkVO readCowork(int cowork_number) throws SQLException {

		CoworkVO cowork = coworkDAO.selectCowork(cowork_number);
		coworkDAO.increaseViewCnt(cowork_number);

		
		return cowork;

	}

	@Override
	public CoworkVO selectCowork(int cowork_number) throws SQLException {
		CoworkVO cowork = coworkDAO.selectCowork(cowork_number);

		
		
		return cowork;
	}

	@Override
	public void modifyCowork(CoworkVO cowork) throws SQLException {
		coworkDAO.updateCowork(cowork);
		}

	@Override
	public void removeCowork(int cowork_number) throws SQLException {
		coworkDAO.deleteCowork(cowork_number);
	}


}