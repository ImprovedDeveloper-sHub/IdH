package com.sbs.IdH.service; 

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.IssueDAO;
import com.sbs.IdH.dao.Issue_AttachDAO;
import com.sbs.IdH.dao.ProjectDAO;
import com.sbs.IdH.dto.ChartVO;
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

	
	private ProjectDAO projectDAO;
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
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
	
	
	@Override
	public ChartVO selectChart(int project_number) throws Exception {

		HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		HashMap<String, Object> rowMap_c3 = new HashMap<String, Object>();
		
		SearchCriteria cri = new SearchCriteria();
		cri.setProject_number(project_number);
		//총이슈
		List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		c0_list_label.put("v", "총 이슈 개수");
		c0_list.add(c0_list_label);
		c0_list.add(issueDAO.selectIssueCountForChart(cri));
		
		//완료이슈
		cri.setStatus(1);
		List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		c1_list_label.put("v", "완료이슈");
		c1_list.add(c1_list_label);
		c1_list.add(issueDAO.selectIssueCountForChart(cri));
		
		//미완료 이슈
		cri.setType(2);
		List<Map<String,Object>> c2_list = new ArrayList<Map<String,Object>>();
		HashMap<String, Object> c2_list_label = new HashMap<String, Object>();
		c2_list_label.put("v", "미완료 이슈");
		c2_list.add(c2_list_label);
		c2_list.add(issueDAO.selectIssueCountForChart(cri));
		
		
		rowMap_c1.put("c", c0_list);
		rowMap_c2.put("c", c1_list);
		rowMap_c3.put("c", c2_list);
		
		ChartVO chart = new ChartVO();
		chart.issueColSet();
		chart.rowSet(rowMap_c1);
		chart.rowSet(rowMap_c2);
		chart.rowSet(rowMap_c3);
		
		chart.resultSet();
		return chart;
	}
	
	
	@Override
	public ChartVO selectChartForComparison(int project_number1, int project_number2) throws Exception {
		
		
		  HashMap<String, Object> rowMap_c1 = new HashMap<String, Object>();
		  HashMap<String, Object> rowMap_c2 = new HashMap<String, Object>();
		  
		  
		  SearchCriteria cri = new SearchCriteria();
		  cri.setProject_number(project_number1); 
		  List<Map<String,Object>> c0_list = new ArrayList<Map<String,Object>>();
		  HashMap<String, Object> c0_list_label = new HashMap<String, Object>();
		  
		  c0_list_label.put("v", projectDAO.selectProject(project_number1).getProject_name());
		  c0_list.add(c0_list_label);
		  c0_list.add(issueDAO.selectIssueCountForChart(cri));
		  
		  
		  
		  
		  
		  cri.setProject_number(project_number2);
		  List<Map<String,Object>> c1_list = new ArrayList<Map<String,Object>>();
		  HashMap<String, Object> c1_list_label = new HashMap<String, Object>();
		  c1_list_label.put("v", projectDAO.selectProject(project_number2).getProject_name());
		  c1_list.add(c1_list_label);
		  c1_list.add(issueDAO.selectIssueCountForChart(cri));
		  
		  rowMap_c1.put("c", c0_list);
		  rowMap_c2.put("c", c1_list);
		  
		  ChartVO chart = new ChartVO();
		  chart.budgetColSet();
		  chart.rowSet(rowMap_c1);
		  chart.rowSet(rowMap_c2);
		  chart.resultSet(); return chart;
		 
	}
}