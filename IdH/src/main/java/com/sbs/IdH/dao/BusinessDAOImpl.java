package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.BusinessVO;

public class BusinessDAOImpl implements BusinessDAO {
	
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<BusinessVO> selectBusinessCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<BusinessVO> businessList = session.selectList("Business-Mapper.selectSearchBusinessList", cri, rowBounds);	
		return businessList;
	}

	@Override
	public int selectBusinessCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		
		int count = session.selectOne("Business-Mapper.selectSearchBusinessListCount", cri);
		
		return count;
		
	}
	
	@Override
	public BusinessVO selectBusiness_number(int business_number) throws SQLException {
		BusinessVO business = session.selectOne("Business-Mapper.selectBusiness_number", business_number);
		return business;
		
	}

	@Override
	public List<BusinessVO> selectBusiness_name(String business_name) throws SQLException {
		
		List<BusinessVO> business = session.selectList("Business-Mapper.selectBusiness_name", business_name);
		
		return business;
		
	}

	@Override
	public List<BusinessVO> selectBusiness_content(String business_content) throws SQLException {
		
		List<BusinessVO> business = session.selectList("Business-Mapper.selectBusiness_content", business_content);
		
		return business;
		
	}
	
	@Override
	public int selectBusinessSequenceNextValue() throws SQLException {
		
		int seq_num = session.selectOne("Business-Mapper.selectBusinessSequenceNextValue");
		
		return seq_num;
		
	}

	@Override
	public void insertBusiness(BusinessVO business) throws SQLException {
		
		session.update("Business-Mapper.insertBusiness", business);
		
	}

	@Override
	public void updateBusiness(BusinessVO business) throws SQLException {
		
		session.update("Business-Mapper.updateBusiness", business);
		
	}
	
	@Override
	public void deleteBusiness(int business_number) throws SQLException {
		
		session.update("Business-Mapper.deleteBusiness", business_number);
		
	}
	
	
	//추가
	@Override
	public List<BusinessVO> selectBusinessCriteriaNotRowBound(SearchCriteria cri) throws SQLException {
		List<BusinessVO> businessList = session.selectList("Business-Mapper.selectSearchBusinessList", cri);	
		return businessList;
	}
	
	@Override
	public String selectBusinessName(int businessNumber) throws SQLException {
		BusinessVO business = session.selectOne("Business-Mapper.selectBusiness_number", businessNumber);
		return business.getBusiness_name();
	}
	
	
}
