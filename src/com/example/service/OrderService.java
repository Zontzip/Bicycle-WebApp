package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Order;
import com.example.dao.OrderDao;
import com.example.exceptions.DaoException;

public class OrderService {
	OrderDao dao = new OrderDao();
	
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			orders = dao.getAllOrders();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public void insertOrder(Order order) {
		try {
			dao.insertOrder(order);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
	}
}