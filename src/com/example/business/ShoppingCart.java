package com.example.business;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Product> cartList = new ArrayList<Product>();
	User user;
	
	int productCount;
	
	public ShoppingCart (User user){
		this.user = user;
		this.productCount = 0;
	}
	
	public void addProduct(Product product) {
		cartList.add(product);
	}
	
	public void removeProduct(Product product) {
		cartList.remove(product);
	}

	public int getProductCount() {
		return productCount;
	}
	
	public void setProductCount(int productCount) {
		this.productCount = cartList.size();
	}

	public int cartTotal() {
		int totalPrice = 0;
		for(int i = 0; i < cartList.size(); i++) {
			totalPrice += cartList.get(i).getProductPrice();
		}
		return totalPrice;
	}
}
