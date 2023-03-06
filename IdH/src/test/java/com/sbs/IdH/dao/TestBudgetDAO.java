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
import com.sbs.IdH.dto.BudgetVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestBudgetDAO {

   @Autowired
   private BudgetDAO budgetDAO;
   
  
   public void testSelectBudget() throws Exception{
      BudgetVO budget = budgetDAO.selectBudget(1);
   }
   
  
   public void testSelectBudgetList() throws Exception{
	  SearchCriteria cri = new SearchCriteria();
      List<BudgetVO> budgetList = budgetDAO.selectSearchBudgetList(cri);
      
      for(BudgetVO budget : budgetList) {
    	  System.out.println(budget);
      }
   }
   
   
   public void testInsertBudgetList() throws Exception{
	   BudgetVO budget =  new BudgetVO(3, 0, "1", 0, 1, "IdH");
	   budgetDAO.insertBudget(budget);
	   BudgetVO budget2 = budgetDAO.selectBudget(3);
	   
	   Assert.assertEquals(budget, budget2);
   }
   
   public void testBudget_SEQ() throws Exception{
	   System.out.println(budgetDAO.selectBudgetSeqNext());
   }
   
  
   public void testupdateForProject() throws Exception{
	   BudgetVO budget1 = budgetDAO.selectBudget(1);
	   budgetDAO.updateBudgetForProjectStart(budget1);
	   budget1 = budgetDAO.selectBudget(1);
	   budgetDAO.updateBudgetForProjectEnd(budget1);
	   budget1 = budgetDAO.selectBudget(1);
   }
   
   
   @Test
   public void testupdateBudget() throws Exception{
	   BudgetVO budget = budgetDAO.selectBudget(1);
	   budget.setBudget_price(10000);
	   budget.setBudget_detail("예산변경 테스트");
	   budgetDAO.updateBudget(budget);
	   budget = budgetDAO.selectBudget(1);
   }
   
   
   public void testDeleteBudget() throws Exception{
	   BudgetVO budget1 = budgetDAO.selectBudget(1);
	   budgetDAO.deleteBudget(1);
	   BudgetVO budget2 = budgetDAO.selectBudget(1);
   }
   
   
   
}