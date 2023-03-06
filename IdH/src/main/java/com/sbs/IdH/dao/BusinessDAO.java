package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.BusinessVO;

public interface BusinessDAO {
	
	public BusinessVO selectBusiness_number(int business_number) throws SQLException;
	
	public List<BusinessVO> selectBusiness_name(String business_name) throws SQLException;
	
	public List<BusinessVO> selectBusiness_content(String business_content) throws SQLException;
	
	public void insertBusiness(BusinessVO business) throws SQLException;
	
	public void updateBusiness(BusinessVO business) throws SQLException;
	
	/* 사업 삭제 불가, 상태 변경 조치(사업 종료, 취소 등 상태 메세지 표기)
	public void deleteBusiness(int business) throws SQLException;
	*/
	
}
