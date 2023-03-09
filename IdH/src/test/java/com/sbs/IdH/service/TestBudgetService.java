package com.sbs.IdH.service;


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
public class TestBudgetService {

   @Autowired
   private BudgetService budgetService;
   
   
   
   public void testSelectBudget() throws Exception{
      BudgetVO budget = budgetService.selectBudget(1);
    
   }
   
   
   public void testSelectBudgetList() throws Exception{
	  budgetService.selectBudgetListforProject(1);
   }
   
	/*
	 * @Test public void testInsertBudgetList() throws Exception{ BudgetVO budget =
	 * new BudgetVO(3, 0, "1", 0, 1, "IdH"); budgetService.registBudget(budget);
	 * BudgetVO budget2 = budgetService.selectBudget(0); Assert.assertEquals(budget,
	 * budget2); }
	 */
   
   
   public void testupdateForProject() throws Exception{
	   
   }
   
   
   @Test
   public void testupdateBudget() throws Exception{
	  
   }
   
   
   public void testDeleteBudget() throws Exception{
	   
   }
   
   
   
}