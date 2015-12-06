package com.example.business;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private Customer user;
	private List<CartItem> cartList = new ArrayList<CartItem>();
	
	public ShoppingCart (Customer user){
		setUser(user);
	}
	
	public Customer getUser() {
		return user;
	}
	
	public void setUser(Customer user) {
		this.user = user;
	}

	public void addCartItem(CartItem cartItem) {
		cartList.add(cartItem);
	}
	
	public void removeCartItem(Product product) {
		cartList.remove(product);
	}
	
	public List<CartItem> cartContents() {
		return cartList;
	}

	public int cartTotal() {
		int totalPrice = 0;
		for(int i = 0; i < cartList.size(); i++) {
			totalPrice += cartList.get(i).getCartItemTotal();
		}
		return totalPrice;
	}
	
	public void emptycart() {
		cartList.clear();
	}
}