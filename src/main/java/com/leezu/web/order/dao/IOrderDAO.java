package com.leezu.web.order.dao;

import java.util.List;

import com.leezu.web.order.entity.Order;

public interface IOrderDAO {
	// 주문 등록
	public void addOrder(Order order);
	
	public int getCount();

	public List<Order> getOrderList(String userID);
}
