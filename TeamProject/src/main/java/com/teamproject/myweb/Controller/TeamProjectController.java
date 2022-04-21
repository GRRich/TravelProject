package com.teamproject.myweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamProjectController {
	
	@GetMapping("/main")
	public String main() {
		
		return "main";
	}

}
