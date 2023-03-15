package com.sbs.IdH.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/sbs/IdH/context/root-context.xml")
@Transactional
public class Test2 {
	
	@Autowired
	ScheduleDAO scheduleDAO;
	
	@Test
	public void test() throws SQLException {
		scheduleDAO.selectSchedule(1);
	}

	
	
	
}
