package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
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
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);
		List<UnitworkVO> unitworkList = session.selectList("Unitwork-Mapper.selectUnitworkList", cri, rowBounds);
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
		return session.selectOne("Unitwork-Mapper.selectUnitworkSeqNext");
	}

	

	@Override
	public void insertUnitwork(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.insertUnitwork", unitwork);
		
	}

	@Override
	public void updateUnitworkForRegistProject(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.updateUnitworkPlanForProjectStart", unitwork);		
	}

	@Override
	public void updateUnitworkForProjectEnd(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.updateUnitworkForProjectEnd", unitwork);
		
	}

	
	@Override
	public void deleteUnitwork(int unitwork_number) throws SQLException {
		session.update("Unitwork-Mapper.deleteUnitwork", unitwork_number);
		
	}

	@Override
	public void updateUnitwork(UnitworkVO unitwork) throws SQLException {
		session.update("Unitwork-Mapper.updateUnitwork", unitwork);
		
	}

	@Override
	public Map<String, Object> selectUnitworkCountForChart(SearchCriteria cri) throws SQLException {
		Map<String,Object> colMap = new HashMap<String, Object>();
		int unitwork_count = session.selectOne("Unitwork-Mapper.selectSearchUnitworkListCount", cri);
		colMap.put("v",unitwork_count);
		return colMap;
	}
	
	@Override
	public int selectUnitworkCount(SearchCriteria cri) throws SQLException {
		int unitwork_count = session.selectOne("Unitwork-Mapper.selectSearchUnitworkListCount", cri);
		return unitwork_count;
	}

}
