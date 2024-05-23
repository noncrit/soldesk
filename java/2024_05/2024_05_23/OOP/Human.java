package com.kim.may23_3.human;

import com.kim.may23_3.avengers.Ironman;
import com.kim.may23_3.planet.Planet;
import com.beaver.may233.Avengers.Avengers;

public class Human extends Planet {

	private String name;
	private String planet_name=this.getPName();
	private int radius=this.getRadius();
	private boolean isVisible=this.getVisible();
	private Avengers hero;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void pick(Avengers a) {
		
		hero = a;
		System.out.println("ㄷㄷㄷㅈ");
		
	}
	
	public void need_help() {
		Ironman t = new Ironman();
		System.out.println("도와주세요!!!!");
		t.attack();
		setRadius(1000);
		setVisible(true);
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("사람 이름: "+this.name);
	}
	
}
