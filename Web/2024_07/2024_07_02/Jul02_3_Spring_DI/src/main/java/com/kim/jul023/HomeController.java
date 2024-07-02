package com.kim.jul023;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jul023.human.Human;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		AbstractApplicationContext acc = 
				new ClassPathXmlApplicationContext("jul023beans.xml");
		acc.registerShutdownHook();
		
		Human h1 = acc.getBean("h1",Human.class);
		System.out.println(h1.getName());
		System.out.println(h1.getAge());
		
		for (String nn  : h1.getNickname()) {
			System.out.println(nn);
		}
		
		for (String f : h1.getFriend()) {
			System.out.println(f);
		}
		
		System.out.println(h1.getFamily().get("아버지"));
		System.out.println(h1.getFamily().get("어머니"));
		System.out.println(h1.getPet().getName());
		System.out.println(h1.getPet().getAge());
		
		System.out.println("------------");
		System.out.println(h1.getPet2().getName());
		System.out.println(h1.getPet2().getAge());
		
		acc.close();
		return "home";
	}
	
}
