package com.kim.may_29_1.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.kim.may_29_1.student.*;

public class CMain2 {
	
	public static void main(String[] args) {
		
		//학생 객체를 찍어내기 위한 클래스 : 이름, 국어점수, 영어점수, 수학점수 + 속성 출력기능까지
		
		//클래스 하나 만들기 - 학생의 번호를 입력하면 그 학생의 정보를 출력
		//학생 객체는 4명정도
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(new Student("ㅋㅋ", 30,20,10));
		students.add(new Student("ㅋㅋ", 40,20,10));
		students.add(new Student("ㅋㅋ", 10,20,10));
		students.add(new Student("ㅋㅋ", 60,20,10));
		
		Scanner k = new Scanner(System.in);
		System.out.print("번호 : ");
		int no = k.nextInt();
		
		//해당 학생의 전체 정보가 출력되도록
		students.get(no - 1).print_info();
		
		
	}
}
