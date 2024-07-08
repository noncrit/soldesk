package com.kim.jul82;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kim.jul82.fruit.Fruit;
import com.kim.jul82.fruit.FruitDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private FruitDAO fDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Fruit f, HttpServletRequest req) {
		
		fDAO.getAllFruit(f, req);
		//여기 또 index.jsp로 써놨지...
		return "index";
	}
	
}
