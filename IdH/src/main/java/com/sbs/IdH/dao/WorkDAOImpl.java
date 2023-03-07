package com.sbs.IdH.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkVO;

public class WorkDAOImpl implements WorkDAO{
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<WorkVO> selectSearchWorkList(SearchCriteria cri) {
		List<WorkVO>workList = session.selectList("Work-Mapper.selectSearchWorkList");
		return workList;
	}

	@Override
	public int selectSearchWorkListCount(SearchCriteria cri) {
		int workListCount = session.selectOne("Work-Mapper.selectSearchWorkListCount",cri);
		return workListCount;
	}

	@Override
	public WorkVO selectWorkByWork_Number(int work_number) throws Exception {
		WorkVO work = session.selectOne("Work-Mapper.selectWorkByWork_Number",work_number);
		return work;
	}

	@Override
	public void insertWork(WorkVO work) {
		session.update("Work-Mapper.insertWork",work);
		
	}

	@Override
	public void updateWork(WorkVO work) {
		session.update("Work-Mapper.updateWork",work);
		
	}

	@Override
	public void deleteWork(int work_number) {
		session.update("Work-Mapper.deleteWork",work_number);
		
	}
}
