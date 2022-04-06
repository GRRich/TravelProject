package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.ProductService;

@RestController
public class AjaxController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getCategory")
	public ArrayList<CategoryVO> getCategory() {
		
		ArrayList<CategoryVO> list = productService.getCategory();
		//화면에 필요한 형식으로 변경해서 list<map> 반환해도 됨
		
		return list;
	}

}
