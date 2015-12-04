package com.example.business;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private User user;
	private List<Product> cartList = new ArrayList<Product>();
	
	public ShoppingCart (User user){
		setUser(user);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void addProduct(Product product) {
		cartList.add(product);
	}
	
	public void removeProduct(Product product) {
		cartList.remove(product);
	}
	
	public List<Product> cartContents() {
		return cartList;
	}

	public int cartTotal() {
		int totalPrice = 0;
		for(int i = 0; i < cartList.size(); i++) {
			totalPrice += cartList.get(i).getProductPrice();
		}
		return totalPrice;
	}
}
