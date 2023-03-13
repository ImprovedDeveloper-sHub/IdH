package com.sbs.IdH.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestMenuService {

   @Autowired
   private MenuService menuService;
   
   
   @Test
   public void testSelectMenu() throws Exception{
     
	   menuService.getMainMenuList();
	  
    
   }
   
   
   
   
}