package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.Business_attachVO;

public interface BusinessService {
	
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException;
	
	public BusinessVO getBusiness(int business_number) throws SQLException;
	
	public BusinessVO getBusinessForModify(int business_number) throws SQLException;
	
	public void regist(BusinessVO business) throws SQLException;
	
	public void modify(BusinessVO business) throws SQLException;
	
	public void remove(int business_number) throws SQLException;
	
	public Business_attachVO getBusiness_attachByAno(int ano) throws SQLException;
	
	public void removeBusiness_attachByAno(int ano) throws SQLException;
	
	//추가
	public Map<String, Object> getBusinessListNotRowBound(SearchCriteria cri) throws SQLException;

	List<Map<String, Object>> selectBusinessListForCalendar(SearchCriteria cri) throws Exception;
	
}
