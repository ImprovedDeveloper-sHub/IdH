package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;

import com.sbs.IdH.dto.CoworkVO;

public interface CoworkDAO {
	CoworkVO selectCowork(int cowork_number) throws SQLException;
	
	 void deleteCowork(int cowork_number)throws SQLException;
	
    void insertCowork(CoworkVO cowork)throws SQLException; 
    
    void updateCowork(CoworkVO cowork) throws SQLException ;
    
    void increaseViewCnt(int cowork_number) throws SQLException ;
   
    List<CoworkVO> selectCoworkCriteria(SearchCriteria cri) throws SQLException ;
    

	int selectCoworkCriteriaTotalCount(SearchCriteria cri) throws SQLException ;
	
	 int selectCoworkSeqNextValue() throws SQLException ;
	

}
	

