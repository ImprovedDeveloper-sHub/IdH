package com.sbs.IdH.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public void test() throws SQLException {}
	
	@GetMapping("/business/schedule")
	public void testBusinessSchedule() throws SQLException {}
	
	@GetMapping("/business/schedule_detail")
	public void testBusinessScheduleDetail() throws SQLException {}
	
	@GetMapping("/business/budget")
	public void testBusinessBudget() throws SQLException{}
	
	@GetMapping("/business/budget_detail")
	public void testBusinessBudgetDetail() throws SQLException {}
	
	@GetMapping("/business/group")
	public void testBusinessGroup() throws SQLException {}
	
	@GetMapping("/business/group_detail")
	public void testBusinessGroupDetail() throws SQLException {}
	
	@GetMapping("/business/regist")
	public void testBusinessRegist() throws SQLException {}
	
}
