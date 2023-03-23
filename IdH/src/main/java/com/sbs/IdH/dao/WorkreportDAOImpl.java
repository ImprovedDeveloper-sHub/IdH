package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkreportVO;

public class WorkreportDAOImpl implements WorkreportDAO{
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<WorkreportVO> selectSearchWorkreportList(SearchCriteria cri) {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<WorkreportVO>workreportList = session.selectList("Workreport-Mapper.selectSearchWorkreportList",cri,rowBounds);
		return workreportList;
	}

	@Override
	public int selectSearchWorkreportListCount(SearchCriteria cri) {
		int workreportListCount = session.selectOne("Workreport-Mapper.selectSearchWorkreportListCount",cri);
		return workreportListCount;
	}

	@Override
	public WorkreportVO selectWorkreportByWorkreport_Number(int workreport_number) throws SQLException {
		WorkreportVO workreport = session.selectOne("Workreport-Mapper.selectWorkreportByWorkreport_Number",workreport_number);
		return workreport;
	}

	@Override
	public void insertWorkreport(WorkreportVO workreport) {
		session.update("Workreport-Mapper.insertWorkreport",workreport);
		
	}

	@Override
	public void updateWorkreport(WorkreportVO workreport) {
		session.update("Workreport-Mapper.updateWorkreport",workreport);
		
	}

	@Override
	public void deleteWorkreport(int workreport_number) {
		session.update("Workreport-Mapper.deleteWorkreport",workreport_number);
		
	}

	@Override
	public int selectWorkreportCriteriaTotalCount(SearchCriteria cri) {
		int count = session.selectOne("Workreport-Mapper.selectSearchWorkreportListCount",cri);
		return count;
	}
	@Override
	public int selectWorkreportSeqNext() throws SQLException {
		int ano = session.selectOne("Workreport-Mapper.selectWorkreportSeqNext");
		return ano;
	}
}
