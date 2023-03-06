package com.sbs.IdH.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MinutisVO;

public class MinutisDAOImpl implements MinutisDAO{

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<MinutisVO> selectSearchMinutisList(SearchCriteria cri) {
		List<MinutisVO>minutisList = session.selectList("Minutis-Mapper.selectSearchMinutisList");
		return minutisList;
	}

	@Override
	public int selectSearchMinutisListCount(SearchCriteria cri) {
		int minutisListCount = session.selectOne("Minutis-Mapper.selectSearchMinutisListCount",cri);
		return minutisListCount;
	}

	@Override
	public MinutisVO selectMinutisByMinutis_Number(int minutis_number) throws Exception {
		MinutisVO minutis = session.selectOne("Minutis-Mapper.selectMinutisByMinutis_Number",minutis_number);
		return minutis;
	}

	@Override
	public void insertMinutis(MinutisVO minutis) {
		session.update("Minutis-Mapper.insertMinutis",minutis);
		
	}

	@Override
	public void updateMinutis(MinutisVO minutis) {
		session.update("Minutis-Mapper.updateMinutis",minutis);
		
	}

	@Override
	public void deleteMinutis(int minutis_number) {
		session.update("Minutis-Mapper.deleteMinutis",minutis_number);
		
	}

}
