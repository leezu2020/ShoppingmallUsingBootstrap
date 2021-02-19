package com.leezu.web.product.service;

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
	public List<Product> getList() throws Exception {
		// TODO Auto-generated method stub
		return productDAO.getList();
	}

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
}
