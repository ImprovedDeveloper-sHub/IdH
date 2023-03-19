//package com.sbs.IdH.dao;
//
//
//
//import java.util.Calendar;
//import java.util.Date;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sbs.IdH.dto.RequireVO;
//
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
//@Transactional
//public class TestRequireDAO {
//
//   @Autowired
//   private RequireDAO requireDAO;
//   
////   @Test
////	public void getRequireList() throws Exception {
////		SearchCriteria cri = new SearchCriteria();
////		
////		List<RequireVO> requireList = requireDAO.selectSearchRequireList(cri);
////		Assert.assertEquals(1, requireList.size());
////	}
//   
//   
////   @Test
////   public void testGetMember() throws Exception{
////      //ProjectVO project = projectDAO.selectProject(0);
////      RequireVO require = requireDAO.selectRequire(1);
////      Assert.assertEquals(require);
////   }
////   
////   @Test
////	public void testSelectRequireListCount() throws Exception{
////		SearchCriteria cri = new SearchCriteria();
////		int count = requireDAO.selectSearchRequireListCount(cri);
////		Assert.notNull(count);
////	}
// @Test
// public void testInsertRequire() throws Exception {
//	 Calendar cal = Calendar.getInstance();
//	 RequireVO require = new RequireVO(2,2,"tt","tt",new Date(cal.getTimeInMillis()),"ssIdH","111","abcabc","abcabc",1,"IdH");
//     requireDAO.insertRequire(require); 
//     RequireVO require2 = requireDAO.selectRequire(2);
//           
//     Assert.assertEquals(require, require2);
// }
//
////	
////	@Test
////	public void testUpdateRequire() throws Exception{
////		RequireVO require = requireDAO.selectRequire( 1);
////		require.setRequire_title("test");
////		require.setRequire_detail("test");
////		require.setRequire_level(1);
////		require.setRequire_business("LMS");
////		require.setRequire_project("A");
////		require.setRequire_member_id("IdH");
////		require.setRequire_date(null);
////		require.setRequire_business_number(1);
////		require.setRequire_writer_id("abcabc");
////		requireDAO.updateRequire(require);
////		RequireVO testRequire= requireDAO.selectRequire(require.getRequire_number());
////		Assert.assertEquals(require.getRequire_title(), testRequire.getRequire_title());
////		Assert.assertEquals(require.getRequire_detail(), testRequire.getRequire_detail());
////
////	}
//
////	@Test
////	public void testDeleteRequire() throws Exception{
////		RequireVO require = requireDAO.selectRequire(1);
////		Assert.assertNotNull(require);
////		requireDAO.deleteRequire(require.getRequire_number());
////		RequireVO deleteRequire = requireDAO.selectRequire(require.getRequire_number());
////		Assert.assertNull(deleteRequire);
////	}
////   
//   
//   
//   
//}