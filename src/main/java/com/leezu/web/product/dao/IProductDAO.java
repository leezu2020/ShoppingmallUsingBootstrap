package com.leezu.web.product.DAO;

import java.util.List;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductDAO {
	
	public void regProduct(preProduct product) throws Exception;
	
	public Product get(int id);
	
	public int getProductNum();
	
	public void delProductById(int id);
	
	public void modProduct(Product product);

	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception;
}
