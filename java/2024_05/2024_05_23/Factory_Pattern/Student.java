package com.kim.may23_2.student;
//teacher code
public class Student{
	
	private String name;
	private int age;
	private int num;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int num) {
		super();
		this.name = name;
		this.age = age;
		this.num = num;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(num);
	}
	
	
}


//my code
/*
public class Student {
	
	private String name;
	private int age;
	private int num_tag;
	private String[] array = null;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
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
		this.age = age;
	}

	public int getNum_tag() {
		return num_tag;
	}

	public void setNum_tag(int num_tag) {
		this.num_tag = num_tag;
	}

}
*/