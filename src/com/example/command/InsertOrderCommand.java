package com.example.command;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.Customer;
import com.example.business.Order;
import com.example.service.OrderService;

public class InsertOrderCommand implements Command {
	Customer customer;
	Order order;
	OrderService orderService = new OrderService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forwardToJsp = "";
		customer = (Customer) (request.getSession().getAttribute("customer"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date now = new Date();
		String strDate = sdf.format(now);
		
		order = new Order(customer.getId(), strDate, "New");
		orderService.insertOrder(order);
		
		forwardToJsp = "/listOrders.jsp";
		return forwardToJsp;
	}

}
