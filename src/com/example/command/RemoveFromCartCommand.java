package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.ShoppingCart;
import com.example.business.User;

public class RemoveFromCartCommand implements Command {
	
	ShoppingCart shoppingCart;
	User user;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		user = (User) (request.getSession().getAttribute("user"));
		shoppingCart = user.getShoppingCart(); 
		int index = Integer.parseInt(request.getParameter("itemIndex")); 
		shoppingCart.cartContents().remove(index); 
		return "/listProducts.jsp"; 
	}
}
