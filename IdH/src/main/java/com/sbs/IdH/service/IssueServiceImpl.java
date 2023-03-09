package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.IssueDAO;
import com.sbs.IdH.dto.IssueVO;

public class IssueServiceImpl implements IssueService{

	private IssueDAO issueDAO;
	public void setIssueDAO(IssueDAO issueDAO) {
		this.issueDAO = issueDAO;
	}

	@Override
	public Map<String, Object> selectIssueList(SearchCriteria cri) throws SQLException {
		List<IssueVO>issueList = issueDAO.selectSearchIssueList(cri);
		if(issueList != null) {
			for(IssueVO issue : issueList);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(issueDAO.selectIssueCriteriaTotalCount(cri));
		
		Map<String,Object>dataMap = new HashMap<String,Object>();
		dataMap.put("issueList",issueList);
		dataMap.put("pageMaker",pageMaker);
		
		return dataMap;
	}

	@Override
	public void registIssue(IssueVO issue) throws SQLException {
		issue.setIssue_number(2);
		issueDAO.insertIssue(issue);
	}
	

	@Override
	public IssueVO selectIssue(int issue_number) throws SQLException {
		IssueVO issue = issueDAO.selectIssueByIssue_Number(issue_number);
		return issue;
	}

	@Override
	public void modifyIssue(IssueVO issue) throws SQLException {
		issueDAO.updateIssue(issue);
		
	}

	@Override
	public void removeIssue(int issue_number) throws SQLException {
		issueDAO.deleteIssue(issue_number);
		
	}
	
	@Override
	public Map<String, Object> selectMyIssueList(SearchCriteria cri,HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		cri.setMemberId((String)session.getAttribute("loginUserId"));
		cri.setMemberStatus(1);
		dataMap.put("myIssueList", issueDAO.selectSearchIssueList(cri));
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectGetterIssueList(SearchCriteria cri,HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		cri.setMemberId((String)session.getAttribute("loginUserId"));
		cri.setMemberStatus(2);
		dataMap.put("getterIssueList", issueDAO.selectSearchIssueListCount(cri));
		return dataMap;
	}
	
}