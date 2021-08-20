package com.app.model;

public class Order {

		private int id;
		private int productId;
		private int customerId;
		private int price;
		private String status;
		
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Order(int id, int productId, int customerId, int price, String status) {
			super();
			this.id = id;
			this.productId = productId;
			this.customerId = customerId;
			this.price = price;
			this.status = status;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Order [id=" + id + ", productId=" + productId + ", customerId=" + customerId + ", price=" + price
					+ ", status=" + status + "]";
		}
		
		
			
	
}
