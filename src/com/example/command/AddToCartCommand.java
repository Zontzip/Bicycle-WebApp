package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.CartItem;
import com.example.business.Product;
import com.example.business.ShoppingCart;
import com.example.business.User;

public class AddToCartCommand implements Command {
	CartItem cartItem;
	Product product;
	ShoppingCart shoppingCart;
	User user;
	List<Product> products = new ArrayList<Product>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int index = Integer.parseInt(request.getParameter("itemIndex")); 
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		user = (User) (request.getSession().getAttribute("user"));
		products = (List) (request.getSession().getAttribute("products"));
		product = products.get(index);
		shoppingCart = user.getShoppingCart(); 
		cartItem = new CartItem(user, product, quantity);
		shoppingCart.addCartItem(cartItem); 
		String forwardToJsp = "/listProducts.jsp";
		return forwardToJsp;
	}
	
}
