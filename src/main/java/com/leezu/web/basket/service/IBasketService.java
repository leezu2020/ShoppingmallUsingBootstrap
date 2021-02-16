package com.leezu.web.basket.service;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.basket.entity.Basket;

public interface IBasketService {
	
	// 장바구니 등록
	public void addBasket(HashMap<String, Object> map);
	
	// 장바구니 조회
	public List<Basket> basketList(String userID);
}
