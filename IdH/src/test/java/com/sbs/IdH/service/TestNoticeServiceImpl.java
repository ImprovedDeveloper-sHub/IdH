package com.sbs.IdH.service;

import java.sql.SQLException;
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



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestNoticeServiceImpl {
	
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@Test
	public void testGetNoticeList() throws SQLException {
		
		SearchCriteria cri = new SearchCriteria();
		
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		List<NoticeVO> noticeList = (List<NoticeVO>)dataMap.get("noticeList");
		
		Assert.assertEquals(cri.getPerPageNum(), noticeList);
		
	}
	
	@Test
	public void testGetNotice() throws SQLException {
		
		int comparisonNotice = 1;
		
		NoticeVO targetNotice = noticeService.getNotice(comparisonNotice);
		
		Assert.assertEquals(comparisonNotice, targetNotice.getNotice_number());
		
	}
	
	/*
	@Test
	public void testGetNoticeForModify() throws SQLException {
		
		int comparisonNotice = 1;
		
		NoticeVO targetNotice = noticeService.getNoticeForModify(comparisonNotice);
		
		Assert.assertEquals(comparisonNotice, targetNotice.getNotice_number());
		
	}
	*/
	
	@Test
	public void testRegist() throws SQLException {
		
		NoticeVO comparisonNotice = new NoticeVO();
		
		noticeService.regist(comparisonNotice);
		
		NoticeVO targetNotice = noticeService.getNotice(comparisonNotice.getNotice_number());
		
		Assert.assertEquals(comparisonNotice.getNotice_title(), targetNotice.getNotice_title());
		
	}
	
	@Test
	public void testModify() throws SQLException {
		
		NoticeVO updateNotice = noticeService.getNotice(1);
		updateNotice.setNotice_title("noticeModifyTest");
		updateNotice.setNotice_content("noticeContentModifyTest");
		
		noticeService.modify(updateNotice);
		NoticeVO targetNotice = noticeService.getNotice(1);
		
		Assert.assertEquals("noticeModifyTest", targetNotice.getNotice_title());
		Assert.assertEquals("noticeContentModifyTest", targetNotice.getNotice_content());
		
	}
	
	@Test
	public void testRemove() throws SQLException {
		
		noticeService.remove(1);
		
	}
	
}
