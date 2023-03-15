package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.Issue_AttachVO;

public interface IssueService {
	Map<String, Object> selectIssueList(SearchCriteria cri) throws SQLException;

	void registIssue(IssueVO issue) throws SQLException;

	IssueVO selectIssue(int issue_number) throws SQLException;

	void modifyIssue(IssueVO issue) throws SQLException;

	void removeIssue(int issue_number) throws SQLException;

	Map<String, Object> selectGetterIssueList(SearchCriteria cri, HttpServletRequest request) throws SQLException;

	Map<String, Object> selectMyIssueList(SearchCriteria cri, HttpServletRequest request) throws SQLException;

	Map<String, Object> selectIssueCheckList(SearchCriteria cri) throws SQLException;

	Issue_AttachVO selectIssue_AttachByAno(int ano) throws SQLException;

	void removeIssue_AttachByAno(int ano) throws SQLException;
}
