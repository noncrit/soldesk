package com.kim.may23_1.cat;

public class Cat {
	private String name;
	private int age;
	private String nickname;
	
	//Singleton style!!
	private static final Cat CAT = new Cat("버터",7,"버어터");
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, int age, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
	}
	
	public static Cat getCat() {
		return CAT;
	}

	public void print_Cat() {
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		System.out.println("별명 : "+this.nickname);
		
	}
}
