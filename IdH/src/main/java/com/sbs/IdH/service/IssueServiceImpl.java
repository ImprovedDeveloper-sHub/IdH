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
import com.sbs.IdH.dao.Issue_AttachDAO;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.dto.Issue_AttachVO;
import com.sbs.IdH.dto.MemberVO;

public class IssueServiceImpl implements IssueService{

	private IssueDAO issueDAO;
	public void setIssueDAO(IssueDAO issueDAO) {
		this.issueDAO = issueDAO;
	}
	private Issue_AttachDAO issue_attachDAO;
	public void setIssue_AttachDAO(Issue_AttachDAO issue_attachDAO) {
		this.issue_attachDAO = issue_attachDAO;
	}

	@Override
	public Map<String, Object> selectIssueList(SearchCriteria cri) throws SQLException {
		List<IssueVO>issueList = issueDAO.selectSearchIssueList(cri);
		if(issueList != null) {
			for(IssueVO issue : issueList) {
				addAttachList(issue);				
			}
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
	public Map<String, Object> selectIssueCheckList(SearchCriteria cri) throws SQLException {
		Map<String,Object>dataMap = new HashMap<String,Object>();
		
		cri.setStatus(1);
		int issuesuccess = issueDAO.selectSearchIssueListCount(cri);
		cri.setStatus(2);
		int issuenow = issueDAO.selectSearchIssueListCount(cri);
		
		int getter = issueDAO.selectGetterIssueCount();
		int notgetter = issueDAO.selectNotGetterIssueCount();
		
		int total = issueDAO.selectIssueTotalCount();
		
		dataMap.put("total",total);
		dataMap.put("getter",getter);
		dataMap.put("notgetter",notgetter);
		dataMap.put("issuesuccess",issuesuccess);
		dataMap.put("issuenow",issuenow);
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
	public Map<String, Object> selectMyIssueList(SearchCriteria cri, HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());
		//cri.setMember_id("IdH");
		cri.setMemberStatus(1);
		dataMap.put("myIssueList", issueDAO.selectSearchIssueList(cri));
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectGetterIssueList(SearchCriteria cri, HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession(); 
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		cri.setMember_id(member.getMember_id());
		//cri.setMember_id("IdH");
		cri.setMemberStatus(2);
		dataMap.put("getterIssueList", issueDAO.selectSearchIssueList(cri));
		return dataMap;
	}

	private void addAttachList(IssueVO issue) throws SQLException {

		if (issue == null)
			return;

		int issue_number = issue.getIssue_number();
		List<Issue_AttachVO> attachList = issue_attachDAO.selectAttachesByIssue_number(issue_number);

		issue.setAttachList(attachList);
		
	}

	@Override
	public Issue_AttachVO selectIssue_AttachByAno(int ano) throws SQLException {

		Issue_AttachVO issue_attach = issue_attachDAO.selectIssue_AttachByAno(ano);

		return issue_attach;

	}

	@Override
	public void removeIssue_AttachByAno(int ano) throws SQLException {

		issue_attachDAO.deleteIssue_Attach(ano);

	}
	
}