package com.sbs.IdH.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sbs.IdH.command.SearchCriteria;
import com.sbs.IdH.dto.IssueVO;
import com.sbs.IdH.service.IssueService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class TestIssueService {

	@Autowired
	   private IssueService issueService;


	   @Test
	   public void testSelectIssue() throws SQLException{
		   issueService.selectIssue(1);

	   }

	   @Test 
	   public void testSelectIssueList() throws SQLException{
		   SearchCriteria cri = new SearchCriteria();
		   issueService.selectIssueList(cri);
	   }

	   @Test
	   public void testInsertIssueList() throws SQLException{
		   IssueVO issue =  new IssueVO(3,"tt","tt",2,null,"IdH",1,"abcabc");
		   issueService.registIssue(issue);
	   }
}