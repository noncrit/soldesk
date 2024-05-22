package com.kim.may22_5.animal;

public abstract class Animal {	
	//고유 특징으로	: 울음소리 기능을 추가하고싶다. ->근데 뭔 소리 낼지 모름 ->abstract
	//Abstract	: 미완성된 내용이 없는 메소드(나중에 기능을 추가하겠다)
	//			  하위 클래스에서 반드시 override해서 기능을 완성시켜야함
	//** Abstract 메소드가 하나라도 클래스 내부에 존재하면, 해당 클래스는 abstract 클래스 이거나 interface 여야함!! **
	private String species;
	private int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String species, int age) {
		super();
		this.species = species;
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void print_info() {
		System.out.println("-=-=-=-=-=-");
		System.out.println(species);
		System.out.println(age);
	}
	
	public abstract void roar();
}
