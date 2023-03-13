package com.sbs.IdH.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.dto.BusinessVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestBusinessDAOImpl {
	
	@Resource(name="businessDAO")
	private BusinessDAO businessDAO;
	
	@Test
	public void testSelectBusiness_number() throws SQLException {
		
		BusinessVO business = businessDAO.selectBusiness_number(1);
		
		Assert.assertEquals("1", business.getBusiness_name());
		
	}
	
	@Test
	public void testSelectBusiness_name() throws SQLException {
		
		List<BusinessVO> business = businessDAO.selectBusiness_name("1");
		
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
		
		List<BusinessVO> business = businessDAO.selectBusiness_content("1");
		
		for(BusinessVO businessVO : business) {
			System.out.println(businessVO);
		}
		
	}
	
	/*
	@Test
	public void testSelectBusinessSequenceNextValue() throws SQLException {
		
		BusinessVO business = new BusinessVO().setTestRegistBusiness();
		
		Assert.assertEquals(9999, business.getBusiness_number());
		
	}
	*/
	
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
	
	@Test
	public void testDeleteBusiness() throws SQLException {
		
		int targetBusiness_number = 1;
		
		BusinessVO targetBusiness = businessDAO.selectBusiness_number(targetBusiness_number);
		Assert.assertEquals(targetBusiness_number, targetBusiness.getBusiness_number());
		
		businessDAO.deleteBusiness(targetBusiness_number);
		
	}
	
}
