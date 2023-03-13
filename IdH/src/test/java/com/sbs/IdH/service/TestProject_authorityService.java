package com.sbs.IdH.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestProject_authorityService {

	@Autowired
	private Project_authorityService project_authorityService;

//	@Test
//	public void selectProject_authority() throws Exception {
//		
//		Project_authorityVO project_authority = project_authorityService.selectProject_authority(1);
//		System.out.println(project_authority);
//	}

	@Test
	public void selectProject_authorityList() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		project_authorityService.selectProject_authorityList(cri);

	}
//
//
//	@Test
//	public void registProject_authority() throws Exception {
//
//		Project_authorityVO project_authority = new Project_authorityVO(2,2,1,"IdH");
//		project_authorityService.registProject_authority(project_authority);
//		Project_authorityVO project_authority2 = project_authorityService.selectProject_authority(2);
//
//	}
//
//	@Test
//	public void updateProject_authority() throws Exception {
//
//		Project_authorityVO project_authority1 = project_authorityService.selectProject_authority(1);
//		project_authorityService.modifyProject_authority(project_authority1);
//		project_authority1 = project_authorityService.selectProject_authority(2);
//
//	}
//
//	@Test
//	public void DeleteProject_authority() throws Exception {
//
//		Project_authorityVO project_authority1 = project_authorityService.selectProject_authority(1);
//		project_authorityService.removeProject_authority(1);
//		Project_authorityVO project_authority2 = project_authorityService.selectProject_authority(1);
//
//	}

}