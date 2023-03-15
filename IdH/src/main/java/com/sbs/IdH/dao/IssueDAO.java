package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;

public interface IssueDAO {
	List<IssueVO> selectSearchIssueList(SearchCriteria cri);

	int selectSearchIssueListCount(SearchCriteria cri);

	IssueVO selectIssueByIssue_Number(int issue_number) throws SQLException;

	public void insertIssue(IssueVO issue);

	public void updateIssue(IssueVO issue);

	public void deleteIssue(int issue_number);

	public int selectIssueCriteriaTotalCount(SearchCriteria cri);

	public int selectNotGetterIssueCount();

	public int selectGetterIssueCount();

	public int selectIssueTotalCount();
	
	//추가
	Map<String,Object> selectIssueCountForChart(SearchCriteria cri)throws SQLException;

	
	
}
