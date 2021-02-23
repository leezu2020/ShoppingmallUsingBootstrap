package com.leezu.web.product.DAO;

import java.util.HashMap;
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
	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception {
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("keyword", keyword);
		condition.put("size", size);
		condition.put("minprice", minprice);
		condition.put("maxprice", maxprice);
		return sqlSession.selectList(namespace + ".productList", condition);
	}
	@Override
	public void regProduct(preProduct product) {
		sqlSession.selectOne(namespace + ".regProduct", product);
	}
	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getProduct", id);
	}
	@Override
	public int getProductNum() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getProductNum");
	}
	@Override
	public void delProductById(int id) {
		// 해당 상품이 제거됐다고 사용자에게 글 추가
		System.out.println("해당 상품 제거 사용자에게 글 추가");
		sqlSession.selectList(namespace + ".alertDelProduct", id);
		// 해당 상품이 포함된 장바구니 제거
		System.out.println("해당 상품 포함된 장바구니 제거");
		sqlSession.selectList(namespace + ".delBasketByAdmin", id);
		// 해당 상품 제거
		System.out.println("해당 상품 제거");
		sqlSession.selectOne(namespace + ".delProductById", id);
	}
	public void modProduct(Product product) {
		sqlSession.selectOne(namespace + ".modProduct", product);
	}
		
}
