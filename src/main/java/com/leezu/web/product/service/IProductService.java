package com.leezu.web.product.service;

import java.util.List;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductService {
	// 게시판 목록 출력
	public List<Product> getList() throws Exception;

	public void regProduct(preProduct product);

	public Product get(int id);

}
