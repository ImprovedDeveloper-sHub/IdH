package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Business_attachVO;

public interface Business_attachDAO {
	
	public List<Business_attachVO> selectAllBusiness_attachByBusiness_number(int business_number) throws SQLException;
	
	public Business_attachVO selectBusiness_attachByAno(int ano) throws SQLException;
	
	public void insertBusiness_attach(Business_attachVO business_attach) throws SQLException;
	
	public void deleteBusiness_attach(int ano) throws SQLException;
	
	public void deleteAllBusiness_attach(int business_number) throws SQLException;
	
}
