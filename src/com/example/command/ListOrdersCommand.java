package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.CartItem;
import com.example.business.Order;
import com.example.service.CartItemService;
import com.example.service.OrderService;

public class ListOrdersCommand implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService = new OrderService();
		CartItemService cartItemService = new CartItemService();
		String forwardToJsp = "";
		
		List<Order> orders = new ArrayList<Order>();		
		orders = orderService.getAllOrders();
		
		List<CartItem> cartItems = new ArrayList<CartItem>();	
		cartItems = cartItemService.getAllCartItems();
		
		if (orders != null) {
			HttpSession session = request.getSession();
			session.setAttribute("orders", orders);
			session.setAttribute("cartitems", cartItems);
			
			forwardToJsp = "/listOrders.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}
}