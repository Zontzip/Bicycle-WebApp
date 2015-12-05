package com.example.business;

public class Orders {
	Customer customer;
	
	int orderId;
	String orderDate;
	String orderStatus;
	
	public Orders(Customer customer) {
		setCustomer(customer);
	}
	
	public Orders(int orderId, String orderDate, String orderStatus) {
		setOrderId(orderId);
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
