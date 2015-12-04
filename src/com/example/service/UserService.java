package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Product;
import com.example.business.User;
import com.example.dao.ProductDao;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class UserService {

	UserDao userDao = new UserDao();
	ProductDao bicycleDao = new ProductDao();
	
	public User login(String username, String password){
		
		User u = null;
		try {			
			u = userDao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
		try {
			users = userDao.getAllUsers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		
		try {
			products = bicycleDao.getAllProducts();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return products;
	}
	
}
