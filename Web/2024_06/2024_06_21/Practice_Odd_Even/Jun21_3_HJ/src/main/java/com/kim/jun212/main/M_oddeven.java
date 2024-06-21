package com.kim.jun212.main;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M_oddeven {
	
	private int win=0;
	private int lose=0;
	
	public M_oddeven() {
		// TODO Auto-generated constructor stub
	}
	
	private static final M_oddeven oe=new M_oddeven();

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public static M_oddeven getOe() {
		return oe;
	}
	
	public void odd_even_game(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String input=request.getParameter("input");
		
		int user_input=0;
		
		if(input.equals("홀")) {
			user_input=1;
		}
		else if(input.equals("짝")) {
			user_input=2;
		}
		
		Random r = new Random();
		
		int[] coins=new int[10];
		int total=10;
		int odd=0;
		
		for (int i = 0; i < coins.length; i++) {
			coins[i]=r.nextInt(2)+1;
			if(coins[i]%2!=0) {
				odd++;
				request.setAttribute("coin"+i,"img/etc.jpg" );
			}
			else {
				request.setAttribute("coin"+i,"img/predator.jpg" );
			}
		}
		
		
//		for(int j=0;j<10;j++) {
//			request.setAttribute("coin"+j, converter(coins[j]));
//		}
		
		if(user_input==1&&(odd%2!=0) ){
			oe.win++;
			request.setAttribute("game_result", "승리");
		}
		else {
			oe.lose++;
			request.setAttribute("game_result", "패배");
		}
		double total_game=oe.win+oe.lose;
		
		double win_rate=(double)oe.win/total_game;
		win_rate=Math.round(win_rate*100);
		
		request.setAttribute("win_rate", win_rate);
		request.setAttribute("win", oe.win);
		request.setAttribute("lose", oe.lose);
	}
	
//	public String decider(int user_input, int result) {
//		String output;
//		return output = (user_input==result)?"승리":"패배";
//		
//	}
	
	public String converter(int a) {
		String output;
		return output=(a%2!=0)?"앞":"뒤";
	}
	
	public void reset() {
		oe.win=0;
		oe.lose=0;
	}
}
