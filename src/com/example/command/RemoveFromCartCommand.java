package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.ShoppingCart;
import com.example.business.Customer;

public class RemoveFromCartCommand implements Command {
	
	ShoppingCart shoppingCart;
	Customer customer;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		customer = (Customer) (request.getSession().getAttribute("customer"));
		shoppingCart = customer.getShoppingCart(); 
		int index = Integer.parseInt(request.getParameter("itemIndex")); 
		shoppingCart.cartContents().remove(index); 
		return "/listProducts.jsp"; 
	}
}
