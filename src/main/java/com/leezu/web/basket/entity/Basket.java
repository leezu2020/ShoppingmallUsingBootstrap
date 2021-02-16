package com.leezu.web.basket.entity;

import java.util.Date;

public class Basket {
	private int basketID;
	private String userID;
	private int productID;
	private String userName;
	private String productName;
	private int productPrice;
	private int count;
	private int total;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public Basket(int basketID, String userID, int productID, String userName, String productName, int productPrice,
			int count, int total, Date regDate, Date modDate) {
		super();
		this.basketID = basketID;
		this.userID = userID;
		this.productID = productID;
		this.userName = userName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.count = count;
		this.total = total;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	
}
