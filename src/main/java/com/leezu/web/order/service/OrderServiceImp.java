package com.leezu.web.order.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.order.entity.Order;
import com.leezu.web.repository.OrderDAO;

@Service
public class OrderServiceImp implements IOrderService{
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("주문 등록");
		orderDAO.addOrder(order);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orderDAO.getCount();
	}

	@Override
	public List<Order> getOrderList(String userID) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderList(userID);
	}

	@Override
	public List<Order> getOrderAllList() {
		// TODO Auto-generated method stub
		return orderDAO.getOrderAllList();
	}

	@Override
	public int getOrderNum(String userID) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderNum(userID);
	}

	@Override
	public void modOrder(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		orderDAO.modOrder(map);
	}

	@Override
	public void doEval(String orderID) {
		// TODO Auto-generated method stub
		orderDAO.doEval(orderID);
	}
}
