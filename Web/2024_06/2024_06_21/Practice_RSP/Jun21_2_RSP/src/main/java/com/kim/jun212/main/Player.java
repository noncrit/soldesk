package com.kim.jun212.main;

public class Player {
	private int win=0;;
	private int lose=0;
	private int tie=0;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	private static final Player player=new Player();

	public Player(int win, int lose, int tie) {
		super();
		this.win = win;
		this.lose = lose;
		this.tie = tie;
	}
	//외부에서 객체를 호출 시 사용할 메소드
	public static Player getPlayer() {
		return player;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
	public void plusWin() {
		this.win++;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}
	
	public void plusLose() {
		this.lose++;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}
	
	public void plusTie() {
		this.tie++;
	}
	
	public void reset() {
		this.win=0;
		this.lose=0;
		this.tie=0;
	}
	
}
