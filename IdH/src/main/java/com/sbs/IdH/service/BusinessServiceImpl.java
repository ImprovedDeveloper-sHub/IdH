package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.BusinessDAO;
import com.sbs.IdH.dao.Business_attachDAO;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.Business_attachVO;

public class BusinessServiceImpl implements BusinessService {
	
	private BusinessDAO businessDAO;
	
	public void setBusinessDAO(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
	}
	
	private Business_attachDAO business_attachDAO;
	
	public void setBusiness_attachDAO(Business_attachDAO business_attachDAO) {
		this.business_attachDAO = business_attachDAO;
	}
	
	private void addBusiness_attachList(BusinessVO business) throws SQLException {
		
		if (business == null) {return;}
		
		int business_number = business.getBusiness_number();
		
		List<Business_attachVO> business_attachList = business_attachDAO.selectAllBusiness_attachByBusiness_number(business_number);
		
		business.setBusiness_attachList(business_attachList);
		
	}
	
	@Override
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<BusinessVO> businessList = businessDAO.selectBusinessCriteria(cri);
		
		if (businessList != null) {
			for (BusinessVO business : businessList) {
				addBusiness_attachList(business);
			}
		}
		
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
		
//		Map<String, Object> dataMap = new HashMap<String, Object>();
//		String businessMember = businessDAO.selectBusiness_number(business_number).getBusiness_member_id();
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		
//		dataMap.put(businessMember, businessMember);
//		dataMap.put("business", business);
		
		return business;
		
	}
	
	@Override
	public BusinessVO getBusinessForModify(int business_number) throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(business_number);
		
		return business;
		
	}

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

	@Override
	public Business_attachVO getBusiness_attachByAno(int ano) throws SQLException {
		
		Business_attachVO business_attach = business_attachDAO.selectBusiness_attachByAno(ano);
		
		return business_attach;
		
	}

	@Override
	public void removeBusiness_attachByAno(int ano) throws SQLException {
		
		business_attachDAO.deleteBusiness_attach(ano);
		
	}
	
	//추가 시작
	
	@Override
	public Map<String, Object> getBusinessListNotRowBound(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("businessList",businessDAO.selectBusinessCriteriaNotRowBound(cri));
		return dataMap;
	}
	
	//추가 종료
	
}
