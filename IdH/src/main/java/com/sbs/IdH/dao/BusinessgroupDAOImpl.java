package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;
import com.sbs.IdH.dto.BusinessgroupVO;

public class BusinessgroupDAOImpl implements BusinessgroupDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<BusinessVO> selectSearchBusinessgroupList(SearchCriteria cri) throws SQLException {
		
		int startRow = cri.getStartRowNum();
		int endRow = startRow + cri.getPerPageNum() - 1;

		Map<String, Object> dataParam = new HashMap<String, Object>();
		
		dataParam.put("startRow", startRow);
		dataParam.put("endRow", endRow);
		dataParam.put("searchType", cri.getSearchType());
		dataParam.put("keyword", cri.getKeyword());

		List<BusinessVO> businessList = session.selectList("Businessgroup-Mapper.selectSearchBusinessList", dataParam);

		return businessList;
		
	}

	@Override
	public int selectSearchBusinessgroupListCount(SearchCriteria cri) throws SQLException {
		
		int count = session.selectOne("Businessgroup-Mapper.selectSearchBusinessgroupListCount", cri);
		
		return count;
		
	}
	
	@Override
	public BusinessgroupVO selectBusinessgroup_number(int businessgroup_number) throws SQLException {
		
		BusinessgroupVO businessgroup = session.selectOne("Businessgroup-Mapper.selectBusinessgroup_number", businessgroup_number);
		
		return businessgroup;
		
	}

	@Override
	public List<BusinessVO> selectBusinessgroup_member_id(String businessgroup_name) throws SQLException {
		
		
		
		return null;
		
	}

	@Override
	public void insertBusinessgroup(BusinessgroupVO businessgroup) throws SQLException {
		
		
		
	}

	@Override
	public void updateBusinessgroup(BusinessgroupVO businessgroup) throws SQLException {
		
		
		
	}

	@Override
	public void deleteBusinessgroup(int businessgroup_number) throws SQLException {
		
		
		
	}
	
}
