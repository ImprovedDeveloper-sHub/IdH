package com.sbs.IdH.DAO;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dao.CoworkDAO;
import com.sbs.IdH.dto.CoworkVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestCoworkDAO {

	@Autowired
	private CoworkDAO coworkDAO;
	@Test
	public void testSelectCowork() throws Exception {
		coworkDAO.selectCowork(1);

	}
	@Test
	public void testSelectCoworkList() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		List<CoworkVO> coworkList = coworkDAO.selectCoworkCriteria(cri);

		for (CoworkVO cowork : coworkList) {
			System.out.println(cowork);
		}
	}
	
	
	  @Test public void testInsertCoworkList() throws Exception {
	  
	  CoworkVO cowork = new CoworkVO(2,null,null,"abc",1,"IdH",1);
	  coworkDAO.insertCowork(cowork);
	 
	  }
	 

	
	  @Test public void testCoworkrule_SEQ() throws Exception {
	  System.out.println(coworkDAO.selectCoworkSeqNextValue()); }
	 
	 @Test
	public void testupdateCowork() throws Exception {
		CoworkVO cowork = coworkDAO.selectCowork(1);
		coworkDAO.updateCowork(cowork);

	}

	/*
	 * @Test public void testDeleteCoworkrule() throws Exception { CoworkruleVO
	 * coworkrule1 = coworkruleDAO.selectCoworkrule(1);
	 * coworkruleDAO.deleteCoworkrule(1); CoworkruleVO coworkrule2 =
	 * coworkruleDAO.selectCoworkrule(1); }
	 */
}
