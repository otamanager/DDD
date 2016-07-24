package com.lin.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.service.IOrderService;

@Controller
public class GetNoProcessOrderController {
	
	@Autowired
	private IOrderService orderService;
	
	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value="/getNoProcessOrders",method=RequestMethod.GET)
	public ModelAndView getNoProcessOrder()
	{
		ModelAndView modelAndView = new ModelAndView("WEB-INF/jsp/index", "notProcessOrders",orderService.getNotProcessOrders());
		
		return modelAndView;
	}

}
