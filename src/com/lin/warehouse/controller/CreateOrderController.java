package com.lin.warehouse.controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.OrderItem;
import com.lin.warehouse.service.IOrderService;

@Controller
public class CreateOrderController {
	
	@Autowired
	private IOrderService orderService;
	
	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	public String createOrder(@ModelAttribute("orderInfo")OrderInfo orderInfo,
			HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		LinkedList<OrderItem> items = (LinkedList<OrderItem>)session.getAttribute("orderItems");
		
		orderService.createOrder(orderInfo, items.subList(0, items.size()));
		
		session.removeAttribute("orderItems");
		
		return "redirect:/getNoProcessOrders";
	}
}
