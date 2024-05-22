package com.kim.may22_4.menu;
// 정리!

//단축키 window - preference - key에 설정있음(generate ~ using filed : ctrl + shift + space)(생성자 오버로딩)
//(generate ~ getters and setters : ctrl + shift + z (getter/setter)
//바인딩 칸에 클릭 후 키 지정


public class Menu {
	private String name;
	private int price;
	
	//기본 생성자
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	//생성자 오버로딩
	public Menu(String name, int price) {
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
	
	//그 외 나머지 기능 메소드들...
	
	
}
