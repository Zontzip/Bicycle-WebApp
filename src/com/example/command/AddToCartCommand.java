package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.business.CartItem;
import com.example.business.Product;
import com.example.business.ShoppingCart;
import com.example.business.Customer;
import com.example.business.Order;

public class AddToCartCommand implements Command {
	CartItem cartItem;
	Product product;
	ShoppingCart shoppingCart;
	Customer customer;
	Order order;
	List<Product> products = new ArrayList<Product>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int index = Integer.parseInt(request.getParameter("itemIndex")); 
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		customer = (Customer) (request.getSession().getAttribute("customer"));
		order = customer.getOrder();
		products = (List) (request.getSession().getAttribute("products"));
		product = products.get(index);
		shoppingCart = customer.getShoppingCart(); 
		cartItem = new CartItem(order, product, quantity);
		shoppingCart.addCartItem(cartItem); 
		String forwardToJsp = "/listProducts.jsp";
		return forwardToJsp;
	}
	
}