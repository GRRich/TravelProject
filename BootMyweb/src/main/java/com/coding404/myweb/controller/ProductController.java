package com.coding404.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	//등록화면
	@GetMapping("/productReg")
	public String productReg() {
		return "product/productReg";
	}
	
	//목록화면
	@GetMapping("/productList")
	public String productList(Model model,
							  Criteria cri) {
		
		System.out.println(cri.toString());
		
		//데이터 저장
		//1st
//		ArrayList<ProductVO> list = productService.getList();
		
		//페이지
		ArrayList<ProductVO> list = productService.getList(cri);
		int total = productService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);
		
		model.addAttribute("list", list); //데이터
		model.addAttribute("pageVO", pageVO); //페이지네이션
		
		return "product/productList";
	}
	
	//상세화면
	@GetMapping("/productDetail")
	public String productDetail(@RequestParam("prod_id") int prod_id,
								Model model) {
		
		//데이터저장
		ProductVO prodVO = productService.getDetail(prod_id);
		model.addAttribute("prodVO", prodVO);
		
		return "product/productDetail";
	}
	
	//상품등록 폼
	@PostMapping("/productForm")
	public String productForm(ProductVO vo,
							  RedirectAttributes RA) {
		
		//vo를 등록
		int result = productService.regist(vo);
		
		if(result == 1) { //성공
			RA.addFlashAttribute("msg", vo.getProd_name() + "이 정상 등록되었습니다");
		} else { //실패
			RA.addFlashAttribute("msg", "등록실패, 관리자에게 문의하세요");
		}
		
		return "redirect:/product/productList"; //등록후 목록화면으로
	}
	
	@PostMapping("/prodUpdate")
	public String prodUpdate(@Valid ProductVO vo,
							 Errors errors, //임포트 주의	
							 RedirectAttributes RA,
							 Model model) {
		
		if(errors.hasErrors()) { //유효성검사 실패시 true
			
			List<FieldError> list = errors.getFieldErrors(); //유효성검사 실패 목록확인
			
			for( FieldError err : list ) {
//				System.out.println(err.getField()); //유효성 검사 실패 멤버변수
//				System.out.println(err.getDefaultMessage()); //유효성 검사 실패 메세지
				
				if(err.isBindingFailure()) { //자바측 에러인 경우
					model.addAttribute("valid_" + err.getField(), "형식을 확인하세요"); //직접 에러메세지 생성
				} else {
					model.addAttribute("valid_" + err.getField(), err.getDefaultMessage()); //유효성 검사 실패메세지 
				}
			}
			
			//화면에서는 prodVO이름으로 상세페이지에서 사용되고 있기 때문에, 같은이름으로 보내서 처리합니다
			model.addAttribute("prodVO",vo);
			
			return "product/productDetail"; //유효성 검사에 실패하면 다시 화면으로
		}
		
//		System.out.println(vo.toString());
		
		//업데이트
		int result = productService.update(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", vo.getProd_name() + "이 수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다. 관리자에게 문의하세요");
		}
		
		
		return "redirect:/product/productList"; //목록화면(List에는 msg처리 js가 존재함)
	}
	
	//상품삭제
	@PostMapping("/prodDelete")
	public String prodDelete(@RequestParam("prod_id") int prod_id,
							 RedirectAttributes RA) {
		
		int result = productService.delete(prod_id);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "상품이 삭제되었습니다");
		} else {
			RA.addFlashAttribute("msg", "삭제에 실패했습니다");
		}
		
		return "redirect:/product/productList";
	}
	
	
	
	
	
	
	
}
