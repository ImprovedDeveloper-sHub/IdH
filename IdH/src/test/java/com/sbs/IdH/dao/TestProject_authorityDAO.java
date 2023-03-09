package com.sbs.IdH.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.dto.Project_authorityVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestProject_authorityDAO {

	@Autowired
	private Project_authorityDAO project_authorityDAO;

//	@Test
//	public void getMemberList() throws Exception {
//		SearchCriteria cri = new SearchCriteria(1, 100, "p", "0");
//
//		List<MemberVO> memberList = memberDAO.selectSearchMemberList(cri);
//
//		Assert.assertEquals(2, memberList.size());
//	}

   @Test
   public void testGetProject_authority() throws Exception{
	   int id = 1;		
		
	   Project_authorityVO project_authority = project_authorityDAO.selectProject_authority(id);
		
		Assert.assertEquals(id, project_authority.getProject_authority_number());
   }
//   
// @Test
// public void testInsertProject_authority() throws Exception {
//	 Project_authorityVO project_authority = new Project_authorityVO(2,2,1,"abcabc");
//	 project_authorityDAO.insertProject_authority(project_authority); 
//	 Project_authorityVO project_authority2 = project_authorityDAO.selectProject_authority(2);
//           
//     Assert.assertEquals(project_authority, project_authority2);
// }
//
//	
//	@Test
//	public void testUpdateProject_authority() throws Exception{
//		int targetNum = 1;
//		
//		Project_authorityVO targetproject_authority = project_authorityDAO.selectProject_authority(targetNum);
//		targetproject_authority.setProject_authority_status(2);
//		
//		project_authorityDAO.updateProject_authority(targetproject_authority);
//		Project_authorityVO getProject_authority = project_authorityDAO.selectProject_authority(targetNum);
//		
//		Assert.assertEquals(targetproject_authority.getProject_authority_status(), getProject_authority.getProject_authority_status());		
//	}

	
//
//	@Test
//	public void testDeleteProject_authority() throws Exception{
//		int target = 1;
//		
//		Project_authorityVO deleteProject_authority = project_authorityDAO.selectProject_authority(1);
//		Assert.assertNotNull(deleteProject_authority);
//		
//		project_authorityDAO.deleteProject_authority(target);
//		
//		Project_authorityVO getProject_authority = project_authorityDAO.selectProject_authority(1);
//		Assert.assertNull(getProject_authority);
//	}

}