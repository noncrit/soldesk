package com.kim.may22_5.avengers;

public class Ironman extends Avengers implements Details, Smoker, Drive {
	private int property;
	/*
	 원래 내가 짰던 코드(Details에 두 속성을 끌어와서 출력하는 형식) / 대신 답안에서는 interface를 2개 만들고 추상 메소드 삽입
	private Boolean isSmoke=Details.isSmoke;
	private Boolean canDrive=Details.canDrive;
	*/
	public Ironman() {
		// TODO Auto-generated constructor stub
	}

	public Ironman(int property) {
		super();
		this.property = property;
	}
	

	public Ironman(String name, int age, int property) {
		super(name, age);
		this.property = property;
	}

	public int getProperty() {
		return property;
	}

	public void setProperty(int property) {
		this.property = property;
	}
	
	@Override
	public void attack() {
		System.out.println("비이이이이이임");
	}
	/*
	public void print_isSmoke() {
		System.out.println("담배 피우나 ? "+this.isSmoke);
	}
	
	public void print_canDrive() {
		System.out.println("운전 가능? "+this.canDrive);
	}
	*/

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("날아다님");
	}

	@Override
	public void smoke() {
		// TODO Auto-generated method stub
		System.out.println("스모크 챌린지");
	}
	
}
