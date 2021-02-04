package com.leezu.web.product.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.product.entity.Product;
import com.leezu.web.product.entity.preProduct;

@Repository
public class ProductDAOImp implements IProductDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	@Override
	public List<Product> getList() throws Exception {
		return sqlSession.selectList(namespace + ".productList");
	}
	@Override
	public void regProduct(String name, int intprice, String description, String size, String fileName) {
		preProduct newprod = new preProduct(name, intprice, description, size, fileName);
		sqlSession.selectOne(namespace + ".regProduct", newprod);
	}
		
}
