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
import com.sbs.IdH.dto.WorkreportVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestWorkreportDAO {

	@Autowired
	private WorkreportDAO workreportDAO;


	@Test
	public void testGetworkreport() throws Exception {
		// workVO work = workDAO.selectwork(0);
		WorkreportVO workreport = workreportDAO.selectWorkreportByWorkreport_Number(1);
		Assert.assertNotNull(workreport);
	}

	@Test
	public void testSelectSearchworkList() {
		SearchCriteria cri = new SearchCriteria();
	      List<WorkreportVO> workreportList = workreportDAO.selectSearchWorkreportList(cri);

	      for(WorkreportVO workreport : workreportList) {
	    	  System.out.println(workreport);
	      }
	}
	
//	@Test
//	public void testInsertwork() throws Exception {
//		WorkVO work = new WorkVO(3,"tt","tt",2,null,"IdH",1,"abcabc");
//		workDAO.insertWork(work);
//				 
//				 
//	}
//	@Test
//	public void testInsertwork() throws Exception {
//		WorkVO work = new WorkVO(2,1,"IdH",1,null,null,"abcabc");
//		workDAO.insertWork(work);
//	}
//	
//	@Test
//	public void testDeletework()throws Exception{
//		workDAO.deleteWork(1);
//	}
}