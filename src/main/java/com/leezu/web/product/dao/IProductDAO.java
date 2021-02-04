package com.leezu.web.product.dao;

import java.util.List;

import com.leezu.web.product.entity.Product;

public interface IProductDAO {
	
	// 제품 목록 가져오기
	public List<Product> getList() throws Exception;
	
	public void regProduct(String name, int intprice, String description, String size, String fileName) throws Exception;
}
