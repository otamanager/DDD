package com.lin.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.service.IOrderService;

@Controller
public class GetOrderByTypeController {
	 
	@Autowired
	private IOrderService orderService;

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value="/getOrderByType",method=RequestMethod.GET)
	public ModelAndView getOrderByType(int orderType)
	{
		List<OrderInfo> orders = orderService.getOrdersByType(orderType);
		
		ModelAndView modelAndView = new ModelAndView("WEB-INF/jsp/orderByType","orders",orders);
		
		return modelAndView;
	}

}
