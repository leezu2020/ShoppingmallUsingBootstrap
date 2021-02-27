package com.leezu.web.product.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.product.DAO.ProductDAOImp;
import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

@Service
public class ProductServiceImp implements IProductService{
	@Autowired
	private ProductDAOImp productDAO;

	@Override
	public void regProduct(preProduct product) {
		// TODO Auto-generated method stub
		productDAO.regProduct(product);
	}

	@Override
	public Product get(int id) {
		return productDAO.get(id);
	}

	@Override
	public int getProductNum() {
		return productDAO.getProductNum();
	}

	@Override
	public void delProductById(int id) {
		productDAO.delProductById(id);
	}

	@Override
	public void modProduct(Product product) {
		productDAO.modProduct(product);
		
	}

	@Override
	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception {
		return productDAO.getList(keyword, size, minprice, maxprice);
	}

	@Override
	public void modProductCnt(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		productDAO.modProductCnt(map);
	}
}
