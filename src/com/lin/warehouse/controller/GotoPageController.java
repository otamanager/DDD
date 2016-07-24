package com.lin.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GotoPageController { 
	
	@RequestMapping(value="/gotoPage",method=RequestMethod.GET)
	public ModelAndView gotoPage(String page)
	{
		return new ModelAndView("WEB-INF/jsp/"+page);
	}

}
