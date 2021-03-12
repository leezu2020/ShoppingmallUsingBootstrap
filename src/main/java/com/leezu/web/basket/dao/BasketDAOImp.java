package com.leezu.web.basket.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leezu.web.basket.entity.Basket;

@Repository
public class BasketDAOImp{
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.basketMapper";
	

	public void addBasket(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".addBasket", map);
	}


	public List<Basket> basketList(String userID) {
		
		return sqlSession.selectList(namespace + ".basketList", userID);
	}
	

	public Integer getBasketCount(HashMap<String, String> check) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBasketCount", check);
	}


	public void modBasket(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modBasket", map);
	}


	public int getBasketNum(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getBasketNum", id);
	}


	public List<Basket> getBasketByIds(int[] basketIDs) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getBasketByIds", basketIDs);
	}


	public void delBasketById(Integer id) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delBasketById", id);
	}
}
