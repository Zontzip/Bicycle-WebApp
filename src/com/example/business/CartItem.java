package com.example.business;

public class CartItem {
	private int customerId;
	private int productName;
	private int productQuantity;
	
	public CartItem(int customerId, int productName, int productQuantity) {
		setCustomerId(customerId);
		setProductName(productName);
		setProductQuantity(productQuantity);
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getProductName() {
		return productName;
	}
	
	public void setProductName(int productName) {
		this.productName = productName;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
