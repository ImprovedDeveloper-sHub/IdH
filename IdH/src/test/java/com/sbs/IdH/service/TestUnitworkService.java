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
import com.sbs.IdH.dto.UnitworkVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestUnitworkService {

   @Autowired
   private UnitworkService unitworkService;
   
   
   public void testSelectUnitwork() throws Exception{
      UnitworkVO unitwork = unitworkService.selectUnitwork(1);
      System.out.println(unitwork);
   }
   
   
   public void testSelectUnitworkList() throws Exception{
      
	  SearchCriteria cri = new SearchCriteria();
      unitworkService.selectUnitworkList(cri);
      
   }
   
   @Test
   public void testInsertUnitworkList() throws Exception{
		/*
		 * UnitworkVO unitwork = new UnitworkVO(3, 1, "test", 1, 1, "IdH", "test", null,
		 * null); //UnitworkVO unitwork = new UnitworkVO(3, "이름", null, null, 0, 1, 1,
		 * "IdH","test"); Date start = DateMaker.make(2023, 2, 20); Date end =
		 * DateMaker.make(2023, 3, 10);
		 * 
		 * unitwork.setUnitwork_regdate(start); unitwork.setUnitwork_enddate(end);
		 * unitworkService.registUnitwork(unitwork);
		 */
	   	  UnitworkVO unitwork2 = unitworkService.selectUnitwork(3);
		 
   }
   
	  
	  @Test
	  public void testupdateForUnitwork() throws Exception{ 
			/*
			 * UnitworkVO unitwork1 = unitworkService.selectUnitwork(1);
			 * unitworkService.updateUnitworkForUnitworkStart(unitwork1); unitwork1 =
			 * unitworkService.selectUnitwork(1);
			 * unitworkService.updateUnitworkForUnitworkEnd(unitwork1); unitwork1 =
			 * unitworkService.selectUnitwork(1);
			 */
		}

		public void testDeleteUnitwork() throws Exception {
			/*
			 * UnitworkVO unitwork1 = unitworkService.selectUnitwork(1);
			 * unitworkService.deleteUnitwork(1); UnitworkVO unitwork2 =
			 * unitworkService.selectUnitwork(1);
			 */

	  }
	 
   
   
}