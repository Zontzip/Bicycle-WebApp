package com.example.command;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.Product;
import com.example.business.ShoppingCart;
import com.example.business.User;

// Called when user clicks 'Remove from shopping cart'
public class RemoveFromCartCommand implements Command {
	
	ShoppingCart shoppingCart;
	User user;
	List<Product> products = new Vector<Product>();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		user = (User) (request.getSession().getAttribute("user")); // Get current user
		shoppingCart = user.getShoppingCart(); // Get user's shopping cart
		int index = Integer.parseInt(request.getParameter("itemIndex")); // Get index of clicked item. Value is String
		shoppingCart.cartContents().remove(index); // Remove item from that index
		return "/listProducts.jsp"; // Forward back to same page
	}
}
