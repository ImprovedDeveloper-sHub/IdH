package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.RequireVO;

public class RequireDAOImpl implements RequireDAO {

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<RequireVO> selectSearchRequireList(SearchCriteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<RequireVO> requireList = session.selectList("Require-Mapper.selectSearchRequireList",cri,rowBounds);
		
		return requireList;
	}

	@Override
	public int selectSearchRequireListCount(SearchCriteria cri) throws SQLException {
		int count = session.selectOne("Require-Mapper.selectSearchRequireListCount",cri);
		return count;
	}

	@Override
	public RequireVO selectRequire(int require_number) throws SQLException {
		RequireVO Require = session.selectOne("Require-Mapper.selectRequire", require_number);
		return Require;
	}

	@Override
	public void insertRequire(RequireVO require) throws SQLException {
		session.update("Require-Mapper.insertRequire",require);

	}

	@Override
	public void updateRequire(RequireVO require) throws SQLException {
		session.update("Require-Mapper.updateRequire",require);

	}

	@Override
	public void deleteRequire(int require_number) throws SQLException {
		session.update("Require-Mapper.deleteRequire",require_number);

	}

	@Override
	public int selectRequireSeqNext() throws SQLException {
		int seq_num = session.selectOne("Require-Mapper.selectRequireSeqNext");
		return seq_num;
	}

}
