package com.coding404.myweb.product;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.ProductVO;

@Mapper //****필수****
public interface ProductMapper {

	public int regist(ProductVO vo); //등록
	public ArrayList<ProductVO> getList(); //목록
	public ProductVO getDetail(int prod_id); //상세
	public int update(ProductVO vo); //수정
	public int delete(int prod_id); //삭제
	
}
