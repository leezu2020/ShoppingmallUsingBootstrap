package com.leezu.web.product.DAO;

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
	public void regProduct(preProduct product) {
		sqlSession.selectOne(namespace + ".regProduct", product);
	}
	public Product get(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getProduct", id);
	}
		
}
