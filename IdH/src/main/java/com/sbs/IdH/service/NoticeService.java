package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.Map;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.NoticeVO;

public interface NoticeService {
	
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	public NoticeVO getNotice(int notice_number) throws SQLException;
	
	public NoticeVO getNoticeForModify(int notice_number) throws SQLException;
	
	public void regist(NoticeVO notice) throws SQLException;
	
	public void modify(NoticeVO notice) throws SQLException;
	
	public void remove(int notice_number) throws SQLException;
	
}
