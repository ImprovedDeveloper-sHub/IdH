package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkVO;

public interface WorkDAO {
	List<WorkVO>selectSearchWorkList(SearchCriteria cri);
	int selectSearchWorkListCount(SearchCriteria cri);
	WorkVO selectWorkByWork_Number(int work_number)throws SQLException;
	public void insertWork(WorkVO work);
	public void updateWork(WorkVO work);
	public void deleteWork(int work_number);
	public int selectWorkCriteriaTotalCount(SearchCriteria cri);
}
