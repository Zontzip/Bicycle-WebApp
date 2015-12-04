package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Product;
import com.example.service.ProductService;

public class ListProductsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService productService = new ProductService();
		String forwardToJsp = "";
		
		List<Product> products = new ArrayList<Product>();
		
		products = productService.getAllProducts();
		
		if (products != null) {
			HttpSession session = request.getSession();
			session.setAttribute("products", products);
			
			forwardToJsp = "/listProducts.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		
		return forwardToJsp;
	}

}
