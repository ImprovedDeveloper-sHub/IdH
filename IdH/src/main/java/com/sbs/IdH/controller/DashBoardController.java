package com.sbs.IdH.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashBoard")
public class DashBoardController {

	@GetMapping("main")
	public void main() {}
	
	@GetMapping("/teamLeader")
	public void teamLeader() {
	}
	@GetMapping("/teamMember")
	public void teamMember() {
	}
	
	@GetMapping("/executives")
	public void executives() {
	}
	
	
}
