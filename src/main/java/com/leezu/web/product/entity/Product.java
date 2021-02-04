package com.leezu.web.product.entity;

import java.util.Date;

public class Product {

	private int productID;
	private String name;
	private int price;
	private String description;
	private String size;
	private String imageUrl;
	private Date regDate;
	private int like;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public Product(int productID, String name, int price, String description, String size, String imageUrl,
			Date regDate, int like) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.description = description;
		this.size = size;
		this.imageUrl = imageUrl;
		this.regDate = regDate;
		this.like = like;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", price=" + price + ", description="
				+ description + ", size=" + size + ", imageUrl=" + imageUrl + ", regDate=" + regDate + ", like=" + like
				+ "]";
	}
	
	
		
}
