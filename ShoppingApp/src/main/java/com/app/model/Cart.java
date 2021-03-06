package com.app.model;

import com.app.model.Product;

public class Cart {
	
	private int id;
	private int customerId;
	private int productId;
	private Product product;
	
	
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int productId, int customerId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", product=" + product
				+ "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

}
