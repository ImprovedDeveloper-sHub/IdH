package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.dto.Issue_AttachVO;

public interface Issue_AttachDAO {
	public List<Issue_AttachVO> selectAttachesByIssue_number(int issue_number)throws SQLException;
	public Issue_AttachVO selectIssue_AttachByAno(int ano)throws SQLException;
	
	public void insertIssue_Attach(Issue_AttachVO issue_Attach) throws SQLException;

	public void deleteIssue_Attach(int ano) throws SQLException;

	public void deleteAllIssue_Attach(int issue_number)throws SQLException;
	
	public int selectIssue_AttachSeqNext()throws SQLException;
}
