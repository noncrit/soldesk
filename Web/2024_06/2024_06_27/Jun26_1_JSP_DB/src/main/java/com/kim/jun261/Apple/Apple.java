package com.kim.jun261.Apple;

public class Apple {
	//앞으로 약속 사항 : 멤버 변수명 == 데이터베이스 컬럼명 == JSP 요청 파라미터 이름
	private String a_ORIGIN;
	private String a_COLOR;
	private String a_TASTE;
	private int a_PRICE;
	private String a_INTRODUCE;
	
	public Apple() {
		// TODO Auto-generated constructor stub
	}

	public Apple(String a_ORIGIN, String a_COLOR, String a_TASTE, int a_PRICE, String a_INTRODUCE) {
		super();
		this.a_ORIGIN = a_ORIGIN;
		this.a_COLOR = a_COLOR;
		this.a_TASTE = a_TASTE;
		this.a_PRICE = a_PRICE;
		this.a_INTRODUCE = a_INTRODUCE;
	}

	public String getA_ORIGIN() {
		return a_ORIGIN;
	}

	public void setA_ORIGIN(String a_ORIGIN) {
		this.a_ORIGIN = a_ORIGIN;
	}

	public String getA_COLOR() {
		return a_COLOR;
	}

	public void setA_COLOR(String a_COLOR) {
		this.a_COLOR = a_COLOR;
	}

	public String getA_TASTE() {
		return a_TASTE;
	}

	public void setA_TASTE(String a_TASTE) {
		this.a_TASTE = a_TASTE;
	}

	public int getA_PRICE() {
		return a_PRICE;
	}

	public void setA_PRICE(int a_PRICE) {
		this.a_PRICE = a_PRICE;
	}

	public String getA_INTRODUCE() {
		return a_INTRODUCE;
	}

	public void setA_INTRODUCE(String a_INTRODUCE) {
		this.a_INTRODUCE = a_INTRODUCE;
	}
	

}
