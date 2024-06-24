package com.kim.jun241.main;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M_computer {
	
	private int count=0;
	private int[] num_arr= new int[3];
	private int strike=0;
	private int strike_counter=0;
	private int ball=0;
	private int[] computer_arr=new int[3];
	
	
	public M_computer() {
		super();
		computer_arr=randomArray(computer_arr);
	}
	
	private static final M_computer mc = new M_computer();
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int[] getNum_arr() {
		return num_arr;
	}

	public void setNum_arr(int[] num_arr) {
		this.num_arr = num_arr;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}
	
	public void plusStrike(int strike) {
		this.strike++;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}
	
	public void plusBall(int ball) {
		this.ball++;
	}
	
	public void plusCount(int count) {
		this.count++;
	}

	public static M_computer getMc() {
		return mc;
	}
	
	public int[] randomArray(int[] arr) {
		Random r = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=r.nextInt(9);	
		}
		
		arr=isDuplicate(arr);
		
		return arr;	
	}
	
	public int[] isDuplicate(int[] arr) {
		int token=0;
		int tmp=0;
		
		Random r = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			token=arr[i];
			for (int j = i+1; j <= arr.length-1; j++) {
				if(arr[j]==token) {
					arr[j]=r.nextInt(9);
					j--;
				}
				
			}	
		}
		return arr;
	}

	public boolean isNumberic(String str) {
		        return str.matches("[+-]?\\d*(\\.\\d+)?");
	}
	
	public boolean isSame(int user,int computer) {
		boolean result;
		return result=(user==computer)?true:false;
	}
	
	public void isStrike2(int[] user, HttpServletRequest request) {
		for (int i = 0; i < user.length; i++) {
			if(isSame(computer_arr[i], user[i])){
				plusStrike(mc.strike);
			}
		}
		mc.strike_counter=mc.strike;
		request.setAttribute("strike", mc.strike);
		mc.setStrike(0);
	}
	
	public void isBall2(int[] user, HttpServletRequest request) {
		for (int i = 0; i < user.length-1; i++) {
			
			for (int j = i+1; j < user.length; j++) {
				
				if(isSame(user[i], computer_arr[j] )) {
					plusBall(mc.ball);
				}
				
			}
		}
		request.setAttribute("ball", mc.ball);
		mc.setBall(0);
	}
	
	
	public void play(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		//for check
		for (int i = 0; i < mc.computer_arr.length; i++) {
			System.out.print(computer_arr[i]);
		}
		System.out.println("\n--------");
		
		String num=(String) request.getParameter("input");
		System.out.println(num);
		
		//그냥 split 쓰면 되는거 왜 이걸쓰냐
		//StringTokenizer st = new StringTokenizer(num,"");
		
		String[] user_input_raw=new String[3];
		
	if(!num.isEmpty()) {
		user_input_raw=num.split("");
		int[] user_input = new int[3];
		
		for (int i = 0; i < user_input_raw.length; i++) {
			user_input[i]=Integer.parseInt(user_input_raw[i]);
		}
		
		
		//스트라이크 판정
//		for (int i = 0; i < user_input.length; i++) {
//			if(isStrike(computer_arr[i], user_input[i])){
//				plusStrike(mc.strike);
//			}
//		}
//		request.setAttribute("strike", mc.strike);
//		mc.setStrike(0);
		isStrike2(user_input, request);
		
		
		//볼 판정
//		for (int i = 0; i < user_input.length-1; i++) {
//			
//			for (int j = i+1; j < user_input.length; j++) {
//				
//				if(isBall(user_input[i], computer_arr[j] )) {
//					plusBall(mc.ball);
//				}
//				
//			}
//		}
//		request.setAttribute("ball", mc.ball);
//		mc.setBall(0);
		isBall2(user_input, request);
		
		//시행 횟수 증가
		plusCount(mc.count);
		request.setAttribute("count", mc.count);
		
		String result;
		System.out.println("strike: "+getStrike());
		
		if(mc.strike_counter>=3) {
			result="Correct!";
			request.setAttribute("result", result);
			mc.setStrike(0);
			mc.setBall(0);
			mc.setCount(0);
			request.setAttribute("con", "<script>alert('ㅊㅋㅊㅋ');</script>)");
		}
		else {
			result="Wrong Number";
			request.setAttribute("result", result);
		}
		
	}//end of isempty
	}
}//end of class
