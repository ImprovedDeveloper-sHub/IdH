package com.sbs.IdH.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sbs.IdH.command.PageMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.NoticeDAO;
import com.sbs.IdH.dao.Notice_attachDAO;
import com.sbs.IdH.dto.NoticeVO;
import com.sbs.IdH.dto.Notice_attachVO;
import com.sbs.IdH.dto.Require_attachVO;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;
	private Notice_attachDAO notice_attachDAO;
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	public void setNotice_attachDAO(Notice_attachDAO notice_attachDAO) {
		this.notice_attachDAO = notice_attachDAO;
	}
	
	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);

		if (noticeList != null)
			for (NoticeVO notice : noticeList)
				addAttachList(notice);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeDAO.selectSearchNoticeListCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
		
	}

	@Override
	public NoticeVO getNotice(int notice_number) throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNotice_number(notice_number);
		
		noticeDAO.increaseViewCount(notice_number);
		addAttachList(notice);
		
		return notice;
		
	}

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		
		int notice_number = noticeDAO.selectNoticeSequenceNextValue();

		notice.setNotice_number(notice_number);
		noticeDAO.insertNotice(notice);

		if (notice.getNotice_attachList() != null)
			for (Notice_attachVO attach : notice.getNotice_attachList()) {
				attach.setnotice_number(notice_number);
				attach.setNotice_attach_attacher(notice.getNotice_member_id());
				notice_attachDAO.insertNotice_attach(attach);
			}
		
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		
		noticeDAO.updateNotice(notice);
		notice_attachDAO.deleteAllNotice_attach(notice.getNotice_number());

		if (notice.getNotice_attachList() != null)
			for (Notice_attachVO attach : notice.getNotice_attachList()) {
				attach.setnotice_number(notice.getNotice_number());
				attach.setNotice_attach_attacher(notice.getNotice_member_id());
				notice_attachDAO.insertNotice_attach(attach);

			}
	}

	@Override
	public void remove(int notice_number) throws SQLException {
		
		noticeDAO.deleteNotice(notice_number);
		
	}
	
	@Override
	public Notice_attachVO getNotice_attachByAno(int ano) throws SQLException {
		
		Notice_attachVO attach = notice_attachDAO.selectAttachByAno(ano);

		return attach;
	}

	@Override
	public void removeNotice_attach_Ano(int ano) throws SQLException {

		notice_attachDAO.deleteNotice_attach(ano);
		
	}
	
	private void addAttachList(NoticeVO notice) throws SQLException {
		
		if (notice == null)
			return;
		
		int notice_attach_number = notice.getNotice_number();
		List<Notice_attachVO> attachList = notice_attachDAO.selectNotice_attachsByNotice_number(notice_attach_number);
		
		notice.setNotice_attachList(attachList);
	}

}
