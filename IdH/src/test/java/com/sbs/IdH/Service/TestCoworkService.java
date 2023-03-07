package com.sbs.IdH.Service;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CoworkVO;
import com.sbs.IdH.service.CoworkService;

	

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
	@Transactional
	public class TestCoworkService {

	   @Autowired
	   private CoworkService coworkService;
	   
	   
	   @Test
	   public void testSelectCowork() throws SQLException{
		   CoworkVO cowork = coworkService.selectCowork(1);
	    
	   }
	   
	   @Test 
	   public void testSelectCoworkList() throws SQLException{
		   SearchCriteria cri = new SearchCriteria();
		   coworkService.selectCoworkList(cri);
	   }
	   
	   @Test
	   public void testInsertCoworkList() throws SQLException{
		   CoworkVO cowork =  new CoworkVO(2,null,null,"abc",1,"IdH",1);
		   coworkService.registCowork(cowork);
	   }
	   
	
		  @Test public void testupdateCowork() throws SQLException{
		  
			  CoworkVO cowork = coworkService.selectCowork(1);
			  coworkService.modifyCowork(cowork); 
			  cowork =
					  coworkService.selectCowork(1);
				
		  }
		 
			/*
			 * @Test public void testDeleteCowork() throws Exception{
			 * 
			 * }
			 */
		 
	   
	   
	}

