package com.example.business;

public class CartItem {
	Customer customer;
	Product product;
	int orderId;
	int productId;
	
	private int productQuantity;
	
	public CartItem(Customer customer, Product product, int productQuantity) {
		setCustomer(customer);
		setProduct(product);
		setProductQuantity(productQuantity);
	}
	
	public CartItem(int customerId, int productId, int productQuantity) {
		setOrderId(customerId);
		setProductId(productId);
		setProductQuantity(productQuantity);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		product.toString();
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCartItemTotal() {
		int cartItemTotal = 0;
		Product p = this.getProduct();
		cartItemTotal = p.getProductPrice() * this.getProductQuantity();
		return cartItemTotal;
	}
}