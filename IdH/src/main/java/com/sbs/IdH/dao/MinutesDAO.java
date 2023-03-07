package com.sbs.IdH.dao;

import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.MinutesVO;

public interface MinutesDAO {
	List<MinutesVO>selectSearchMinutesList(SearchCriteria cri);
	int selectSearchMinutesListCount(SearchCriteria cri);
	MinutesVO selectMinutesByMinutes_Number(int minutes_number)throws Exception;
	public void insertMinutes(MinutesVO minutes);
	public void updateMinutes(MinutesVO minutes);
	public void deleteMinutes(int minutes_number);
}
