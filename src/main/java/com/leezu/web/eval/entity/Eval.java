package com.leezu.web.eval.entity;

public class Eval {
	private int evalID;
	private String content;
	private int evalRate;
	private String orderID;
	private String userID;
	private int productID;
	private String userName;
	
	public Eval() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEvalID() {
		return evalID;
	}

	public void setEvalID(int evalID) {
		this.evalID = evalID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getEvalRate() {
		return evalRate;
	}

	public void setEvalRate(int evalRate) {
		this.evalRate = evalRate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
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

	public Eval(int evalID, String content, int evalRate, String orderID, String userID, int productID) {
		super();
		this.evalID = evalID;
		this.content = content;
		this.evalRate = evalRate;
		this.orderID = orderID;
		this.userID = userID;
		this.productID = productID;
	}
	
	
}
