package com.example.business;

public class Order {
	Customer customer;
	
	int orderId;
	int customerId;
	String orderDate;
	String orderStatus;
	
	public Order(Customer customer) {
		setCustomer(customer);
	}
	
	public Order(int orderId, int customerId, String orderDate, String orderStatus) {
		setOrderId(orderId);
		setCustomerId(customerId);
		setOrderDate(orderDate);
		setOrderStatus(orderStatus);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
