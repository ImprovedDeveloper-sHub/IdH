package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException {
		
		int startRow = cri.getStartRowNum();
		int endRow = startRow + cri.getPerPageNum() - 1;

		Map<String, Object> dataParam = new HashMap<String, Object>();
		
		dataParam.put("startRow", startRow);
		dataParam.put("endRow", endRow);
		dataParam.put("searchType", cri.getSearchType());
		dataParam.put("keyword", cri.getKeyword());

		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList", dataParam);

		return noticeList;
		
	}
	
	@Override
	public int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException {
		
		int count = session.selectOne("Notice-Mapper.selectSearchNoticeListCount", cri);
		
		return count;
		
	}
	
	@Override
	public NoticeVO selectNotice_number(int notice_number) throws SQLException {
		
		NoticeVO notice = session.selectOne("Notice-Mapper.selectNotice_number", notice_number);
		
		return notice;
		
	}

	@Override
	public void increaseViewCount(int notice_number) throws SQLException {
		
		session.update("Notice-Mapper.increaseViewCount", notice_number);
		
	}

	@Override
	public int selectNoticeSequenceNextValue() throws SQLException {
		
		int seq_num = session.selectOne("Notice-Mapper.selectNoticeSequenceNextValue");
		
		return seq_num;
		
	}

	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		
		session.update("Notice-Mapper.insertNotice", notice);
		
	}

	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		
		session.update("Notice-Mapper.updateNotice", notice);
		
	}

	@Override
	public void deleteNotice(int notice_number) throws SQLException {
		
		session.update("Notice-Mapper.deleteNotice", notice_number);
		
	}
	
}
