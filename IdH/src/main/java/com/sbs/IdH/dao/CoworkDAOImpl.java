package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.dto.CoworkVO;

public class CoworkDAOImpl implements CoworkDAO {
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public CoworkVO selectCowork(int cowork_number) throws SQLException {
		CoworkVO cowork = session.selectOne("Cowork-Mapper.selectCowork",cowork_number);

		return cowork;
	}

	@Override
	public void deleteCowork(int cowork_number) throws SQLException {
		session.update("Cowork-Mapper.deleteCowork", cowork_number);
	}

	@Override
	public void insertCowork(CoworkVO cowork) throws SQLException {
		session.update("Cowork-Mapper.insertCowork",cowork);
	}
	

	@Override
	public void updateCowork(CoworkVO cowork) throws SQLException {
		session.update("Cowork-Mapper.updateCowork", cowork);
	}

	@Override
	public void increaseViewCnt(int cowork_number) throws SQLException {
		session.update("Cowork-Mapper.increaseViewCnt", cowork_number);
	}

	@Override
	public List<CoworkVO> selectCoworkCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<CoworkVO> coworkList = session.selectList("Cowork-Mapper.selectSearchCoworkList", cri, rowBounds);

		return coworkList;
	}

	@Override
	public int selectCoworkCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count=session.selectOne("Cowork-Mapper.selectSearchCoworkListCount",cri);
		return count;
	}

	@Override
	public int selectSeqNextValue() throws SQLException {
		int cowork_number=session.selectOne("Cowork-Mapper.selectCoworkSeqNext");
		return  cowork_number;
	}

}
