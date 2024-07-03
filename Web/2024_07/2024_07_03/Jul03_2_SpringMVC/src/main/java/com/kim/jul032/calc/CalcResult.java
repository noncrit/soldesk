package com.kim.jul032.calc;

//주의점 : 요청 파라미터와 JavaBean 멤버변수명을 같게
//Why? : Spring이 자동으로 요청 파라미터에서 가져온 값을 변수명이 같은 JavaBean 객체에 넣어줌
public class CalcResult {
	private String name;
	private int x;
	private int y;
	
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}

	public CalcResult(String name, int x, int y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
