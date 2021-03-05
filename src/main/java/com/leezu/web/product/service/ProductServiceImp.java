package com.leezu.web.product.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.eval.service.IEvalService;
import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;
import com.leezu.web.repository.ProductDAO;

@Service
public class ProductServiceImp implements IProductService{
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private IEvalService evalService;

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
		productDAO.modProductCnt(map);
	}

	@Override
	public void modLike(Eval eval) {
		productDAO.modLike(eval);
	}

	@Override
	public int calEvalRateById(int id) {
		int cnt = evalService.getEvalCnt(id);
		if(cnt != 0) {
			return productDAO.getLike(id) / cnt;
		} else {
			return 0;
		}
	}
}
