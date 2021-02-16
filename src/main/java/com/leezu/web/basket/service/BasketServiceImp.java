package com.leezu.web.basket.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.basket.dao.BasketDAOImp;

@Service
public class BasketServiceImp implements IBasketService{
	@Autowired
	private BasketDAOImp basketDAO;

	@Override
	public void addBasket(HashMap<String, Object> map) {
		System.out.println("장바구니 등록");
		basketDAO.addBasket(map);
	}
	
	
}
