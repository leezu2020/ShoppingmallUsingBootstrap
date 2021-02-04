package com.leezu.web.product.service;

import java.util.List;

import com.leezu.web.product.entity.Product;

public interface IProductService {
	// 게시판 목록 출력
	public List<Product> getList() throws Exception;

	public void regProduct(String name, int intprice, String description, String size, String fileName);

}
