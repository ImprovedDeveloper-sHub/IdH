package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.BusinessgroupVO;

public interface BusinessgroupDAO {
	
	public List<BusinessVO> selectSearchBusinessgroupList(SearchCriteria cri) throws SQLException;
	
	public int selectSearchBusinessgroupListCount(SearchCriteria cri) throws SQLException;
	
	public BusinessgroupVO selectBusinessgroup_number(int businessgroup_number) throws SQLException;
	
	public List<BusinessVO> selectBusinessgroup_member_id(String businessgroup_name) throws SQLException;
	
	public void insertBusinessgroup(BusinessgroupVO businessgroup) throws SQLException;
	
	public void updateBusinessgroup(BusinessgroupVO businessgroup) throws SQLException;
	
	public void deleteBusinessgroup(int businessgroup_number) throws SQLException;
	
}
