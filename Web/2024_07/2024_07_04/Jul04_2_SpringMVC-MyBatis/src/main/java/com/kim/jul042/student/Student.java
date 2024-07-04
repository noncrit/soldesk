package com.kim.jul042.student;
/*
MyBatis : ORM Framework ( Object Relationship Mapping)
객체와 데이터베이스의 데이터를 자동으로 연결(매핑) 해주는 프레임워크
결과가 자바 객체로 나옴
자동 매핑의 전제 조건 : DB 컬렴명 = Java 멤버 변수명

Oracle - 정수, 실수 모두 number로 처리함
Java - 한가지 자료형으로 통일 - BigDecimal (실수, 정수  둘 다 처리 가능)

Spring MVC : 요청 파라미터를 자동으로 객체로 매핑해줬음 ( 요청 파라미터의 이름 = Java의 멤버 변수명이 같은 경우 )

최종적으로 사용할 기술 스택
Spring MVC + MyBatis + Maven
요청 파라미터 = Java멤버변수명 = DB컬럼명 항상 같게 맞춰주기 (자동 매핑)
*/

import java.math.BigDecimal;

public class Student {
	private BigDecimal s_no;
	private String s_name;
	private String s_nickname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(BigDecimal s_no, String s_name, String s_nickname) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_nickname = s_nickname;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_nickname() {
		return s_nickname;
	}

	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}
	
	
}
