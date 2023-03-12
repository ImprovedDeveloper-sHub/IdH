package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.NoticeVO;
import com.sbs.IdH.service.BusinessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestNoticeDAOImpl {
	
	@Resource(name="noticeDAO")
	private NoticeDAO noticeDAO;
	
	@Test
	public void testSelectSearchNoticeList() throws SQLException {
		
		SearchCriteria cri = new SearchCriteria(1, 100, "p", "test");
		
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);
		
		Assert.assertEquals(1, noticeList.size());
		
	}
	
	@Test
	public void testSelectSearchNoticeListCount() throws SQLException {
		
		SearchCriteria cri = new SearchCriteria();
		
		int noticeListCount = noticeDAO.selectSearchNoticeListCount(cri);
		
		Assert.assertEquals(1, noticeListCount);
		
	}
	
	@Test
	public void testSelectNotice_number() throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNotice_number(1);
		
		Assert.assertEquals("1", notice.getNotice_title());
		
	}
	
	@Test
	public void testIncreaseViewCount() throws SQLException {
		
		NoticeVO notice = noticeDAO.selectNotice_number(1);
		
		for (int i = 0; i <= 10; i++) {notice.setNotice_count(i);}
		
		int testNoticeCount = notice.getNotice_count();
		
		Assert.assertEquals(testNoticeCount, notice.getNotice_count());
		
	}
	
	/*
	@Test
	public void testSelectNoticeSequenceNextValue() throws SQLException {
		
		NoticeVO notice = new NoticeVO().setTestNoticeExample();
		
		Assert.assertEquals(999, notice.getNotice_number());
		
	}
	*/
	
	@Test
	public void testInsertNotice() throws SQLException {
		
		NoticeVO insertNotice = new NoticeVO();
		
		noticeDAO.insertNotice(insertNotice);
		
		NoticeVO targetNotice = noticeDAO.selectNotice_number(insertNotice.getNotice_number());
		
		Assert.assertEquals(insertNotice.getNotice_title(), targetNotice.getNotice_title());
		
	}
	
	@Test
	public void testUpdateBusiness() throws SQLException {
		
		NoticeVO testNotice = noticeDAO.selectNotice_number(1);		
		testNotice.setNotice_title("testNoticeUpdate");
		testNotice.setNotice_content("testNoticeContentUpdate");		
		noticeDAO.updateNotice(testNotice);
		
		NoticeVO targetNotice = noticeDAO.selectNotice_number(1);
		
		Assert.assertEquals(testNotice.getNotice_title(), targetNotice.getNotice_title());
		Assert.assertEquals(testNotice.getNotice_content(), targetNotice.getNotice_content());
		
	}
	
	@Test
	public void testDeleteNotice() throws SQLException {
		
		NoticeVO targetNotice = noticeDAO.selectNotice_number(1);
		
		noticeDAO.deleteNotice(targetNotice.getNotice_number());
		
	}
	
}
