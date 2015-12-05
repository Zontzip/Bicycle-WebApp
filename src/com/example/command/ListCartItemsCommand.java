package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.CartItem;
import com.example.service.CartItemService;

public class ListCartItemsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CartItemService cartItemService = new CartItemService();
		String forwardToJsp = "";
		
		List<CartItem> cartItems = new ArrayList<CartItem>();
		
		cartItems = cartItemService.getAllCartItems();
		
		if (cartItems != null) {
			HttpSession session = request.getSession();
			session.setAttribute("cartItems", cartItems);
			
			forwardToJsp = "/listProducts.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}

}
