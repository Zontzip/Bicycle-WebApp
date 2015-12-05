package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.CartItem;
import com.example.dao.CartItemDao;
import com.example.exceptions.DaoException;

public class CartItemService {
	
	CartItemDao dao = new CartItemDao();
	
	public List<CartItem> getAllCartItems() {
		List<CartItem> cartItems = new ArrayList<CartItem>();
		try {
			cartItems = dao.getAllCartItems();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return cartItems;
	}
}
