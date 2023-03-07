package com.sbs.IdH.DAO;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.CompanyruleDAO;
import com.sbs.IdH.dto.CompanyruleVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestCompanyruleDAO {

	@Autowired
	private CompanyruleDAO companyruleDAO;
	@Test
	public void testSelectCompanyrule() throws Exception {
		companyruleDAO.selectCompanyrule(1);

	}
	@Test
	public void testSelectCompanyruleList() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		List<CompanyruleVO> companyruleList = companyruleDAO.selectCompanyruleCriteria(cri);

		for (CompanyruleVO companyrule : companyruleList) {
			System.out.println(companyrule);
		}
	}
	@Test
	public void testInsertCompanyruleList() throws Exception {

		CompanyruleVO companyrule = new CompanyruleVO(3, "abc", "abc", null, "IdH");
		companyruleDAO.insertCompanyrule(companyrule);
		
	}

	
	  @Test public void testCompanyrule_SEQ() throws Exception {
	  System.out.println(companyruleDAO.selectCompanySeqNextValue()); }
	 
	 @Test
	public void testupdateCompanyrule() throws Exception {
		CompanyruleVO companyrule = companyruleDAO.selectCompanyrule(1);
		companyruleDAO.updateCompanyrule(companyrule);

	}

	/*
	 * @Test public void testDeleteCompanyrule() throws Exception { CompanyruleVO
	 * companyrule1 = companyruleDAO.selectCompanyrule(1);
	 * companyruleDAO.deleteCompanyrule(1); CompanyruleVO companyrule2 =
	 * companyruleDAO.selectCompanyrule(1); }
	 */

}