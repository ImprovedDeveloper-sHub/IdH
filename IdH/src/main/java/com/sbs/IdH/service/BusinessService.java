package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;

public interface BusinessService {
	
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException;
	
	public BusinessVO getBusiness(int business_number) throws SQLException;
	
	/* public BusinessVO getBusinessForModify(int business_number) throws SQLException; */
	
	public void regist(BusinessVO business) throws SQLException;
	
	public void modify(BusinessVO business) throws SQLException;
	
	public void remove(int business_number) throws SQLException;
	
}
