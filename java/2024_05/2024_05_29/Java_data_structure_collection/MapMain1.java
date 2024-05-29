package com.kim.may_29_1.main;

import java.util.HashMap;
import java.util.Set;

// Map 계열 (Python : dictionary)
//	가변사이즈
//	<key,value> 한 쌍으로 구성됨
//	순서 개념이 없음
//	HashMap, HahsTable, 등등



public class MapMain1 {
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("아메리카노", 3000);
		hm.put("녹차라떼", 5000);
		hm.put("레몬에이드", 6000);
		hm.put("유자차", 4000);
		hm.put("녹차라떼", 7000);
		
		//get(key값) => key에 맞는 value를 반환함
		System.out.println(hm.get("녹차라떼"));	//뒤에 선언한 7000원이 나옴, key값이 같아서 제일 마지막 선언된 value로 수정됨
		System.out.println("-=-=-=-=-=-=-=-=-");
		
		Set<String> k = hm.keySet();// hm의 키 값만 추출(Set을 이용해 중복은 제거해버림)
		
		for (String string : k) {
			
			System.out.println(string);
			System.out.println(hm.get(string));
			System.out.println("----------");
		}
		
	}
	
}
