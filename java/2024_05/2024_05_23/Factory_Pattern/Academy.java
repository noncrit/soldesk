package com.kim.may23_2.student;

//Factory 역할을 할 클래스
public class Academy {
	
	private int student_Count;
	
	//객체 찍어낼 때 사용할 메소드
	public Student consult(String name, int age) {
		student_Count++;
		Student s = new Student(name, age, student_Count);
		return s;	
	}
}
