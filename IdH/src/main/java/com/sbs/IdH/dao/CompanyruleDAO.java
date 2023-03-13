package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CompanyruleVO;

public interface CompanyruleDAO {
	
	//product number로 조회
	CompanyruleVO selectCompanyrule(int companyrule_number) throws SQLException;
		
		 void deleteCompanyrule(int companyrule_number)throws SQLException;
		
	     void insertCompanyrule(CompanyruleVO companyrule)throws SQLException; 
	     
	     void updateCompanyrule(CompanyruleVO companyrule) throws SQLException ;
	     
			/* void increaseViewCnt(int companyrule_number) throws SQLException ; */
	    
	     List<CompanyruleVO> selectCompanyruleCriteria(SearchCriteria cri) throws SQLException ;
	     

	 	int selectCompanyruleCriteriaTotalCount(SearchCriteria cri) throws SQLException ;
	 	
	 	 int selectCompanySeqNextValue() throws SQLException ;
	 	

}
