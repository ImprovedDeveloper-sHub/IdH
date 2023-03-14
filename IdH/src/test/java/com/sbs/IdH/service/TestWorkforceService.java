package com.sbs.IdH.service;


import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.DateMaker;
import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkforceVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestWorkforceService {

   @Autowired
   private WorkforceService workforceService;
   
   
   public void testSelectWorkforce() throws Exception{
      WorkforceVO workforce = workforceService.selectWorkforce(1);
      System.out.println(workforce);
   }
   
   
   public void testSelectWorkforceList() throws Exception{
	  SearchCriteria cri = new SearchCriteria();
      workforceService.selectWorkforceList(cri);
      
   }
   
   @Test
   public void testInsertWorkforceList() throws Exception{
		
		/*
		 * WorkforceVO workforce = new WorkforceVO(3,1,1,"test","IdH");
		 * 
		 * workforceService.registWorkforce(workforce);
		 * 
		 * workforceService.selectWorkforce(3);
		 */
	   
	/*	Date start = DateMaker.make(2023, 2, 20); Date end =
		  DateMaker.make(2023, 3, 10);
		  
		  workforce.setWorkforce_regdate(start); workforce.setWorkforce_enddate(end);
		  workforceService.registWorkforce(workforce);
		  
		  WorkforceVO workforce2 = workforceService.selectWorkforce(3);*/
		 
		 
   }
   
	  
	  
	  public void testupdateForWorkforce() throws Exception{ 
			/*
			 * WorkforceVO workforce1 = workforceService.selectWorkforce(1);
			 * workforceService.updateWorkforceForWorkforceStart(workforce1); workforce1 =
			 * workforceService.selectWorkforce(1);
			 * workforceService.updateWorkforceForWorkforceEnd(workforce1); workforce1 =
			 * workforceService.selectWorkforce(1);
			 */
		}

		public void testDeleteWorkforce() throws Exception {
			/*
			 * WorkforceVO workforce1 = workforceService.selectWorkforce(1);
			 * workforceService.deleteWorkforce(1); WorkforceVO workforce2 =
			 * workforceService.selectWorkforce(1);
			 */

	  }
	 
   
   
}