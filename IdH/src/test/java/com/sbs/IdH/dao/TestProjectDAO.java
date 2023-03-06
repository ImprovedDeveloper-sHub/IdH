package com.sbs.IdH.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.ProjectVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestProjectDAO {

   @Autowired
   private ProjectDAO projectDAO;
   
   
   public void testSelectProject() throws Exception{
      ProjectVO project = projectDAO.selectProject(1);
      System.out.println(project);
   }
   
   
   public void testSelectProjectList() throws Exception{
      
	  SearchCriteria cri = new SearchCriteria();
      List<ProjectVO> projectList = projectDAO.selectSearchProjectList(cri);
      
      
   }
   
   
   public void testInsertProjectList() throws Exception{
		/*
		 * ProjectVO project = new ProjectVO(3, "이름", null, null, 0, 1, 1, "IdH",
		 * "test"); projectDAO.insertProject(project); ProjectVO project2 =
		 * projectDAO.selectProject(3);
		 */
		 
   }
   
   public void testProject_SEQ() throws Exception{
	   System.out.println(projectDAO.selectProjectSeqNext());
   }
   
   @Test
   public void testupdateForProject() throws Exception{
	   ProjectVO project1 = projectDAO.selectProject(1);
	   projectDAO.updateProjectForProjectStart(project1);
	   project1 = projectDAO.selectProject(1);
	   projectDAO.updateProjectForProjectEnd(project1);
	   project1 = projectDAO.selectProject(1);
   }
   
   public void testDeleteProject() throws Exception{
	   ProjectVO project1 = projectDAO.selectProject(1);
	   projectDAO.deleteProject(1);
	   ProjectVO project2 = projectDAO.selectProject(1);
   }
   
   
   
}