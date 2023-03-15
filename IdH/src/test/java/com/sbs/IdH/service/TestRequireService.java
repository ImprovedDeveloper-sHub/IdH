package com.sbs.IdH.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.dto.RequireVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestRequireService {

	@Autowired
	private RequireService requireService;
	
//	@Test
//	public void SelectRequire() throws Exception {
//		
//		RequireVO require = requireService.selectRequire(1);
//		System.out.println(require);
//	}

//	@Test
//	public void SelectRequireList() throws Exception {
//		SearchCriteria cri = new SearchCriteria();
//		requireService.selectRequireList(cri);
//
//	}
//
//
//	@Test
//	public void insertRequire() throws Exception {
//
//		RequireVO require = new RequireVO(2,2,"tt","tt",null,"ssIdH","111","abcabc","abcabc",1,"IdH");
//		requireService.registRequire(require);
//		RequireVO require2 = requireService.selectRequire(2);
//
//	}
//
	@Test
	public void updateForRequire() throws Exception {

		RequireVO require1 = requireService.selectRequire(1);
		requireService.modifyRequire(require1);
		require1 = requireService.selectRequire(1);
		requireService.modifyRequire(require1);
		require1 = requireService.selectRequire(1);

	}
//
//	@Test
//	public void DeleteRequire() throws Exception {
//
//		RequireVO require1 = requireService.selectRequire(1);
//		requireService.removeRequire(1);
//		RequireVO require2 = requireService.selectRequire(1);
//
//	}

}