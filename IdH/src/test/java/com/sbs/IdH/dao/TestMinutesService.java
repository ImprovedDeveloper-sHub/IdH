package com.sbs.IdH.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.MinutesVO;
import com.sbs.IdH.service.MinutesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestMinutesService {

	@Autowired
	   private MinutesService minutesService;


	   @Test
	   public void testSelectMinutes() throws SQLException{
		   minutesService.selectMinutes(1);

	   }

	   @Test 
	   public void testSelectMinutesList() throws SQLException{
		   SearchCriteria cri = new SearchCriteria();
		   minutesService.selectMinutesList(cri);
	   }

	   @Test
	   public void testInsertMinutesList() throws SQLException{
		   MinutesVO minutes =  new MinutesVO(2,"tt",null,"test","IdH",1);
		   minutesService.registMinutes(minutes);
	   }
}