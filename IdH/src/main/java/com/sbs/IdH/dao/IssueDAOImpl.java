package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;

public class IssueDAOImpl implements IssueDAO{

	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public IssueVO selectIssueByIssue_Number(int issue_number) throws SQLException {
		IssueVO issue = session.selectOne("Issue-Mapper.selectIssueByIssue_Number",issue_number);
		return issue;
	}

	@Override
	public List<IssueVO> selectSearchIssueList(SearchCriteria cri) {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<IssueVO> issueList = session.selectList("Issue-Mapper.selectSearchIssueList",cri,rowBounds);
		return issueList;
	}

	@Override
	public int selectSearchIssueListCount(SearchCriteria cri) {
		int issueListCount = session.selectOne("Issue-Mapper.selectSearchIssueListCount",cri);
		return issueListCount;
	}

	@Override
	public void insertIssue(IssueVO issue) {
		session.update("Issue-Mapper.insertIssue",issue);
		
	}

	@Override
	public void updateIssue(IssueVO issue) {
		session.update("Issue-Mapper.updateIssue",issue);
		
	}

	@Override
	public void deleteIssue(int issue_number) {
		session.update("Issue-Mapper.deleteIssue",issue_number);
		
	}

	@Override
	public int selectIssueCriteriaTotalCount(SearchCriteria cri) {
		int count = session.selectOne("Issue-Mapper.selectSearchIssueListCount",cri);
		return count;
	}

	@Override
	public int selectNotGetterIssueCount() {
		int count = session.selectOne("Issue-Mapper.selectNotGetterIssueCount");
		return count;
	}

	@Override
	public int selectGetterIssueCount() {
		int count = session.selectOne("Issue-Mapper.selectGetterIssueCount");
		return count;
	}

	@Override
	public int selectIssueTotalCount() {
		int total = session.selectOne("Issue-Mapper.selectSearchIssueCount");
		return total;
	}

	@Override
	public int selectIssueSeqNext() throws SQLException {
		int issue_number = session.selectOne("Issue-Mapper.selectIssueSeqNext");
		return issue_number;
	}
	
	@Override
	public Map<String, Object> selectIssueCountForChart(SearchCriteria cri) throws SQLException {
		Map<String,Object> colMap = new HashMap<String, Object>();
		int issue_count = session.selectOne("Issue-Mapper.selectSearchIssueListCount", cri);
		colMap.put("v",issue_count);
		return colMap;
	}

	
}
