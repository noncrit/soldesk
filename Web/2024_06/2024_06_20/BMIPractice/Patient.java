package com.kim.jun202.main;

public class Patient {
	private String name;
	private double weight;
	private double height;
	private double bmi;
	private String bmi_result;
	private String image;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	
	public Patient(String name, double weight, double height, double bmi, String bmi_result, String image) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		this.bmi = bmi;
		this.bmi_result = bmi_result;
		this.image = image;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getBmi_result() {
		return bmi_result;
	}

	public void setBmi_result(String bmi_result) {
		this.bmi_result = bmi_result;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
