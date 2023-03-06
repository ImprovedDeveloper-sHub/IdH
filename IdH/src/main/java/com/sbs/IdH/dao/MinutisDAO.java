package com.sbs.IdH.dao;

import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.MinutisVO;

public interface MinutisDAO {
	List<MinutisVO>selectSearchMinutisList(SearchCriteria cri);
	int selectSearchMinutisListCount(SearchCriteria cri);
	MinutisVO selectMinutisByMinutis_Number(int minutis_number)throws Exception;
	public void insertMinutis(MinutisVO minutis);
	public void updateMinutis(MinutisVO minutis);
	public void deleteMinutis(int minutis_number);
}
