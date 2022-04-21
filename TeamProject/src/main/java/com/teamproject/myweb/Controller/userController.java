package com.teamproject.myweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {

	@GetMapping("/myPage")
	public String myPage() {
		
		return "user/myPage";
	}
	
	@GetMapping("/myModify")
	public String myModify() {
		return "user/myModify";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	
	@GetMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	@GetMapping("/userFind")
	public String userFind() {
		return "user/userFind";
	}
}
