package com.example.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.CartItem;
import com.example.business.Customer;
import com.example.business.Order;
import com.example.business.ShoppingCart;
import com.example.service.CartItemService;
import com.example.service.OrderService;

public class InsertOrderCommand implements Command {
	Customer customer;
	Order order;
	OrderService orderService = new OrderService();
	
	List<CartItem> cartItems = new ArrayList<CartItem>();
	CartItemService cartItemService = new CartItemService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forwardToJsp = "";
		customer = (Customer) (request.getSession().getAttribute("customer"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String strDate = sdf.format(now);
		
		order = new Order(customer.getId(), strDate, "New");
		orderService.insertOrder(order);
		
		ShoppingCart shoppingCart = (ShoppingCart) customer.getShoppingCart();
		cartItems = (List<CartItem>) shoppingCart.cartContents();
		
		cartItemService.insertCartItems(cartItems);
		
		forwardToJsp = "/listOrders.jsp";
		return forwardToJsp;
	}

}