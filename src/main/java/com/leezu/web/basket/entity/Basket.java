package com.leezu.web.basket.entity;

import java.util.Date;

public class Basket {
	private int basketID;
	private String userID;
	private int productID;
	private int count;
	private Date regDate;
	private Date modDate;
	
	public Basket() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBasketID() {
		return basketID;
	}
	public void setBasketID(int basketID) {
		this.basketID = basketID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public Basket(int basketID, String userID, int productID, int count, Date regDate, Date modDate) {
		super();
		this.basketID = basketID;
		this.userID = userID;
		this.productID = productID;
		this.count = count;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	
}
