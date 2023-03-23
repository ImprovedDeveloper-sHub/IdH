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
import com.sbs.IdH.dto.CompanyruleVO;
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
		int total = issueDAO.selectIssueTotalCount();
		
		cri.setStatus(1);
		int issuesuccess = issueDAO.selectSearchIssueListCount(cri);
		//int issuesuccess = issuesuccessCount/total*100;
		cri.setStatus(2);
		int issuenow = issueDAO.selectSearchIssueListCount(cri);
		//int issuenow = issuenowCount/total*100;
		
		int getter = issueDAO.selectGetterIssueCount();
		//int getter = getterCount/total*100;
		int notgetter = issueDAO.selectNotGetterIssueCount();
		//int notgetter = notgetterCount/total*100;		
		
		dataMap.put("total",total);
		dataMap.put("getter",getter);
		dataMap.put("notgetter",notgetter);
		dataMap.put("issuesuccess",issuesuccess);
		dataMap.put("issuenow",issuenow);
		return dataMap;
	}

	@Override
	public void registIssue(IssueVO issue) throws SQLException {
		int issue_number = issueDAO.selectIssueSeqNext();
		issue.setIssue_number(issue_number);
		issueDAO.insertIssue(issue);
		if (issue.getAttachList() != null)
			for (Issue_AttachVO attach : issue.getAttachList()) {
				attach.setIssue_number(issue_number);
				attach.setIssue_attach_attacher(issue.getIssue_setter_id());
				issue_attachDAO.insertIssue_Attach(attach);
			}
	}
	

	@Override
	public IssueVO selectIssue(int issue_number) throws SQLException {
		
		IssueVO issue = issueDAO.selectIssueByIssue_Number(issue_number);
		addAttachList(issue);
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
		cri.setMemberStatus(1);//내 리스트
		
		List<IssueVO>myissueList = issueDAO.selectSearchIssueList(cri);
		if(myissueList != null) {
			for(IssueVO issue : myissueList) {
				addAttachList(issue);				
			}
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(issueDAO.selectIssueCriteriaTotalCount(cri));
		dataMap.put("pageMaker",pageMaker);
		dataMap.put("myIssueList", myissueList);
		return dataMap;
	}
	
	@Override
	public Map<String, Object> selectGetterIssueList(SearchCriteria cri, HttpServletRequest request) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		HttpSession session = request.getSession(); 
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
//		SearchCriteria cri2 = cri.getNewCri(cri);
		cri.setMember_id(member.getMember_id());
		//cri.setMember_id("IdH");
		cri.setMemberStatus(2);
		
		List<IssueVO>getterIssueList = issueDAO.selectSearchIssueList(cri);
		if(getterIssueList != null) {
			for(IssueVO issue : getterIssueList) {
				addAttachList(issue);				
			}
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(issueDAO.selectIssueCriteriaTotalCount(cri));
		dataMap.put("pageMaker",pageMaker);
		dataMap.put("getterIssueList", getterIssueList);
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
	
	@Override
	public Issue_AttachVO getAttachByAno(int ano) throws SQLException {
		Issue_AttachVO attach = issue_attachDAO.selectIssue_AttachByAno(ano);

		return attach;
	}
	
}