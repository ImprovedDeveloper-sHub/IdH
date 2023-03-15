/*
 * package com.sbs.IdH.dao;
 * 
 * import java.util.List;
 * 
 * import org.junit.Assert; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.sbs.IdH.command.SearchCriteria; import com.sbs.IdH.dto.IssueVO;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
 * 
 * @Transactional public class TestIssueDAO {
 * 
 * @Autowired private IssueDAO issueDAO;
 * 
 * 
 * 
 * 
 * @Test public void testGetIssue() throws Exception { // IssueVO Issue =
 * IssueDAO.selectIssue(0); IssueVO Issue =
 * issueDAO.selectIssueByIssue_Number(1); Assert.assertNotNull(Issue); }
 * 
 * @Test public void testSelectSearchIssueList() { SearchCriteria cri = new
 * SearchCriteria(); List<IssueVO> issueList =
 * issueDAO.selectSearchIssueList(cri);
 * 
 * for(IssueVO issue : issueList) { System.out.println(issue); } }
 * 
 * // @Test // public void testInsertIssue() throws Exception { // IssueVO issue
 * = new IssueVO(3,"tt","tt",2,null,"IdH",1,"abcabc"); //
 * issueDAO.insertIssue(issue); IssueVO issue2 = //
 * issueDAO.selectIssueByIssue_Number(3); // // Assert.assertEquals(issue,
 * issue2); // }
 * 
 * @Test public void testInsertIssue() throws Exception { IssueVO issue = new
 * IssueVO(0, "wow","wow",2, null, null, 0, null); issueDAO.updateIssue(issue);
 * }
 * 
 * @Test public void testDeleteIssue()throws Exception{ issueDAO.deleteIssue(1);
 * } }
 */