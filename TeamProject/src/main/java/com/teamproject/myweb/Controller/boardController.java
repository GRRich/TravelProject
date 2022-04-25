package com.teamproject.myweb.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println(result);
		
		return "redirect:/board/debateBoard";
	}
	
	@GetMapping("/debateUpdate")
	public String debateUpdate(Model model,
							   @RequestParam("debate_no") int debate_no) {
		
		DebateVO debateVO = debateService.getDetail(debate_no);
		model.addAttribute("debateVO", debateVO);
		System.out.println(debateVO.toString());
		
//		ArrayList<DebateVO> list = debateService.getList();
//		model.addAttribute("list", list);
		
		return "board/debateUpdate";
	}
	
	@PostMapping("/updateForm")
	public String updateForm(DebateVO vo,
							 RedirectAttributes RA) {
		
		int result = debateService.update(vo);
		
		
		return "redirect:/board/debateBoard";
		
	}
	
	@PostMapping("/deleteForm")
	public String deleteForm(@RequestParam("debate_no") int debate_no,
							 RedirectAttributes RA) {
		
		int result = debateService.delete(debate_no);
		
		return "redirect:/board/debateBoard";
		
	}

	
	
}
