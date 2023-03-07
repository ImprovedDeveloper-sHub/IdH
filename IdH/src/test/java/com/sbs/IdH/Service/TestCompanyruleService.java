package com.sbs.IdH.Service;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.CompanyruleVO;
import com.sbs.IdH.service.CompanyruleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestCompanyruleService {

	@Autowired
	private CompanyruleService companyruleService;

	@Test
	public void testSelectcompanyrule() throws SQLException {
		CompanyruleVO companyrule = companyruleService.selectCompanyrule(1);

	}

	@Test
	public void testSelectCompanyruleList() throws SQLException {
		SearchCriteria cri = new SearchCriteria();
		companyruleService.selectCompanyruleList(cri);
	}

	@Test
	public void testInsertCompanyruleList() throws SQLException {
		CompanyruleVO companyrule = new CompanyruleVO(3, "abc", "abc", null, "IdH");
		companyruleService.registCompanyrule(companyrule);
	}

	@Test
	public void testupdateCompanyrule() throws SQLException {

		CompanyruleVO companyrule = companyruleService.selectCompanyrule(1);
		companyruleService.modifyCompanyrule(companyrule);
		companyrule =companyruleService.selectCompanyrule(1);

	}

	/*
	 * @Test public void testDeleteCowork() throws Exception{
	 * 
	 * }
	 */
}
