package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Order;
import com.example.service.OrderService;

public class ListOrdersCommand implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService = new OrderService();
		String forwardToJsp = "";
		
		List<Order> orders = new ArrayList<Order>();
		
		orders = orderService.getAllOrders();
		
		if (orders != null) {
			HttpSession session = request.getSession();
			session.setAttribute("orders", orders);
			
			forwardToJsp = "/listOrders.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}
}