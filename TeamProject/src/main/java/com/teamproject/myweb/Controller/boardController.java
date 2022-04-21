package com.teamproject.myweb.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamproject.myweb.command.DebateVO;
import com.teamproject.myweb.debate.DebateService;

@Controller
@RequestMapping("/board")
public class boardController {
	
	@Autowired
	@Qualifier("debateService")
	private DebateService debateService;
	
	@GetMapping("/freeBoard")
	public String freeBoard() {
		return "board/freeBoard";
	}
	
	@GetMapping("/reviewBoard")
	public String reviewBoard() {
		return "board/reviewBoard";
	}
	
	@GetMapping("/reviewReg")
	public String reivewReg() {
		return "board/reviewReg";
	}
	
	@GetMapping("/reviewDetail")
	public String reviewdetail() {
		return "board/reviewDetail";
	}
	
	@GetMapping("/debateBoard")
	public String debateBoard(Model model) {
		
		ArrayList<DebateVO>list = debateService.getList();
		
		model.addAttribute("list", list);
		
		return "board/debateBoard";
	}
	
	@GetMapping("/debateReg")
	public String debateReg() {
		
		return "board/debateReg";
	}
	
	@PostMapping("/debateForm")
	public String debateForm(DebateVO vo,
							 RedirectAttributes RA) {
		int result =  debateService.regist(vo);
		System.out.println(vo.toString());
		
		return "redirect:/board/debateBoard";
	}
	
	@GetMapping("/debateUpdate")
	public String debateUpdate() {
		
		return "board/debateUpdate";
	}

	
	
}
