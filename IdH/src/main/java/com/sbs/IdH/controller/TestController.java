package com.sbs.IdH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public void test() throws Exception {
	}
//	@GetMapping("/work/main")
//	public void main() throws Exception {
//	}
	
	/*
	 * @GetMapping("/work/main2") public void main2() throws Exception { }
	 */
	@GetMapping("/notice")
	public void notice() throws Exception {
	}

	@GetMapping("/mywork")
	public void mywork() throws Exception {
	}


	@GetMapping("/teammember")
	public void teamone() throws Exception {
	}
}
