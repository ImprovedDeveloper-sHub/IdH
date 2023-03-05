package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.UnitworkVO;

public class UnitworkDAOImpl implements UnitworkDAO{

	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<UnitworkVO> selectSearchUnitworkList(SearchCriteria cri) throws SQLException {
		List<UnitworkVO> unitworkList = session.selectList("Unitwork-Mapper.selectUnitworkList", cri);
		return unitworkList;
	}

	@Override
	public List<UnitworkVO> selectSearchUnitworkListForProject(int project_number) throws SQLException {
		List<UnitworkVO> unitworkList = session.selectList("Unitwork-Mapper.selectUnitworkForProject", project_number);
		return unitworkList;
	}

	@Override
	public int selectSearchUnitworkListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Unitwork-Mapper.selectSearchUnitworkListCount", cri);
		return count;
	}

	@Override
	public UnitworkVO selectUnitwork(int unitwork_number) throws SQLException {
		UnitworkVO unitwork = session.selectOne("Unitwork-Mapper.selectUnitwork", unitwork_number);
		return unitwork;
	}
	
	@Override
	public int selectUnitworkSeqNext() throws SQLException {
		session.update("Unitwork-Mapper.selectUnitworkSeqNext");
		return 0;
	}

	

	@Override
	public void insertUnitwork(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.insertUnitwork", unitwork);
		
	}

	@Override
	public void updateUnitworkForProjectStart(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.updateUnitworkForProjectStart", unitwork);		
	}

	@Override
	public void updateUnitworkForProjectEnd(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.updateUnitworkForProjectEnd", unitwork);
		
	}

	
	@Override
	public void deleteUnitwork(int unitwork_number) throws SQLException {
		session.update("Unitwork-Mapper.deleteUnitwork", unitwork_number);
		
	}

}
