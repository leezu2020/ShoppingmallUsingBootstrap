package com.leezu.web.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.order.dao.OrderDAOImp;
import com.leezu.web.order.entity.Order;

@Service
public class OrderServiceImp implements IOrderService{
	@Autowired
	private OrderDAOImp orderDAO;

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
}
