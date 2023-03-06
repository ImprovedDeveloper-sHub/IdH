package com.sbs.IdH.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MinutisVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestMinutisDAO {

	@Autowired
	private MinutisDAO minutisDAO;
	
	
	

	@Test
	public void testGetminutis() throws Exception {
		// minutisVO minutis = minutisDAO.selectminutis(0);
		MinutisVO minutis = minutisDAO.selectMinutisByMinutis_Number(1);
		Assert.assertNotNull(minutis);
	}

	@Test
	public void testSelectSearchminutisList() {
		SearchCriteria cri = new SearchCriteria();
	      List<MinutisVO> minutisList = minutisDAO.selectSearchMinutisList(cri);

	      for(MinutisVO minutis : minutisList) {
	    	  System.out.println(minutis);
	      }
	}
	
//	@Test
//	public void testInsertminutis() throws Exception {
//		MinutisVO minutis = new MinutisVO(3,"tt","tt",2,null,"IdH",1,"abcabc");
//		minutisDAO.insertMinutis(minutis);
//				 
//				 
//	}
	@Test
	public void testInsertminutis() throws Exception {
		MinutisVO minutis = new MinutisVO(2,"tt",null,"test","IdH",1);
		minutisDAO.insertMinutis(minutis);
	}
	
	@Test
	public void testDeleteminutis()throws Exception{
		minutisDAO.deleteMinutis(1);
	}
}