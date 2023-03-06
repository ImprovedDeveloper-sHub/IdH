package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.dto.BusinessVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestBusinessDAOImpl {
	
	@Autowired
	private BusinessDAO businessDAO;
	
	@Test
	public void testSelectBusiness_number() throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(1);
		
		Assert.assertNotNull(business);
		
	}
	
	@Test
	public void testSelectBusiness_name() throws SQLException {
		
		List<BusinessVO> business = businessDAO.selectBusiness_name("star");
		
		for(BusinessVO businessVO : business) {
			System.out.println(businessVO);
		}
		
		/*
		List<BusinessVO> business = businessDAO.selectBusiness_name("PMS");
		
		for(BusinessVO businessVO : business) {
			Assert.assertEquals("PMS", businessVO.getBusiness_name());
		}
		*/
		
	}
	
	@Test
	public void testSelectBusiness_content() throws SQLException {
		
		List<BusinessVO> business = businessDAO.selectBusiness_content("star");
		
		for(BusinessVO businessVO : business) {
			System.out.println(businessVO);
		}
		
	}
	
	@Test
	public void testInsertBusiness() throws SQLException {
		
		BusinessVO registBusiness = new BusinessVO().setTestRegistBusiness();
		
		businessDAO.insertBusiness(registBusiness);
		
		BusinessVO getBusiness = businessDAO.selectBusiness_number(registBusiness.getBusiness_number());
		
		Assert.assertEquals(registBusiness.getBusiness_number(), getBusiness.getBusiness_number());
		
	}
	
	@Test
	public void testUpdateBusiness() throws SQLException {
		
		int targetBusiness_number = 1;
		
		BusinessVO targetBusiness = businessDAO.selectBusiness_number(targetBusiness_number);
		targetBusiness.setBusiness_name("star_puls_test");
		targetBusiness.setBusiness_content("star_content_plus_test");
		
		businessDAO.updateBusiness(targetBusiness);
		BusinessVO getBusiness = businessDAO.selectBusiness_number(targetBusiness_number);
		
		Assert.assertEquals(targetBusiness.getBusiness_name(), getBusiness.getBusiness_name());
		Assert.assertEquals(targetBusiness.getBusiness_content(), getBusiness.getBusiness_content());
		
	}
	
	/* 사업 기록 삭제 불가, 상태 변경 조치(사업 종료, 취소 등 상태메세지 표기)
	@Test
	public void testDeleteBusiness() throws SQLException {
		
		int targetBusiness_number = 1;
		
		BusinessVO targetBusiness = businessDAO.selectBusiness_number(targetBusiness_number);
		Assert.assertNotNull(targetBusiness);
		
		businessDAO.deleteBusiness(targetBusiness_number);
		
		BusinessVO getBusiness = businessDAO.selectBusiness_number(targetBusiness_number);
		Assert.assertNull(getBusiness);
		
	}
	*/
	
}
