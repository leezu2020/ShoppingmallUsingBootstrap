package com.leezu.web.product.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leezu.web.eval.entity.Eval;
import com.leezu.web.product.entity.Product;

@Repository
public class ProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.productMapper";
	private static final String namespaceBasket = "com.leezu.mapper.basketMapper";
	private static final String namespaceAlert = "com.leezu.mapper.privateNoticeMapper";
	

	public List<Product> getList(String keyword, String size, int minprice, int maxprice) throws Exception {
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("keyword", keyword);
		condition.put("size", size);
		condition.put("minprice", minprice);
		condition.put("maxprice", maxprice);
		return sqlSession.selectList(namespace + ".productList", condition);
	}

	public void regProduct(Product product) {
		sqlSession.insert(namespace + ".regProduct", product);
	}

	public Product get(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getProduct", id);
	}

	public int getProductNum() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getProductNum");
	}

	public void delProductById(int id) {
		// 해당 상품이 제거됐다고 사용자에게 글 추가
		System.out.println("해당 상품 제거 사용자에게 글 추가");
		sqlSession.insert(namespaceAlert + ".alertDelProduct", id);
		// 해당 상품이 포함된 장바구니 제거
		System.out.println("해당 상품 포함된 장바구니 제거");
		sqlSession.delete(namespaceBasket + ".delBasketByAdmin", id);
		// 해당 상품을 주문한 사용자에게 글 추가
		sqlSession.insert(namespaceAlert + ".alertDelProductForOrder", id);
		// 해당 상품 제거
		System.out.println("해당 상품 제거");
		sqlSession.delete(namespace + ".delProductById", id);
	}
	

	public void modProduct(Product product) {
		sqlSession.update(namespace + ".modProduct", product);
	}
	

	public void modProductCnt(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modProductCnt", map);
	}
	

	public void modLike(Eval eval) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modLike", eval);
	}
	

	public int getLike(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getLike", id);
	}
		
}
