package com.kim.jul022;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jul022.book.Book;
import com.kim.jul022.dog.Dog;

@Controller
public class HomeController {
	
	//Spring : Java에서 IoC로 DI 해주는 FrameWork
	//예전에는 객체를 자바에서만 만들어서 넘겨줬다면, 이제는 외부파일에서 객체를 만들어서 .java를 호출해서 사용할 예정
	//IoC : Inversion Of Control 제어의 역전 - 일반적인 디자인 패턴 중 하나
	// 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부(파일)에서 관리하는 것
	//DI : 의존성 주입(Dependency Injection) : 제어의 역전 패턴을 달성하는 방법론의 하나
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//원래 개체 만들던 방식
		Dog dog = new Dog("개",3);
		System.out.println(dog.getName());
		System.out.println(dog.getAge());
		
		//우리가 만든 xml 파일 불러오기 -> xml파일에 등록해놓은 객체를 만들어서
		
		AbstractApplicationContext aac =
				new ClassPathXmlApplicationContext("jul022beans.xml");
		//aac가 없어질 때 등록해놓은 객체들은 다 없애기
		aac.registerShutdownHook();
		
		//id가 d인 강아지 객체를 불러오기
		Dog d = aac.getBean("d",Dog.class);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		
		//setter 기반의 객체 생성
		System.out.println("------------------");
		Dog d2 = aac.getBean("d2",Dog.class);
		System.out.println(d2.getName());
		System.out.println(d2.getAge());
		
		//constructor 기반의 객체 생성
		System.out.println("------------------");
		Dog d3 = aac.getBean("d3",Dog.class);
		System.out.println(d3.getName());
		System.out.println(d3.getAge());
		
		System.out.println("--------------------");
		//책 객체를 만들어서 각 방법으로 이름-가격 출력
		Book b1 = aac.getBean("b1",Book.class);
		Book b2= aac.getBean("b2",Book.class);
		
		System.out.println(b1.getTitle());
		System.out.println(b1.getPrice());
		
		System.out.println("------");
		System.out.println(b2.getTitle());
		System.out.println(b2.getPrice());
		
		
		
		
		
		//aac 없애기
		aac.close();
		
		return "home";
	}
	
}
