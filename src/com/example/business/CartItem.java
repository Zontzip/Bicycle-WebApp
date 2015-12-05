package com.example.business;

public class CartItem {
	private User customer;
	private Product product;
	
	private int customerId;
	private int productId;
	private int productQuantity;
	
	public CartItem(int customerId, int productId, int productQuantity) {
		setCustomerId(customerId);
		setProductId(productId);
		setProductQuantity(productQuantity);
	}
	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
		setCustomerId(customer.getId());
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
		setProductId(product.getProductId());
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productName) {
		this.productId = productName;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
