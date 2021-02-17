package com.leezu.web.basket.dao;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.basket.entity.Basket;

public interface IBasketDAO {
	
	// 장바구니 등록
	public void addBasket(HashMap<String, Object> map);
	
	// 장바구니 조회
	public List<Basket> basketList(String userID);
	
	// 장바구니 확인
	public int getBasketCount(HashMap<String, String> check);
	
	// 장바구니 갱신
	public void modBasket(HashMap<String, Object> map);
}
