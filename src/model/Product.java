package model;

public class Product {
	private String name;
	private int price;
	public Product(String n, int p) {
		name = n;
		price = p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
