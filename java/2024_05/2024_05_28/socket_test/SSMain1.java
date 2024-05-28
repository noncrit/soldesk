package com.kim.may_28_2.main;
//server side

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SSMain1 {
	
		public static void main(String[] args) {
			
		
			try {
			
				ServerSocket ss =null;
				ss = new ServerSocket();
			
				Socket s = ss.accept();
				System.out.println("연결됨!!");
			
				Scanner k = new Scanner(System.in);
			
				OutputStream os = s.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw = new BufferedWriter(osw);
			
				while(true) {
					System.out.println("나]");
					String msg = k.next();
					bw.write(msg + "\r\n");
					bw.flush();
				}
		
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
}



