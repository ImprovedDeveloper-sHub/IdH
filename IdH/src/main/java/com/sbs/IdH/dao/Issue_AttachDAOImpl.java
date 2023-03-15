package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.dto.Issue_AttachVO;

public class Issue_AttachDAOImpl implements Issue_AttachDAO{
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Issue_AttachVO> selectAttachesByIssue_number(int issue_number) throws SQLException {
		List<Issue_AttachVO> attachList=session.selectList("Issue_Attach-Mapper.selectAttachByIssue_number",issue_number);
		return attachList;
	}

	@Override
	public Issue_AttachVO selectIssue_AttachByAno(int ano) throws SQLException {
		Issue_AttachVO attach=session.selectOne("Issue_Attach-Mapper.selectIssue_AttachByAno",ano);
		return attach;
	}

	@Override
	public void insertIssue_Attach(Issue_AttachVO issue_Attach) throws SQLException {
		session.update("Issue_Attach-Mapper.insertIssue_Attach",issue_Attach);
	}

	@Override
	public void deleteIssue_Attach(int ano) throws SQLException {
           session.update("Issue_Attach-Mapper.deleteIssue_Attach",ano);		
		
	}

	@Override
	public void deleteAllIssue_Attach(int issue_number) throws SQLException {
		session.update("Issue_Attach-Mapper.deleteAllIssue_Attach",issue_number);		
	}
}
