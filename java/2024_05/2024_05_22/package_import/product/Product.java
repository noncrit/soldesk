package com.kim.may222.product;

public class Product {

	String name;
	int price;
	String item;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price, String item) {
		super();
		this.name = name;
		this.price = price;
		this.item = item;
	}



	public void print_Product() {
		System.out.println("-=-=-=-=-=-=-");
		System.out.printf("제품명 :	%s\n", this.name);
		System.out.printf("가격 :	%d\n", this.price);
		System.out.printf("품목 :	%s\n", this.item);
		
	}
}
