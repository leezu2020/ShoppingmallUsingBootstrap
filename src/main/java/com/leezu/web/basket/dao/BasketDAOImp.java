package com.leezu.web.basket.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.basket.entity.Basket;

@Repository
public class BasketDAOImp implements IBasketDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";
	
	@Override
	public void addBasket(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.selectOne(namespace + ".addBasket", map);
	}

	@Override
	public List<Basket> basketList(String userID) {
		
		return sqlSession.selectList(namespace + ".basketList", userID);
	}
	
	@Override
	public Integer getBasketCount(HashMap<String, String> check) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBasketCount", check);
	}

	@Override
	public void modBasket(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.selectOne(namespace + ".modBasket", map);
	}

	@Override
	public int getBasketNum(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBasketNum", id);
	}
}
