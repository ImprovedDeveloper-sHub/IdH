package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.Business_attachVO;
import com.sbs.IdH.dto.BusinessgroupVO;

public interface BusinessService {
	
	public Map<String, Object> getBusinessList(SearchCriteria cri) throws SQLException;
	
	public BusinessVO getBusiness(int business_number) throws SQLException;
	
	public BusinessVO getBusinessForModify(int business_number) throws SQLException;
	
	public void regist(BusinessVO business) throws SQLException;
	
	public void modify(BusinessVO business) throws SQLException;
	
	public void modifyForBudget(BusinessVO business) throws SQLException;
	
	public void modifyForGroup(BusinessgroupVO businessgroup) throws SQLException;
	
	public void remove(int business_number) throws SQLException;
	
	public Business_attachVO getBusiness_attachByAno(int ano) throws SQLException;
	
	public void removeBusiness_attachByAno(int ano) throws SQLException;
	
	// 추가
	public Map<String, Object> getBusinessListNotRowBound(SearchCriteria cri) throws SQLException;

	public Map<String, Object> getWorkforceOfBusinessList(SearchCriteria cri) throws SQLException;
	
	public BusinessVO getBusinessTeamLeader(int business_number) throws Exception;

	public Map<String, Object> getBusinessgroupListForModify(SearchCriteria cri) throws SQLException;

	List<Map<String, Object>> selectBusinessScheduleListForCalendar(SearchCriteria cri) throws Exception;

	Map<String, Object> selectBusinessBudgetList(int buinsess_number) throws SQLException;

	List<Map<String, Object>> selectBusinessListForCalendar(SearchCriteria cri) throws Exception;
	
}
