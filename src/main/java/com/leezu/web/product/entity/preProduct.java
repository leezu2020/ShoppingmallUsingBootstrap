package com.leezu.web.product.entity;

public class preProduct {

	private String name;
	private int price;
	private String description;
	private String size;
	private String imageUrl;
	private int ea;
	
	public preProduct() {
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
	
	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public preProduct(String name, int price, String description, String size, String imageUrl, int ea) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.size = size;
		this.imageUrl = imageUrl;
		this.ea = ea;
	}
	
	
}
