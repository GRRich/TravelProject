package com.coding404.myweb.product;

import java.util.ArrayList;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

public interface ProductService {

	public int regist(ProductVO vo); //등록
	//public ArrayList<ProductVO> getList(); //목록
	public ArrayList<ProductVO> getList(Criteria cri); //목록
	public int getTotal(Criteria cri); //전체게시글 수
	
	
	public ProductVO getDetail(int prod_id); //상세
	public int update(ProductVO vo); //수정
	public int delete(int prod_id); //삭제
	
	public ArrayList<CategoryVO> getCategory(); //첫번째 카테고리 
	public ArrayList<CategoryVO> getCategoryChild(CategoryVO vo);// 두,세번째 카테고리
	
}
