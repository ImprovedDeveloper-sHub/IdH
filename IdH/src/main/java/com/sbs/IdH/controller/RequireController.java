package com.sbs.IdH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RequireController {

	@GetMapping("/test")
	public void test() throws Exception {}
	@GetMapping("/regist")
	public void test1() throws Exception {}
	@GetMapping("/detail")
	public void test2() throws Exception {}
}
