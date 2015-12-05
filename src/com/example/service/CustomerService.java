package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Customer;
import com.example.dao.CustomerDao;
import com.example.exceptions.DaoException;

public class CustomerService {

	CustomerDao dao = new CustomerDao();
	
	public Customer login(String username, String password){
		
		Customer c = null;
		try {			
			c = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return c;
		
	}
	
	public List<Customer> getAllUsers() {
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			customers = dao.getAllUsers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return customers;
	}
}
