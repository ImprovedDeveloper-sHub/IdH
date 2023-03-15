/*
 * package com.sbs.IdH.dao;
 * 
 * import java.sql.SQLException; import java.util.Date;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.sbs.IdH.command.SearchCriteria; import com.sbs.IdH.dto.WorkVO;
 * import com.sbs.IdH.service.WorkService;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
 * 
 * @Transactional public class TestWorkService {
 * 
 * @Autowired private WorkService workService;
 * 
 * 
 * @Test public void testSelectWork() throws SQLException{
 * workService.selectWork(1);
 * 
 * }
 * 
 * // @Test // public void testSelectWorkList() throws SQLException{ //
 * SearchCriteria cri = new SearchCriteria(); //
 * workService.selectWorkList(cri); // }
 * 
 * @Test public void testInsertWorkList() throws SQLException{ WorkVO work = new
 * WorkVO(2,1,"IdH",1,null,null,"abcabc"); workService.registWork(work); } }
 */