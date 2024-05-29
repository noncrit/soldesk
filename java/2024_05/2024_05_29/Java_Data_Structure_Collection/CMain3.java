package com.kim.may_29_1.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.kim.may_29_1.student.Student;

public class CMain3 {

	public static void main(String[] args) {
		//학생의 이름을 입력했을 때 학생의 전체 정보를 출력하고싶다.
		
		//해쉬맵 선언 애매하다... 정리 확실히
		//***key value : String 을 넣으면 Student 객체의 정보를 가져올 예정***
		//파라미터 맞추는거 익숙해지자...
		//객체 선언???
		
		//new의 역할 제대로 정리하기!!!
		//클래스 객체 변수 = new 클래스();
		
		//자료형 참조값 저장 = (Heap 할당, 인스턴스 생성, 참조값 리턴) 생성자 호출();
		
		HashMap<String, Student> students = new HashMap<String, Student>(); 
		students.put("ㄹㄹ",new Student("ㄹㄹ", 30,20,10));
		students.put("ㅎㅎ",new Student("ㅎㅎ", 40,20,10));
		students.put("ㅁㅁ",new Student("ㅁㅁ", 10,20,10));
		students.put("ㅋㅋ",new Student("ㅋㅋ", 60,20,10));
		
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = k.next();
		
		//get 의 리턴값으로 key : name 에 해당되는 value : Student 객체가 리턴됨 -> 해당 객체에 print_info 가 걸리는 형태
		students.get(name).print_info();
		
		System.out.println(students);
	}
}
