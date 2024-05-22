package com.kim.may22_5.animal;

import com.kim.may22_5.bite.Bite;

//Java에서는 클래스끼리는 다중 상속이 불가능!!( 1 : 1 만 가능)
//대신 클래스 + 인터페이스 요런식의 유사 다중 상속은 가능함
//인터페이스는 여러개 상속가능
public class Bird extends Animal implements Bite{
	private int leg;
	
	public Bird() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Bird(String species, int age, int leg) {
		super(species, age);
		this.leg = leg;
	}



	public Bird(int leg) {
		super();
		this.leg = leg;
	}
	
	@Override
	public void print_info() {
		// TODO Auto-generated method stub
		super.print_info();
		System.out.println(leg);
	}
	
	@Override
	public void roar() {
		System.out.println("짹짹");
	}
	
	
	@Override
	public void bite() {
		// TODO Auto-generated method stub
		System.out.println("앙");
	}
}
