package com.leezu.web.product.DAO;

import java.util.List;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductDAO {
	
	// 제품 목록 가져오기
	public List<Product> getList() throws Exception;
	
	public void regProduct(preProduct product) throws Exception;
	
	public Product get(int id);
	
	public int getProductNum();
	
	public void delProductById(int id);
}
