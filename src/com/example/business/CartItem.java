package com.example.business;

public class CartItem {
	Customer customer;
	Product product;
	
	private int productQuantity;
	
	public CartItem(Customer customer, Product product, int productQuantity) {
		setCustomer(customer);
		setProduct(product);
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

	public int getCartItemTotal() {
		int cartItemTotal = 0;
		Product p = this.getProduct();
		cartItemTotal = p.getProductPrice() * this.getProductQuantity();
		return cartItemTotal;
	}
}
