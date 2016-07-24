package com.lin.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.service.IOrderService;

@Controller
public class GetOrderDetailsController { 
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="/orderDetails",method=RequestMethod.GET)
	public ModelAndView getOrderDetails(int id)
	{
		OrderInfo orderInfo = orderService.getOrderDetails(id);
		
		ModelAndView modelAndView = new ModelAndView("WEB-INF/jsp/orderDetails","order",orderInfo);
		
		return modelAndView;
	}

}
