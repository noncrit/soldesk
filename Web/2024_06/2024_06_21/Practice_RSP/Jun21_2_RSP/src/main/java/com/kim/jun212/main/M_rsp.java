package com.kim.jun212.main;

import java.io.ObjectInputStream.GetField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class M_rsp {
	

	public M_rsp() {
		// TODO Auto-generated constructor stub
	}
	
	private static final M_rsp m =new M_rsp();
	
	public static M_rsp getM_rsp() {
		return m;
	}
	
	public void rsp_main(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		String input=request.getParameter("input");
//		input=URLEncoder.encode(input,"UTF-8"); //쓰면 인코딩되서 인식 못함
		System.out.println(input);
		
		int user_input=-1;
		
		if(input.equals("주먹")) {
			user_input=2;
		}
		else if(input.equals("가위")){
			user_input=1;
		}
		else if(input.equals("보")){
			user_input=3;
		}
		
		int result=rsp(user_input);
		
		Player p =Player.getPlayer();
		
		switch (result) {
		case 0:
			p.plusWin();
			break;
			
		case 1:
			p.plusLose();
			break;
			
		case 2:
			p.plusTie();
			break;
			
		default:
			System.out.println("값 안넘어옴");
			break;
		}
		
		request.setAttribute("Player", p);
		
		/*
		가위 바위 보
		1 2 3
		승 : 1,-2 /+2/ 3 0
		패 : -1,2 /+2/ 1 4
		*/
		
	}
	
	public static int rsp(int user_input) {
		
		int computer=0;
		int decider=0;
		
		
		if(user_input<1 || user_input>3) {
			System.out.println("입력 잘못들어왔음");
		}
		else {
			
			Random r=new Random();
			
			computer=r.nextInt(3)+1;
			
			decider=user_input-computer+2;
			
			if(decider==2) {
				return 2; //tie
			}
			else if(decider%3==0) {
				return 1;  //win
			}
			
		}
		return 0; //lose
	}
	

}
