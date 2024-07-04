package com.kim.jul042.exam;

import java.math.BigDecimal;

public class Exam {
	private String e_name;
	private BigDecimal e_date_year;
	private BigDecimal e_date_month;
	private BigDecimal e_date_day;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Exam(String e_name, BigDecimal e_date_year, BigDecimal e_date_month, BigDecimal e_date_day) {
		super();
		this.e_name = e_name;
		this.e_date_year = e_date_year;
		this.e_date_month = e_date_month;
		this.e_date_day = e_date_day;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public BigDecimal getE_date_year() {
		return e_date_year;
	}

	public void setE_date_year(BigDecimal e_date_year) {
		this.e_date_year = e_date_year;
	}

	public BigDecimal getE_date_month() {
		return e_date_month;
	}

	public void setE_date_month(BigDecimal e_date_month) {
		this.e_date_month = e_date_month;
	}

	public BigDecimal getE_date_day() {
		return e_date_day;
	}

	public void setE_date_day(BigDecimal e_date_day) {
		this.e_date_day = e_date_day;
	}
	
	
	
}
