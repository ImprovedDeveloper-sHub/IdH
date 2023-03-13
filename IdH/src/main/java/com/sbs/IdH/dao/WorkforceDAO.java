package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkforceVO;

public interface WorkforceDAO {

	
	List<WorkforceVO> selectSearchWorkforceList(SearchCriteria cri) throws SQLException;

	List<WorkforceVO> selectSearchWorkforceListForProject(int project_number) throws SQLException;
	
	int selectSearchWorkforceListCount(SearchCriteria cri) throws SQLException;

	WorkforceVO selectWorkforce(int workforce_number) throws SQLException;	

	int selectWorkforceSeqNext() throws SQLException;

	void insertWorkforce(WorkforceVO workforce) throws SQLException;

	void updateWorkforceForProjectStart(WorkforceVO workforce) throws SQLException;

	void updateWorkforceForProjectEnd(WorkforceVO workforce) throws SQLException;
	
	void deleteWorkforce(int workforce_number) throws SQLException;
}
