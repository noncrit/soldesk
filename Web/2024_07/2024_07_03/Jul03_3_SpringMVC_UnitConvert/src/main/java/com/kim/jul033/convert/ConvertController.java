package com.kim.jul033.convert;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvertController {
	
	@Autowired
	private ConvertDAO cDAO;
	
	@RequestMapping(value = "convert.do", method = RequestMethod.POST)
	public String output(HttpServletRequest request) throws UnsupportedEncodingException {
		
		cDAO.convert2(request);
		
		return "output";
	}
}
