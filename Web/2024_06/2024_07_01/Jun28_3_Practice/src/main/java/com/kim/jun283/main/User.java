package com.kim.jun283.main;

public class User {
	private String j_ID;
	private String j_PW;
	private String j_PWC;
	private String j_NAME;
	private String j_PN;
	private String j_BIRTH;
	private String j_IMG;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String j_ID, String j_PW, String j_IMG) {
		super();
		this.j_ID = j_ID;
		this.j_PW = j_PW;
		this.j_IMG= j_IMG;
	}

	public User(String j_ID, String j_PW, String j_PWC, String j_NAME, String j_PN, String j_BIRTH, String j_IMG) {
		super();
		this.j_ID = j_ID;
		this.j_PW = j_PW;
		this.j_PWC = j_PWC;
		this.j_NAME = j_NAME;
		this.j_PN = j_PN;
		this.j_BIRTH = j_BIRTH;
		this.j_IMG = j_IMG;
	}
	
	

	public User(String j_ID, String j_PW, String j_NAME, String j_PN, String j_BIRTH, String j_IMG) {
		super();
		this.j_ID = j_ID;
		this.j_PW = j_PW;
		this.j_NAME = j_NAME;
		this.j_PN = j_PN;
		this.j_BIRTH = j_BIRTH;
		this.j_IMG = j_IMG;
	}

	public String getJ_ID() {
		return j_ID;
	}

	public void setJ_ID(String j_ID) {
		this.j_ID = j_ID;
	}

	public String getJ_PW() {
		return j_PW;
	}

	public void setJ_PW(String j_PW) {
		this.j_PW = j_PW;
	}

	public String getJ_PWC() {
		return j_PWC;
	}

	public void setJ_PWC(String j_PWC) {
		this.j_PWC = j_PWC;
	}

	public String getJ_NAME() {
		return j_NAME;
	}

	public void setJ_NAME(String j_NAME) {
		this.j_NAME = j_NAME;
	}

	public String getJ_PN() {
		return j_PN;
	}

	public void setJ_PN(String j_PN) {
		this.j_PN = j_PN;
	}

	public String getJ_BIRTH() {
		return j_BIRTH;
	}

	public void setJ_BIRTH(String j_BIRTH) {
		this.j_BIRTH = j_BIRTH;
	}

	public String getJ_IMG() {
		return j_IMG;
	}

	public void setJ_IMG(String j_IMG) {
		this.j_IMG = j_IMG;
	}
	
}
