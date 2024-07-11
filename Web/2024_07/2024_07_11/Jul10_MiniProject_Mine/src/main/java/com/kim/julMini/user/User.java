package com.kim.julMini.user;

import java.math.BigDecimal;

public class User {
	private BigDecimal user_code;
	private String name;
	private BigDecimal win=BigDecimal.valueOf(0);
	private BigDecimal lose=BigDecimal.valueOf(0);
	private BigDecimal total_play;
	
	private static final User user = new User();
	
	private User() {
		// TODO Auto-generated constructor stub
	}
	
	public static User getUser() {
		return user;
	}
	
	public User(BigDecimal user_code, String name, BigDecimal win, BigDecimal lose, BigDecimal total_play) {
		super();
		this.user_code = user_code;
		this.name = name;
		this.win = win;
		this.lose = lose;
		this.total_play = total_play;
	}

	public BigDecimal getUser_code() {
		return user_code;
	}

	public void setUser_code(BigDecimal user_code) {
		this.user_code = user_code;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getWin() {
		return win;
	}
	
	public void plusWin() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal sum = win.add(num1);
		setWin(sum);
	}
	
	public void setWin(BigDecimal win) {
		this.win = win;
	}

	public BigDecimal getLose() {
		return lose;
	}
	
	public void plusLose() {
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal sum = lose.add(num1);
		setLose(sum);
	}
	
	public void setLose(BigDecimal lose) {
		this.lose = lose;
	}

	public BigDecimal getTotal_play() {
		return total_play;
	}
	
	public void setTotal_play(BigDecimal total_play) {
		this.total_play = total_play;
	}
	
	public void calcTotal_play() {
		BigDecimal total_play = getWin().add(getLose());
		setTotal_play(total_play);
	}
	
	
	

}
