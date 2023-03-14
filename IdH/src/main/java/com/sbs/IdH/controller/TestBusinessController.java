package com.sbs.IdH.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("business")
public class TestBusinessController {

	@GetMapping("/test")
	public void test() throws SQLException {}
	
	@GetMapping("/schedule/main")
	public void testBusinessSchedule() throws SQLException {}
	
	@GetMapping("/schedule/detail")
	public void testBusinessScheduleDetail() throws SQLException {}
	
	@GetMapping("/budget/main")
	public void testBusinessBudget() throws SQLException{}
	
	@GetMapping("/budget/detail")
	public void testBusinessBudgetDetail() throws SQLException {}
	
	@GetMapping("/group/main")
	public void testBusinessGroup() throws SQLException {}
	
	@GetMapping("/group/detail")
	public void testBusinessGroupDetail() throws SQLException {}
	
	@GetMapping("/regist")
	public void testBusinessRegist() throws SQLException {}
	
}
