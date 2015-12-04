package com.example.business;

public class LineOrder {
	private int lineOrderId;
	private int productId;
	private int productQuantity;
	private int linePrice;
	
	public int getLineOrderId() {
		return lineOrderId;
	}
	public void setLineOrderId(int lineOrderId) {
		this.lineOrderId = lineOrderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public int getLinePrice() {
		return linePrice;
	}
	public void setLinePrice(int linePrice) {
		this.linePrice = linePrice;
	}
	
	
}
