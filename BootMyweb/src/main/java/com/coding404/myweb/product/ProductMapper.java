package com.coding404.myweb.product;

import org.apache.ibatis.annotations.Mapper;

import com.coding404.myweb.command.ProductVO;

@Mapper //****필수****
public interface ProductMapper {

	public int regist(ProductVO vo); //등록
	
}
