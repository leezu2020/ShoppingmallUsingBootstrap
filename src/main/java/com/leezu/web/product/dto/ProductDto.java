package com.leezu.web.product.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	
	private int productID;
	private String name;
	private int price;
	private String description;
	private String size;
	private int ea;
	private MultipartFile file;
	
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
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
