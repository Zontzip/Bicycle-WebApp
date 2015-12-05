package com.example.business;

public class CartItem {
	User customer;
	Product product;
	
	private int productQuantity;
	
	public CartItem(User customer, Product product, int productQuantity) {
		setProductQuantity(productQuantity);
	}
	
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
