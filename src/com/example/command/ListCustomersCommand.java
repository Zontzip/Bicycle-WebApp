package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Customer;
import com.example.service.CustomerService;

public class ListCustomersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		CustomerService userService = new CustomerService();
		String forwardToJsp = "";
		
		List<Customer> customers = new ArrayList<Customer>();
		
		customers = userService.getAllUsers();
		
		if (customers != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customers", customers);
			
			forwardToJsp = "/listUsers.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}
}
