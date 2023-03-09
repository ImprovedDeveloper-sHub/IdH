package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.NoticeDAO;
import com.sbs.IdH.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);
		
		int totalCount = noticeDAO.selectSearchNoticeListCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
	}

	@Override
	public NoticeVO getNotice(int notice_number) throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNotice_number(notice_number);
		
		noticeDAO.increaseViewCount(notice_number);
		
		return notice;
		
	}
	
	/*
	@Override
	public NoticeVO getNoticeForModify(int notice_number) throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNotice_number(notice_number);
		
		return notice;
		
	}
	*/

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		
		int notice_number = noticeDAO.selectNoticeSequenceNextValue();
		
		notice.setNotice_number(notice_number);
		
		noticeDAO.insertNotice(notice);
		
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		
		noticeDAO.updateNotice(notice);
		
	}

	@Override
	public void remove(int notice_number) throws SQLException {
		
		noticeDAO.deleteNotice(notice_number);
		
	}

}
