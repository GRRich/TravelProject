package com.teamproject.myweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class messageController {

	@GetMapping("/messageList")
	public String messageList() {
		return "message/messageList";
	}
	
	@GetMapping("/messageDetail")
	public String messageDetail() {
		return "message/messageDetail";
	}
	
	@GetMapping("/messageReceive")
	public String messageReceive() {
		return "message/messageReceive";
	}
	
	@GetMapping("/messageSend")
	public String messageSend() {
		return "message/messageSend";
	}
}
