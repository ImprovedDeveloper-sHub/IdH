package com.sbs.IdH.service;


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
public class TestProjectService {

   @Autowired
   private ProjectService projectService;
   
   
   public void testSelectProject() throws Exception{
      ProjectVO project = projectService.selectProject(1);
      System.out.println(project);
   }
   
   @Test
   public void testSelectProjectList() throws Exception{
	  SearchCriteria cri = new SearchCriteria();
	  cri.setStatus(1);
	  cri.setSearchType("n");
	  cri.setKeyword("asd");
      projectService.selectProjectList(cri);
      
   }
   
   
   public void testSelectProceedingProject() throws Exception{
	   SearchCriteria cri = new SearchCriteria();
	   projectService.selectProceedingProject(cri);
   }
   
   
   public void testInsertProjectList() throws Exception{
		/*
		 * ProjectVO project = new ProjectVO(3, "이름", null, null, 0, 1, 1,
		 * "IdH","test"); projectService.registProject(project); ProjectVO project2 =
		 * projectService.selectProject(3);
		 */
		 
   }
   
	  
	  
	  public void testupdateForProject() throws Exception{ 
			/*
			 * ProjectVO project1 = projectService.selectProject(1);
			 * projectService.updateProjectForProjectStart(project1); project1 =
			 * projectService.selectProject(1);
			 * projectService.updateProjectForProjectEnd(project1); project1 =
			 * projectService.selectProject(1);
			 */
		}

		public void testDeleteProject() throws Exception {
			/*
			 * ProjectVO project1 = projectService.selectProject(1);
			 * projectService.deleteProject(1); ProjectVO project2 =
			 * projectService.selectProject(1);
			 */

	  }
	 
   
   
}