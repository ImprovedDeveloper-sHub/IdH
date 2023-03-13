package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Business_attachVO;

public class Business_attachDAOImpl implements Business_attachDAO {
	
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Business_attachVO> selectAllBusiness_attachByBusiness_number(int business_number) throws SQLException {
		
		List<Business_attachVO> attachList = session.selectList("Business_attach-Mapper.selectAllBusiness_attachByBusiness_number", business_number);
		
		return attachList;
		
	}

	@Override
	public Business_attachVO selectBusiness_attachByAno(int ano) throws SQLException {
		
		Business_attachVO attach = session.selectOne("Business_attach-Mapper.selectBusiness_attachByAno", ano);
		
		return attach;
		
	}

	@Override
	public void insertBusiness_attach(Business_attachVO business_attach) throws SQLException {
		
		session.update("Business_attach-Mapper.insertBusiness_attach", business_attach);
		
	}

	@Override
	public void deleteBusiness_attach(int ano) throws SQLException {
		
		session.update("Business_attach-Mapper.deleteBusiness_attach", ano);
		
	}

	@Override
	public void deleteAllBusiness_attach(int business_number) throws SQLException {
		
		session.update("Business_attach-Mapper.deleteAllBusiness_attach", business_number);
		
	}
	
}
