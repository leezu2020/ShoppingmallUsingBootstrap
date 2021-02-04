package com.leezu.web.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.product.dao.ProductDAOImp;
import com.leezu.web.product.entity.Product;

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
	public void regProduct(String name, int intprice, String description, String size, String fileName) {
		// TODO Auto-generated method stub
		productDAO.regProduct(name, intprice, description, size, fileName);
	}
}
