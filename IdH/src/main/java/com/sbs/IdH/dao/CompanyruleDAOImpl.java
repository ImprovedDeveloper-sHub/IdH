package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.dto.ProductVO;

public class CompanyruleDAOImpl implements CompanyruleDAO{
	
	private SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public CompanyruleVO selectCompanyrule(int companyrule_number) throws SQLException {
		CompanyruleVO companyrule = session.selectOne("Companyrule-Mapper.selectCompanyrule", companyrule_number);

		return companyrule;
	}

	@Override
	public void deleteCompanyrule(int companyrule_number) throws SQLException {
		session.update("Companyrule-Mapper.deleteCompanyrule", companyrule_number);
	}

	@Override
	public void insertCompanyrule(CompanyruleVO companyrule) throws SQLException {
		session.update("Companyrule-Mapper.insertCompanyrule",companyrule);
	}

	@Override
	public void updateCompanyrule(CompanyruleVO companyrule) throws SQLException {
		session.update("Companyrule-Mapper.updateCompanyrule", companyrule);
	}

	@Override
	public void increaseViewCnt(int companyrule_number) throws SQLException {
		session.update("Companyrule-Mapper.increaseViewCnt", companyrule_number);
	}

	@Override
	public List<CompanyruleVO> selectCompanyruleCriteria(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<CompanyruleVO> companyruleList = session.selectList("Companyrule-Mapper.selectSearchCompanyruleList", cri, rowBounds);

		return companyruleList;
	}

	@Override
	public int selectCompanyruleCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		int count=session.selectOne("Companyrule-Mapper.selectSearchCompanyruleListCount",cri);
		return count;
	}

	@Override
	public int selectCompanySeqNextValue() throws SQLException {
		int companyrule_number=session.selectOne("Companyrule-Mapper.selectCompanyruleSeqNext");
		return  companyrule_number;
	}

}
