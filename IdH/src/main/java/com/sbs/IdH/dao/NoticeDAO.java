package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.NoticeVO;

public interface NoticeDAO {
	
	public List<NoticeVO> selectSearchNoticeList(SearchCriteria cri) throws SQLException;
	
	public int selectSearchNoticeListCount(SearchCriteria cri) throws SQLException;
	
	public NoticeVO selectNotice_number(int notice_number) throws SQLException;
	
	public void increaseViewCount(int notice_number) throws SQLException;
	
	public int selectNoticeSequenceNextValue() throws SQLException;
	
	public void insertNotice(NoticeVO notice) throws SQLException;
	
	public void updateNotice(NoticeVO notice) throws SQLException;
	
	public void deleteNotice(int notice_number) throws SQLException;
	
}
