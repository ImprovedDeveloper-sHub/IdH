package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.BusinessDAO;
import com.sbs.IdH.dto.BusinessVO;

public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDAO businessDAO;
	
	public void setBusinessDAO(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}
	
	@Override
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<BusinessVO> businessList = businessDAO.selectBusinessCriteria(cri);
		
		int totalCount = businessDAO.selectBusinessCriteriaTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("businessList", businessList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
	}

	@Override
	public BusinessVO getBusiness(int business_number) throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		
		return business;
		
	}

	/*
	@Override
	public BusinessVO getBusinessForModify(int business_number) throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		
		return business;
		
	}
	*/

	@Override
	public void regist(BusinessVO business) throws SQLException {
		
		int business_number = businessDAO.selectBusinessSequenceNextValue();
		
		business.setBusiness_number(business_number);
		
		businessDAO.insertBusiness(business);
		
	}

	@Override
	public void modify(BusinessVO business) throws SQLException {
		
		businessDAO.updateBusiness(business);
		
	} 
	
	@Override
	public void remove(int business_number) throws SQLException {
		
		businessDAO.deleteBusiness(business_number);
		
	}
	
}
