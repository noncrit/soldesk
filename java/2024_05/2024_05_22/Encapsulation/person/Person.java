package com.kim.may22_4.person;

public class Person {
	private String name;	//변수들의 외부 노출 제한
	private int age;
	private double weight;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0) {
			age *= -1;
		}
		this.age = age;
	}
	
	public void print_info() {
		
		System.out.println("-=-=-=-=-=-=-");
		System.out.printf("이름 :	%s\n",this.name);
		System.out.printf("나이 :	%d\n",this.age);
		System.out.printf("몸무게 :	%d\n",this.weight);
	}
}
