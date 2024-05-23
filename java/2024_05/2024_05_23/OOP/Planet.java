package com.kim.may23_3.planet;

import com.kim.may23_3.human.Human;

public class Planet {
	
	private String planet_name;
	private int radius;
	private boolean isVisible;
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}

	public Planet(String name, int radius, boolean isVisible) {
		super();
		this.planet_name = name;
		this.radius = radius;
		this.isVisible = isVisible;
	}
	
	public String getPName() {
		return planet_name;
	}

	public void setPName(String name) {
		this.planet_name = name;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public boolean getVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
	public void getHuman(Human a) {
		
		a.setPName(planet_name);
		a.setRadius(radius);
		a.setVisible(isVisible);
		System.out.printf("%s가 입주하였습니다.\n",a.getName());
	}

	public void print() {
		
		System.out.println("-=-=-=-=-=-=-");
		System.out.println("행성 이름: "+this.planet_name);
		System.out.println("크기 : "+this.radius);
		System.out.println("눈에 보이는가? : "+this.isVisible);	
	}
}
