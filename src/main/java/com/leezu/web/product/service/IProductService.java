package com.leezu.web.product.service;

import java.util.List;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductService {
	// 상품 목록 출력
	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception;

	public void regProduct(preProduct product);

	public Product get(int id);

	// 상품 갯수
	public int getProductNum();

	// 상품 삭제
	public void delProductById(int id);
	
	// 상품 수정
	public void modProduct(Product product);

}
