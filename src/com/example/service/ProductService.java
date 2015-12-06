package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Product;
import com.example.dao.ProductDao;
import com.example.exceptions.DaoException;

public class ProductService {
	ProductDao dao = new ProductDao();
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		try {
			products = dao.getAllProducts();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return products;
	}
	
}