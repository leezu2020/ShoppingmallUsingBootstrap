package com.leezu.web.order.dao;

import java.util.List;

import com.leezu.web.order.entity.Order;

public interface IOrderDAO {
	// 주문 등록
	public void addOrder(Order order);
	
	public int getCount();

	// 사용자 아이디로 주문 목록 확인
	public List<Order> getOrderList(String userID);

	// 모든 주문 목록 확인
	public List<Order> getOrderAllList();
}
