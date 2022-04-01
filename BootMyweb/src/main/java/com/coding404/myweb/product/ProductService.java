package com.coding404.myweb.product;

import java.util.ArrayList;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

public interface ProductService {
	
	public int regist(ProductVO vo); //등록
	
//	public ArrayList<ProductVO> getList(); //목록
	public ArrayList<ProductVO> getList(Criteria cri); //목록
	
	public int getTotal(Criteria cri); //전체 게시글 수
	
	public ProductVO getDetail(int prod_id); //상세
	
	public int update(ProductVO vo); //수정
	
	public int delete(int prod_id); //삭제

}
