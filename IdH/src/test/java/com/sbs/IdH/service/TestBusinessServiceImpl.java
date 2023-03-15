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
import com.sbs.IdH.dto.BusinessVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestBusinessServiceImpl {
	
	@Resource(name="businessService")
	private BusinessService businessService;
	
	@Test
	public void testGetBusinessList() throws SQLException {
		
		SearchCriteria cri = new SearchCriteria();
		
		Map<String, Object> dataMap = businessService.getBusinessList(cri);
		
		List<BusinessVO> businessList = (List<BusinessVO>)dataMap.get("businessList");
		
		Assert.assertEquals(cri.getPerPageNum(), businessList.size());
		
	}
	
	@Test
	public void testGetBusiness() throws SQLException {
		
		int comparisonBusiness = 1;
		
		BusinessVO targetBusiness = businessService.getBusiness(comparisonBusiness);
		
		Assert.assertEquals(comparisonBusiness, targetBusiness.getBusiness_number());
		
	}
	
	/*
	@Test
	public void testGetBusinessForModify() throws SQLException {
		
		int comparisonBusiness = 1;
		
		BusinessVO targetBusiness = businessService.getBusinessForModify(comparisonBusiness);
		
		Assert.assertEquals(comparisonBusiness, targetBusiness.getBusiness_number());
		
	}
	*/
	
	@Test
	public void testRegist() throws SQLException {
		
		BusinessVO comparisonBusiness = new BusinessVO().setTestRegistBusiness();
		
		businessService.regist(comparisonBusiness);
		
		BusinessVO targetBusiness = businessService.getBusiness(comparisonBusiness.getBusiness_number());
		
		Assert.assertEquals(comparisonBusiness.getBusiness_name(), targetBusiness.getBusiness_name());
		
	}
	
	@Test
	public void testModify() throws SQLException {
		
		int comparisonBusiness = 1;
		
		BusinessVO targetBusiness = businessService.getBusiness(comparisonBusiness);
		targetBusiness.setBusiness_name("star_puls_test");
		targetBusiness.setBusiness_content("star_content_plus_test");
		
		businessService.modify(targetBusiness);
		BusinessVO makeBusiness = businessService.getBusiness(comparisonBusiness);
		
		Assert.assertEquals(targetBusiness.getBusiness_name(), makeBusiness.getBusiness_name());
		Assert.assertEquals(targetBusiness.getBusiness_content(), makeBusiness.getBusiness_content());
		
	}
	
	@Test
	public void testRemove() throws SQLException {
		
		int comparisonBusiness = 1;
		
		BusinessVO targetBusiness = businessService.getBusiness(comparisonBusiness);
		
		Assert.assertEquals(comparisonBusiness, targetBusiness.getBusiness_number());
		
		businessService.remove(targetBusiness.getBusiness_number());
		
	}
	
}
