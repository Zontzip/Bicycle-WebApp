package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.Product;
import com.example.business.ShoppingCart;
import com.example.business.User;

public class AddToCartCommand implements Command {
	ShoppingCart shoppingCart;
	User user;
	List<Product> products = new ArrayList<Product>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int index = Integer.parseInt(request.getParameter("itemIndex")); // Clicked item. Value is passed as String	
		user = (User) (request.getSession().getAttribute("user")); // Get current user
		products = (List) (request.getSession().getAttribute("products")); // Get available products
		shoppingCart = user.getShoppingCart(); // Get user's Shopping Cart
		shoppingCart.addProduct(products.get(index)); // Add product to shopping carts content
		String forwardToJsp = "/listProducts.jsp"; // forward user back to same page
		return forwardToJsp;
	}
	
}
