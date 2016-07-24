package com.lin.warehouse.controller;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.SceneOrder;

@Controller
public class DisplaySceneOrdersController {
	
	/**
	 * 向仓库值班人员展示现场物资单.
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/displaySceneOrders",method=RequestMethod.GET)
	public ModelAndView displaySceneOrders(HttpServletRequest request)
	{
		Queue<SceneOrder> sceneOrders = (Queue<SceneOrder>) request.getServletContext().getAttribute("sceneOrderQueue");
		
		return new ModelAndView("/WEB-INF/jsp/sceneOrders", "sceneOrders", sceneOrders);
	}
	
	/**
	 * 展示现场物资单的详细信息.
	 * @param request
	 * @param code 现场物资单的编号
	 * @return
	 */
	@RequestMapping(value="/displayScenerOrderDetails",method=RequestMethod.GET)
	public ModelAndView displaySceneOrderDetails(HttpServletRequest request,String code)
	{
		Queue<SceneOrder> sceneOrders = (Queue<SceneOrder>) request.getServletContext().getAttribute("sceneOrderQueue");
		
		for(SceneOrder order : sceneOrders)
		{
			if(order.getCode().equals(code))
			{
				return new ModelAndView("/WEB-INF/jsp/sceneOrderDetails", "sceneOrder", order);
			}
		}
		return new ModelAndView("redict:/displaySceneOrders");
	}
	
	/**
	 * 展示所有未审核的现场物资单.
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/displayNoProcessSceneOrders",method=RequestMethod.GET)
	public ModelAndView displayNoProcessSceneOrders(HttpServletRequest request)
	{
		ServletContext servletContext = request.getServletContext();
		
		Queue<SceneOrder> sceneOrders = (LinkedBlockingDeque<SceneOrder>)servletContext.getAttribute("sceneOrderQueue");
		
		return new ModelAndView("/WEB-INF/jsp/noProcessSceneOrders", "sceneOrders", sceneOrders);
	}

}
