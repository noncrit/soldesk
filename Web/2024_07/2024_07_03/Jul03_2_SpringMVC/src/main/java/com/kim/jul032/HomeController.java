package com.kim.jul032;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
JSP Model 2
http://IP:port/프로젝트명/컨트롤러파일명
이 때, 컨트롤러 역할을 Servlet에서 담당했음 - 흐름 제어 및, 서비스 최초 실행 역할을 담당했음
doGET, doPOST를 활용 가능함
주소에 컨트롤러명이 들어간다, 컨트롤러 하나당 get 1개, post 1개만 받을 수 있었음
=>컨트롤러 파일의 갯수가 엄청나게 많아졌음

Spring MVC
https://IP:port/top-level-package의 마지막 자리/임의의 지정한 값
이때, Controller는 일반적인 자바 클래스가 담당함 - 흐름제어 역시 자바 메소드로 처리
컨트롤러 하나로 여러 요청 처리가 가능함 -> 컨트롤러의 수 대폭 줄어듬

 */


@Controller
public class HomeController {
	
	//사이트에 첫 접속시 method : GET
	//value에는 아무것도 쓰지 않은 상태  : 첫 접속시에는 최초 페이지로 가야하니
	
	//hehehe.test 로 GET 방식의 요청이 들어오면 index.jsp로 포워딩해주는 메소드 하나
	//lalala.test라는 주소로 GET 방식의 요청이 들어오면 '랄랄라~'라는 내용이 콘솔에 출력되는 메소드
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		
		//servlet-context.xml의 prefix,suffix 선언에 의해 index를 리턴하면 index.jsp로 포워딩
		return "index";
	}
	
	@RequestMapping(value = "/hehehe.test", method = RequestMethod.GET)
	public String hehehe() {
		
		return "index";
	}
	

	@RequestMapping(value = "/lalala.test", method = RequestMethod.GET)
	public String lalala() {
		
		System.out.println("랄랄라~~~");
		
		return "index";
	}
	
}
