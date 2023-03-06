package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.BusinessVO;

public class BusinessDAOImpl implements BusinessDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
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
	public void insertBusiness(BusinessVO business) throws SQLException {
		
		session.update("Business-Mapper.insertBusiness", business);
		
	}

	@Override
	public void updateBusiness(BusinessVO business) throws SQLException {
		
		session.update("Business-Mapper.updateBusiness", business);
		
	}
	
	/* 사업 삭제 불가, 상태 변경 조치(사업 종료, 취소 등 상태 메세지 표기)
	@Override
	public void deleteBusiness(int business) throws SQLException {
		
		session.update("Business-Mapper.deleteBusiness", business);
		
	}
	*/
	
}
