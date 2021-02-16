package com.leezu.web.basket.entity;

import java.util.Date;

public class Basket {
	private int basketID;
	private String userID;
	private int productID;
	private int count;
	private Date create_time;;
	private Date update_time;
	
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Basket(int basketID, String userID, int productID, int count, Date create_time, Date update_time) {
		super();
		this.basketID = basketID;
		this.userID = userID;
		this.productID = productID;
		this.count = count;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
	
}
