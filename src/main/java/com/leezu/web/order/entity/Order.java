package com.leezu.web.order.entity;

import java.util.Date;

public class Order {
	private int id;
	private String orderID;
	private int productID;
	private String userID;
	private int count;
	private double total;
	private Date regDate;
	private Date dueDate;
	private String zipcode;
	private String address;
	private String state;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	
	// 주문번호 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Order(String orderID, int productID, String userID, int count, double total, Date regDate, Date dueDate,
			String zipcode, String address, String state) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.userID = userID;
		this.count = count;
		this.total = total;
		this.regDate = regDate;
		this.dueDate = dueDate;
		this.zipcode = zipcode;
		this.address = address;
		this.state = state;
	}
	
	
}
