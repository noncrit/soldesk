package com.kim.may_29_1.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

// Set 계열
//	가변사이즈
//	중복데이터를 알아서 삭제
//	같은 데이터가 여러 번 들어가면 하나면 남김
//	순서가 랜덤
//	HashSet, TreeSet 등등
//	=> 중복 데이터도 유효한 데이터인 경우가 많음 - Set을 쓰기 난감한 이유...

public class SetMain {
	
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("ㅁㅁ");
		hs.add("ㅁㄴ");
		hs.add("ㄴㅁ");
		hs.add("ㄴㅁ");
		hs.add("ㄱㄱ");
		hs.add("ㄱㄱ");
		
		System.out.println(hs.size());
		System.out.println("--------------------");
		
		for (String string : hs) {
			System.out.println(string);
		}
		
		System.out.println("-=-=-=-=-=-=-");
		
		// ArrayLits로 데이터를 넣자(정수 10개, 중복되는 값이 있도록)
		// 중복 제거해서 내림차순으로 정렬
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		al.add(51);
		al.add(2);
		al.add(27);
		al.add(3);
		al.add(3);
		al.add(4);
		al.add(4);
		al.add(3);
		al.add(4);
		al.add(4);
		
		//set에 list를 담아서 중복 날리기***
		HashSet<Integer> hs2 = new HashSet<Integer>(al);
		
		for (Integer i : hs2) {
			System.out.println(i);
		}
		
		System.out.println("--------");
		//내림차순 정렬하기
		al = new ArrayList<Integer>(hs2); // 다시 인덱스 접근이 가능한 리스트로 변환
		
		Comparator<Integer> c = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o2.compareTo(o1);
			}
		};
		al.sort(c);
		
		for (Integer i : al) {
			System.out.println(i);
		}
		
		
		
//		Comparator<Integer> cm = new Comparator<Integer>() {
//			
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				
//				return Math.min(o1, o2);
//			}
//		};
//		
//		//내림차순 정렬
//		al.sort(cm);
//		
//		
//		//중복 제거 루틴
//		for (int i = 0; i < al.size()-1; i++) {
//			if( al.get(i).equals(al.get(i+1)) ){
//				al.remove(i+1);
//				i=0;
//			}
//		}
//		
//		for (Integer integer : al) {
//			System.out.println(integer);
//		}
	}
}
