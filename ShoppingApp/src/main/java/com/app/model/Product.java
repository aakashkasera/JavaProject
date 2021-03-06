package com.app.model;

public class Product {
	
	private int id ;
	private String name ;
	private String category;
	private int price;
	private String manufacturerName;
	
	public void setManufacturerName(String manufacturerName)
	{
		this.manufacturerName=manufacturerName;
	}
	
	public String getManufacturerName()
	{
		return manufacturerName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return ("Product id = " + id + ", name = " + name + ", manufacturerName = " + manufacturerName+", category = " + category + ", price = " + price);
	}
	

}
