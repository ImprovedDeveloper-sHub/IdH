package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.UnitworkVO;

public interface UnitworkDAO {

	
	List<UnitworkVO> selectSearchUnitworkList(SearchCriteria cri) throws SQLException;

	List<UnitworkVO> selectSearchUnitworkListForProject(int project_number) throws SQLException;
	
	int selectSearchUnitworkListCount(SearchCriteria cri) throws SQLException;

	UnitworkVO selectUnitwork(int unitwork_number) throws SQLException;	

	int selectUnitworkSeqNext() throws SQLException;

	void insertUnitwork(UnitworkVO unitwork) throws SQLException;
	
	void updateUnitwork(UnitworkVO unitwork) throws SQLException;

	void updateUnitworkForProjectStart(UnitworkVO unitwork) throws SQLException;

	void updateUnitworkForProjectEnd(UnitworkVO unitwork) throws SQLException;
	
	void deleteUnitwork(int unitwork_number) throws SQLException;
}
