package com.kim.may_29_1.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//List 계열

//ArrayList
//	요소를 인덱스로 사용하는 방법이 배열과 유사
//	배열 : 사이즈가 고정값, 데이터의 수가 배열의 크기보다 많아지면 방법이 없음

//	ArrayList : 저장되는 데이터 수에 따라서 크기가 자동적으로 변경됨
//	-요소가 가득차게되면 ArrayList의 크기 ++, 반대로 다 채워지지 않았으면 그만큼 크기--
//	-자료형을 섞어서 데이터를 넣는게 가능 -> 좋은가?는 모르겠음
//	-그래서 보통 자료형을 통일해서 사용함 <>(generic) 을 이용
//	-<>(generic) : 자료형을 고정하는 역할을 함
//	-클래스명<자료형의 객체형>

public class ListMain {

	public static void main(String[] args) {
		
		ArrayList test = new ArrayList();
		test.add("수요일");
		test.add("529");
		test.add("무야호");
		test.add(221);
		test.add(true);
		
		//출력은 되는데 Object의 자료형이 통일되어있지않음->나중에 골치아플수도
		for (Object object : test) {	
			System.out.println(object);
		}
		
		//generic으로 선언해서 이제 String만 들어갈 수 있음
		ArrayList<String> al = new ArrayList<>();
		al.add("파인애플");
		System.out.println(al);
		
		ArrayList<Integer>	al2 = new ArrayList<>();
		al2.add(new Integer(100));
		//auto boxing 처리 있어서 그냥 정수만 넣어도 알아서 위의 선언처럼 바꿔줌
		al2.add(4);
		System.out.println(al2);
		
		//인덱스로도 접근 가능
		System.out.println(al2.get(0));
		
		System.out.println(al2.size());
		
		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
			
		}
		
		System.out.println("-=-=-=-");
		//파라미터 1개짜리 - 제일 뒤쪽에 추가
		al2.add(30);
		
		//파라미터 2개짜리 - 인덱스 자리에 value 추가, 인덱스 기준 뒤쪽 자료들은 한칸씩 뒤로 밀려남
		al2.add(1, 90);
		
		//값 변경을 원하면 set 사용
		al2.set(2, 0);
		
		//특정 인덱스 제거 Q. 제거하면 그 자리 뒤쪽 인덱스들은 앞으로 당겨주나??
//		al2.remove(0);
		
		for (int i = 0; i < al2.size(); i++) {
			System.out.print(al2.get(i));
			System.out.print("\n");
		}
		
		al.add("사과");
		al.add("귤");
		al.add("당근");
		al.add("참외");
		al.add("김");
		al2.add(84);
		al2.add(2173);
		al2.add(35);
		System.out.println(al2);
		System.out.println("-=-=-=-=-=-=-");
		
		// ArrayList 정렬
		Comparator<String> c= new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2); //아스키 코드값 기준 오름차순 정렬
//				return o2.compareTo(o1); //아스키 코드값 기준 내림차순 정렬
			}
		};	
		al.sort(c); // c 방식대로 정렬
		
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i));
			System.out.print("\n");
		}
		System.out.println("0-0-0-0-0-0-0-0-0");
		
		Comparator<Integer> c2= new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
//				return o1.compareTo(o2); //아스키 코드값 기준 오름차순 정렬
				return o2.compareTo(o1); //아스키 코드값 기준 내림차순 정렬
			}
		};
			
		al2.sort(c2);
		
		for (int s : al2) {
			System.out.println(s);
		}
		
		System.out.println("0-0-0-0-0-0-0-0-0");
		
		
		
	}//end of main
	
}
