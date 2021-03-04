package com.leezu.web.product.DAO;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

public interface IProductDAO {
	
	public void regProduct(preProduct product) throws Exception;
	
	public Product get(int id);
	
	public int getProductNum();
	
	public void delProductById(int id);
	
	public void modProduct(Product product);

	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception;

	public void modProductCnt(HashMap<String, Object> map);
	
	public void modLike(Eval eval);
	
	public int getLike(int id);
}
