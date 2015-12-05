package com.example.business;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private User user;
	private List<CartItem> cartList = new ArrayList<CartItem>();
	
	public ShoppingCart (User user){
		setUser(user);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void addCartItem(CartItem cartItem) {
		cartList.add(cartItem);
		System.out.println("Cart item added to shopping cart");
	}
	
	public void removeProduct(Product product) {
		cartList.remove(product);
	}
	
	public List<CartItem> cartContents() {
		return cartList;
	}

	public int cartTotal() {
		int totalPrice = 0;
		for(int i = 0; i < cartList.size(); i++) {
			//totalPrice += cartList.get(i).getTotalPrice();
		}
		return totalPrice;
	}
}
