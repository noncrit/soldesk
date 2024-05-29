package com.kim.may_29_1.student;

import java.util.HashMap;
import java.util.Scanner;

public class Student {
	private String name;
	private int score_korean;
	private int score_eng;
	private int score_math;
	private int student_num;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int score_korean, int score_eng, int score_math) {
		super();
		this.name = name;
		this.score_korean = score_korean;
		this.score_eng = score_eng;
		this.score_math = score_math;
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore_korean() {
		return score_korean;
	}

	public void setScore_korean(int score_korean) {
		this.score_korean = score_korean;
	}

	public int getScore_eng() {
		return score_eng;
	}

	public void setScore_eng(int score_eng) {
		this.score_eng = score_eng;
	}

	public int getScore_math() {
		return score_math;
	}

	public void setScore_math(int score_math) {
		this.score_math = score_math;
	}


	public void print_info() {
		
		System.out.println("이름 : "+this.name);
		System.out.println("국어점수 : "+this.score_korean);
		System.out.println("영어점수 : "+this.score_eng);
		System.out.println("수학점수 : "+this.score_math);
		
	}
	
	public void print_info(int student_num) {
		
		System.out.println("이름 : "+this.name);
		System.out.println("국어점수 : "+this.score_korean);
		System.out.println("영어점수 : "+this.score_eng);
		System.out.println("수학점수 : "+this.score_math);
		
	}
	
//	public String student_hash() {
//		
//		HashMap<Integer, String> hm = new HashMap<Integer, String>();
//		
//		hm.put(this.student_num, this.name);
//		System.out.println(hm.get(student_num));
//		
//		return hm.get(this.student_num);
//		
//	}
//	
//	public void print_num_info() {
//		
//		Scanner k = new Scanner(System.in);
//		System.out.println("학생의 번호를 입력해주세요.");
//		int in=k.nextInt();
//		
//	}
}
