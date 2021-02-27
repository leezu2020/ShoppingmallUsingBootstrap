package com.leezu.web.order.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leezu.web.order.entity.Order;

@Repository
public class OrderDAOImp implements IOrderDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.leezu.mapper.userMapper";

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".addOrder", order);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getOrderCount");
	}

	@Override
	public List<Order> getOrderList(String userID) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".getOrderList", userID);
	}
	
}
