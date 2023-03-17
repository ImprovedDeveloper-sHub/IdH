package com.sbs.IdH.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.UnitworkVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestUnitworkDAO {

   @Autowired
   private UnitworkDAO unitworkDAO;
   
   
   public void testSelectUnitwork() throws Exception{
      UnitworkVO unitwork = unitworkDAO.selectUnitwork(1);
      System.out.println(unitwork);
   }
   
   
   public void testSelectUnitworkList() throws Exception{
      
	  SearchCriteria cri = new SearchCriteria();
      List<UnitworkVO> unitworkList = unitworkDAO.selectSearchUnitworkList(cri);
      for(UnitworkVO unitwork : unitworkList) {
    	  System.out.println(unitwork);
      }
   }
   
  
   public void testInsertUnitworkList() throws Exception{
		  //UnitworkVO unitwork = new UnitworkVO(3, 0, "업무3",0, 1, "IdH","IdH", null, null);
	   
			/*
			 * Date date = new Date(); UnitworkVO unitwork = new
			 * UnitworkVO(3,0,"test",0,1,"IdH","detail",date,date);
			 * unitworkDAO.insertUnitwork(unitwork); UnitworkVO unitwork2 =
			 * unitworkDAO.selectUnitwork(3); System.out.println(unitwork2);
			 */
		 
   }
   
   public void testUnitwork_SEQ() throws Exception{
	   System.out.println(unitworkDAO.selectUnitworkSeqNext());
   }
   
   
   public void testupdateForProject() throws Exception{
	   UnitworkVO unitwork1 = unitworkDAO.selectUnitwork(1);
	   //unitworkDAO.updateUnitworkForProjectStart(unitwork1);
	   unitwork1 = unitworkDAO.selectUnitwork(1);
	   unitworkDAO.updateUnitworkForProjectEnd(unitwork1);
	   unitwork1 = unitworkDAO.selectUnitwork(1);
	   unitworkDAO.selectSearchUnitworkListForProject(1);
   }
  
   public void testDeleteUnitwork() throws Exception{
	   UnitworkVO unitwork1 = unitworkDAO.selectUnitwork(1);
	   unitworkDAO.deleteUnitwork(1);
	   UnitworkVO unitwork2 = unitworkDAO.selectUnitwork(1);
   }
   
   
   @Test
   public void testCount() throws Exception{
	   SearchCriteria cri = new SearchCriteria();
	   cri.setProject_number(1);
	   unitworkDAO.selectUnitworkCountForChart(cri);
	   
	   
   }
   
   
}