package com.sbs.IdH.service;


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
public class TestScheduleService {

   @Autowired
   private ScheduleService scheduleService;
   
   
   public void testSelectSchedule() throws Exception{
      ScheduleVO schedule = scheduleService.selectSchedule(1);
      System.out.println(schedule);
   }
   
   
   public void testSelectScheduleList() throws Exception{
	  SearchCriteria cri = new SearchCriteria();
      scheduleService.selectScheduleList(cri);
      
   }
   
   @Test
   public void testInsertScheduleList() throws Exception{
		
		
		/*
		 * ScheduleVO schedule = new ScheduleVO(3, 0, "IdH", 1, "test", null,
		 * DateMaker.make(2023, 2, 10));
		 * 
		 * scheduleService.registSchedule(schedule);
		 * 
		 * scheduleService.selectSchedule(3);
		 */
	   
	/*	Date start = DateMaker.make(2023, 2, 20); Date end =
		  DateMaker.make(2023, 3, 10);
		  
		  schedule.setSchedule_regdate(start); schedule.setSchedule_enddate(end);
		  scheduleService.registSchedule(schedule);
		  
		  ScheduleVO schedule2 = scheduleService.selectSchedule(3);*/
		 
		 
   }
   
	  
	  
	  public void testupdateForSchedule() throws Exception{ 
			/*
			 * ScheduleVO schedule1 = scheduleService.selectSchedule(1);
			 * scheduleService.updateScheduleForScheduleStart(schedule1); schedule1 =
			 * scheduleService.selectSchedule(1);
			 * scheduleService.updateScheduleForScheduleEnd(schedule1); schedule1 =
			 * scheduleService.selectSchedule(1);
			 */
		}

		public void testDeleteSchedule() throws Exception {
			/*
			 * ScheduleVO schedule1 = scheduleService.selectSchedule(1);
			 * scheduleService.deleteSchedule(1); ScheduleVO schedule2 =
			 * scheduleService.selectSchedule(1);
			 */

	  }
	 
   
   
}