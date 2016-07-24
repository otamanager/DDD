package com.lin.warehouse.controller;

import java.util.Date;
import java.util.Queue;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.SceneOrder;
import com.lin.warehouse.domain.WarehouseEmployee;

@Controller
public class CreateSceneOrderController {
	
	@RequestMapping(value="/createSceneOrder",method=RequestMethod.POST)
	public ModelAndView createSceneOrder(HttpServletRequest request,@ModelAttribute(value="sceneOrder")SceneOrder sceneOrder)
	{	
		if(sceneOrder != null)
		{
			Queue<SceneOrder> sceneOrders = 
					(Queue<SceneOrder>) request.getServletContext().getAttribute("sceneOrderQueue");
			
			sceneOrder.setCode(UUID.randomUUID().toString());
			
			HttpSession session = request.getSession();
			
			sceneOrder.setCreator(((WarehouseEmployee)session.getAttribute("warehouseEmployee")).getName());
			sceneOrder.setCreateDate(new Date());
			
			sceneOrders.add(sceneOrder);
		}
		
		return new ModelAndView("redict:/displaySceneOrders");
	}
}
