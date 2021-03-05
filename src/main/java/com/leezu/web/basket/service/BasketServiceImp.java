package com.leezu.web.basket.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leezu.web.basket.entity.Basket;
import com.leezu.web.repository.BasketDAOImp;

@Service
public class BasketServiceImp implements IBasketService{
	@Autowired
	private BasketDAOImp basketDAO;

	@Override
	public void addBasket(HashMap<String, Object> map) {
		System.out.println("장바구니 등록");
		basketDAO.addBasket(map);
	}

	@Override
	public List<Basket> basketList(String userID) {
		System.out.println("장바구니 리스트");
		return basketDAO.basketList(userID);
	}

	@Override
	public Integer getBasketCount(HashMap<String, String> check) {
		System.out.println("장바구니 확인");
		return basketDAO.getBasketCount(check);
	}

	@Override
	public void modBasket(HashMap<String, Object> map) {
		System.out.println("장바구니 갱신");
		basketDAO.modBasket(map);
	}

	@Override
	public int getBasketNum(String id) {
		// TODO Auto-generated method stub
		return basketDAO.getBasketNum(id);
	}

	@Override
	public List<Basket> getBasketByIds(int[] basketIDs) {
		System.out.println("장바구니 아이디로 리스트 조회");
		return basketDAO.getBasketByIds(basketIDs);
	}

	@Override
	public void delBasketById(Integer id) {
		// TODO Auto-generated method stub
		basketDAO.delBasketById(id);
	}
}
