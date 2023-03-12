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
import com.sbs.IdH.dto.MinutesVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestMinutesDAO {

	@Autowired
	private MinutesDAO minutesDAO;
	
	
	

	@Test
	public void testGetminutes() throws Exception {
		// minutesVO minutes = minutesDAO.selectminutes(0);
		MinutesVO minutes = minutesDAO.selectMinutesByMinutes_Number(1);
		Assert.assertNotNull(minutes);
	}

	@Test
	public void testSelectSearchminutesList() {
		SearchCriteria cri = new SearchCriteria();
	      List<MinutesVO> minutesList = minutesDAO.selectSearchMinutesList(cri);

	      for(MinutesVO minutes : minutesList) {
	    	  System.out.println(minutes);
	      }
	}
	
//	@Test
//	public void testInsertminutes() throws Exception {
//		MinutesVO minutes = new MinutesVO(3,"tt","tt",2,null,"IdH",1,"abcabc");
//		minutesDAO.insertMinutes(minutes);
//				 
//				 
//	}
	@Test
	public void testInsertminutes() throws Exception {
		MinutesVO minutes = new MinutesVO(2,"tt",null,"test","IdH",1);
		minutesDAO.insertMinutes(minutes);
	}
	
	@Test
	public void testDeleteminutes()throws Exception{
		minutesDAO.deleteMinutes(1);
	}
}