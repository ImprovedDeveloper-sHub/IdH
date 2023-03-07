package com.sbs.IdH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/issue")
	public void issue() throws Exception {}
	@GetMapping("/notice")
	public void notice() throws Exception {}
	@GetMapping("/mywork")
	public void mywork() throws Exception {}
	@GetMapping("/detail")
	public void detail() throws Exception {}
	@GetMapping("/regist")
	public void regist() throws Exception {}
	@GetMapping("/teamone")
	public void teamone() throws Exception {}
}
