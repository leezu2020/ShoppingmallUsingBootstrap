package com.leezu.web.basket.service;

import java.util.HashMap;
import java.util.List;

import com.leezu.web.basket.entity.Basket;

public interface IBasketService {
	
	// 장바구니 등록
	public void addBasket(HashMap<String, Object> map);
	
	// 장바구니 조회
	public List<Basket> basketList(String userID);
	
	// 장바구니 목록 확인
	public Integer getBasketCount(HashMap<String, String> check);

	// 장바구니 갱신
	public void modBasket(HashMap<String, Object> map);
	
	// 장바구니 갯수 확인
	public int getBasketNum(String id);

	// 장바구니 아이디로 조회
	public List<Basket> getBasketByIds(int[] basketIDs);

	// 장바구니 아이디로 삭제
	public void delBasketById(Integer integer);
}
