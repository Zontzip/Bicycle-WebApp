package com.example.business;

public class LineOrder {
	private Product product;
	
	private int productQuantity;
	private int linePrice;
	
	public LineOrder(Product product, int productQuantity) {
		setProduct(product);
		setProductQuantity(productQuantity);
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public int getLinePrice() {
		return linePrice;
	}
	
	public void setLinePrice(int linePrice) {
		this.linePrice = linePrice;
	}
	
	
}
