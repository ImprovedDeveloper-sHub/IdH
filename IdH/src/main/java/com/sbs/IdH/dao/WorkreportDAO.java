package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkreportVO;

public interface WorkreportDAO {
	List<WorkreportVO>selectSearchWorkreportList(SearchCriteria cri);
	int selectSearchWorkreportListCount(SearchCriteria cri);
	WorkreportVO selectWorkreportByWorkreport_Number(int work_number)throws SQLException;
	public void insertWorkreport(WorkreportVO work);
	public void updateWorkreport(WorkreportVO work);
	public void deleteWorkreport(int work_number);
	public int selectWorkreportCriteriaTotalCount(SearchCriteria cri);
}
