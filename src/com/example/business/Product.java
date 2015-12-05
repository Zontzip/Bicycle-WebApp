package com.example.business;

public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private int productPrice;
	
	public Product(int productId, String productName, String productDescription, int productPrice) {
		setProductId(productId);
		setProductName(productName);
		setProductDescription(productDescription);
		setProductPrice(productPrice);
	}

	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + "]";
	}
	
}
