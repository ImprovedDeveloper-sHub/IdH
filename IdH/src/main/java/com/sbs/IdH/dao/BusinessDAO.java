package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.BusinessgroupVO;

public interface BusinessDAO {
	
	public List<BusinessVO> selectBusinessCriteria(SearchCriteria cri) throws SQLException;
	
	public int selectBusinessCriteriaTotalCount(SearchCriteria cri) throws SQLException;
	
	public BusinessVO selectBusiness_number(int business_number) throws SQLException;
	
	public List<BusinessVO> selectBusiness_name(String business_name) throws SQLException;
	
	public List<BusinessVO> selectBusiness_content(String business_content) throws SQLException;
	
	public int selectBusinessSequenceNextValue() throws SQLException;
	
	public void insertBusiness(BusinessVO business) throws SQLException;
	
	public void updateBusiness(BusinessVO business) throws SQLException;
	
	public void updateBusiness_budget(BusinessVO business) throws SQLException;
	
	public void deleteBusiness(int business_number) throws SQLException;
	
	//추가
	public List<BusinessVO> selectBusinessCriteriaNotRowBound(SearchCriteria cri) throws SQLException;
	
	public String selectBusinessName(int businessNumber) throws SQLException;

	public BusinessgroupVO selectBusinessgroup_number(int businessgroup_number);

}
