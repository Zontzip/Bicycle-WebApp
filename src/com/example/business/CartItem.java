package com.example.business;

public class CartItem {
	Order order;
	Product product;
	int orderId;
	int productId;
	
	private int productQuantity;
	
	public CartItem(Order order, Product product, int productQuantity) {
		setOrder(order);
		setProduct(product);
		setProductQuantity(productQuantity);
		setOrderId(order.getOrderId());
		setProductId(product.getProductId());
	}
	
	public CartItem(int customerId, int productId, int productQuantity) {
		setOrderId(customerId);
		setProductId(productId);
		setProductQuantity(productQuantity);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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