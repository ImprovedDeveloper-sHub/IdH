package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Work_AttachVO;

public class Work_AttachDAOImpl implements Work_AttachDAO{
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Work_AttachVO> selectAttachesByWork_number(int work_number) throws SQLException {
		List<Work_AttachVO> attachList=session.selectList("Work_Attach-Mapper.selectAttachByWork_number",work_number);
		return attachList;
	}

	@Override
	public Work_AttachVO selectWork_AttachByAno(int ano) throws SQLException {
		Work_AttachVO attach=session.selectOne("Work_Attach-Mapper.selectWork_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertWork_Attach(Work_AttachVO work_Attach) throws SQLException {
		session.update("Work_Attach-Mapper.insertWork_Attach",work_Attach);
	}

	@Override
	public void deleteWork_Attach(int ano) throws SQLException {
           session.update("Work_Attach-Mapper.deleteWork_Attach",ano);		
		
	}

	@Override
	public void deleteAllWork_Attach(int work_number) throws SQLException {
		session.update("Work_Attach-Mapper.deleteAllWork_Attach",work_number);		
	}
}
