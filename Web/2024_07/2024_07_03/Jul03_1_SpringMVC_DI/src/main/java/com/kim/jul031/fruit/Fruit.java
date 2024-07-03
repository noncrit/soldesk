package com.kim.jul031.fruit;

public class Fruit {
	private String name;
	private int price;

	//객체를 여러개 등록해서 사용하려면?
	//src/main/resources에 xxxbeans.xml을 만들어서 사용하면 된다
	//그런데 xml은 고정값이라 input 역할에는 잘 맞지 않음
	//singleton 패턴 같이 객체 1개만 쓰는 경우는 활용할만함
	//root-context.xml : 톰캣에 실려있는 '프로젝트 전체'에 영향을 줌
	//servlet-context.xml : 지금 프로젝트에만 영향을 줌
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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
