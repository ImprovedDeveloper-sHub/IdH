package com.sbs.IdH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public void test() throws Exception {}
	
	@GetMapping("/business_schedule_detail")
	public void testBusinessScheduleDetail() throws Exception {}
	
	@GetMapping("/business_budget_detail")
	public void testBusinessBudgetDetail() throws Exception{}
	
	@GetMapping("/business_group_detail")
	public void testBusinessGroupDetail() throws Exception{}
	
}
