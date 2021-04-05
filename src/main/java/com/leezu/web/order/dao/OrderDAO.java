package com.leezu.web.order.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.order.entity.Order;

@Repository
public class OrderDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.orderMapper";

	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".addOrder", order);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getOrderCount");
	}

	public List<Order> getOrderList(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getOrderList", userID);
	}

	public List<Order> getOrderAllList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getOrderAllList");
	}

	public int getOrderNum(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getOrderNum", userID);
	}

	public void modOrder(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".modOrder", map);
	}

	public void doEval(String orderID) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".doEval", orderID);
	}
	
}
