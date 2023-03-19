package com.sbs.IdH.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.WorkforceVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestWorkforceDAO {

   @Autowired
   private WorkforceDAO workforceDAO;
   
   
   public void testSelectWorkforce() throws Exception{
      WorkforceVO workforce = workforceDAO.selectWorkforce(1);
      System.out.println(workforce);
   }
   
   
   public void testSelectWorkforceList() throws Exception{
      
	  SearchCriteria cri = new SearchCriteria();
      List<WorkforceVO> workforceList = workforceDAO.selectSearchWorkforceList(cri);
      for(WorkforceVO workforce : workforceList) {
    	  System.out.println(workforce);
      }
   }
   
   
	/*
	 * public void testInsertWorkforceList() throws Exception{ WorkforceVO workforce
	 * = new WorkforceVO(3,0,1,"detail","IdH");
	 * workforceDAO.insertWorkforce(workforce); WorkforceVO workforce2 =
	 * workforceDAO.selectWorkforce(3);
	 * 
	 * Assert.assertEquals(workforce, workforce2);
	 * 
	 * }
	 */
   public void testWorkforce_SEQ() throws Exception{
	   System.out.println(workforceDAO.selectWorkforceSeqNext());
   }
   
   
   public void testupdateForProject() throws Exception{
	   WorkforceVO workforce1 = workforceDAO.selectWorkforce(1);
	   //workforceDAO.updateWorkforceForProjectStart(workforce1);
	   workforce1 = workforceDAO.selectWorkforce(1);
	   workforceDAO.updateWorkforceForProjectEnd(workforce1);
	   workforce1 = workforceDAO.selectWorkforce(1);
	   workforceDAO.selectSearchWorkforceListForProject(1);
   }
   @Test
   public void testDeleteWorkforce() throws Exception{
	   WorkforceVO workforce1 = workforceDAO.selectWorkforce(1);
	   workforceDAO.deleteWorkforce(1);
	   WorkforceVO workforce2 = workforceDAO.selectWorkforce(1);
   }
   
   
   
}