package com.sbs.IdH.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ScheduleVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestScheduleDAO {

   @Autowired
   private ScheduleDAO scheduleDAO;
   
   
   public void testSelectSchedule() throws Exception{
      ScheduleVO schedule = scheduleDAO.selectSchedule(1);
      System.out.println(schedule);
   }
   
   @Test
   public void testSelectScheduleList() throws Exception{
      
	  SearchCriteria cri = new SearchCriteria();
      List<ScheduleVO> scheduleList = scheduleDAO.selectSearchScheduleList(cri);
      
      for(ScheduleVO schedule : scheduleList) {
    	  System.out.println(schedule);
      }
   }
   
   
   public void testInsertScheduleList() throws Exception{
	   
		/*
		 * ScheduleVO schedule = new ScheduleVO(2,0,null,null,1,"IdH");
		 * scheduleDAO.insertSchedule(schedule); ScheduleVO schedule2 =
		 * scheduleDAO.selectSchedule(3);
		 * 
		 * Assert.assertEquals(schedule, schedule2);
		 */
   }
   
   public void testSchedule_SEQ() throws Exception{
	   System.out.println(scheduleDAO.selectScheduleSeqNext());
   }
   
  
   public void testupdateForProject() throws Exception{
	   ScheduleVO schedule1 = scheduleDAO.selectSchedule(1);
	   scheduleDAO.updateScheduleForProjectStart(schedule1);
	   schedule1 = scheduleDAO.selectSchedule(1);
	   scheduleDAO.updateScheduleForProjectEnd(schedule1);
	   schedule1 = scheduleDAO.selectSchedule(1);
   }
   
   public void testDeleteSchedule() throws Exception{
	   ScheduleVO schedule1 = scheduleDAO.selectSchedule(1);
	   scheduleDAO.deleteSchedule(1);
	   ScheduleVO schedule2 = scheduleDAO.selectSchedule(1);
   }
   
   
   
}