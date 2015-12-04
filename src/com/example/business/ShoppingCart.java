package com.example.business;

public class ShoppingCart {
	private int userId;
	private int productCount;
	private int totalPrice;
	
	public ShoppingCart(int userId, int productCount, int totalPrice) {
		setUserId(userId);
		setProductCount(productCount);
		setTotalPrice(totalPrice);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
