package com.leezu.web.order.service;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.order.entity.Order;

public interface IOrderService {

	public void addOrder(Order order);

	public int getCount();

	public List<Order> getOrderList(String userID);
	
	public List<Order> getOrderAllList();

	public int getOrderNum(String userID);
	
	public void modOrder(HashMap<String, String> map);

	public void doEval(String orderID);
}
