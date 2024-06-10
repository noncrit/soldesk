package com.kim.db.last;

import java.util.Date;

//DTO, VO, JavaBin 라고 부름
public class Reservation {
	//예약 정보를 받아올 객체
	private int no;
	private String name;
	private Date when;
	private String phone;
	private String location;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	//생성자 오버로딩
	public Reservation(int no, String name, Date when, String phone, String location) {
		super();
		this.no = no;
		this.name = name;
		this.when = when;
		this.phone = phone;
		this.location = location;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
