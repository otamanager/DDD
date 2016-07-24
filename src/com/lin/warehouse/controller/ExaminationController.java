package com.lin.warehouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.SceneOrder;
import com.lin.warehouse.domain.SceneOrderAndOrder;
import com.lin.warehouse.domain.WarehouseEmployee;
import com.lin.warehouse.service.IOrderService;

@Controller
public class ExaminationController {
	
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 获取现场物资单和订单详细信息.
	 * @param request
	 * @param code 现场物资单编号
	 * @param orderCode 订单编号
	 * @return
	 */
	@RequestMapping(value="/displayScenerOrderAndOrder",method=RequestMethod.GET)
	public ModelAndView displaySceneOrderAndOrder(
			HttpServletRequest request,String code,String orderCode)
	{
		Queue<SceneOrder> sceneOrders = (LinkedBlockingDeque<SceneOrder>) request.getServletContext().getAttribute("sceneOrderQueue");
		
		SceneOrderAndOrder sceneOrderAndOrder = new SceneOrderAndOrder();
		
		for(SceneOrder sceneOrder : sceneOrders)
		{
			if(sceneOrder.getCode().equals(code))
			{
				sceneOrderAndOrder.setSceneOrder(sceneOrder);
			}
		}
		
		OrderInfo orderInfo = orderService.getOrderInfoByCode(orderCode);
		System.out.println(orderInfo.getOrderItems());
		sceneOrderAndOrder.setOrderInfo(orderInfo);
		
		return new ModelAndView("/WEB-INF/jsp/sceneOrderAndOrder", "sceneOrderAndOrderInfo", sceneOrderAndOrder);
	}
	
	@RequestMapping(value="/examine",method=RequestMethod.GET)
	public String examine(HttpServletRequest request,int isPass,String sceneOrderCode,String orderCode)
	{
		OrderInfo orderInfo = orderService.getOrderInfoByCode(orderCode);
		
		for(SceneOrder order : 
			(LinkedBlockingDeque<SceneOrder>)request.getServletContext().getAttribute("sceneOrderQueue"))
		{
			if(order.getCode().equals(sceneOrderCode))
			{
				order.setIsPass(isPass);
				System.out.println("-------------------------isPass?"+isPass);
			}
		}
		if(isPass == 1)//审核通过
		{
			orderInfo.setState(2);//订单状态更新为进/出库中
		}
		
		orderService.update(orderInfo);
		
		return "redirect:/displayNoProcessSceneOrders";
	}
	
	@RequestMapping(value="/displayExamination",method=RequestMethod.GET)
	public ModelAndView displayExamination(HttpServletRequest request)
	{
		Queue<SceneOrder> sceneOrders = 
				(LinkedBlockingDeque<SceneOrder>)request.getServletContext().getAttribute("sceneOrderQueue");
		
		List<SceneOrder> employeeOrders = new ArrayList<SceneOrder>();
		
		for(SceneOrder order : sceneOrders)
		{
			if(order.getCreator().equals(
					((WarehouseEmployee)(
							request.getSession().getAttribute("warehouseEmployee"))).getName()))
			{
				employeeOrders.add(order);
			}
		}
		
		return new ModelAndView("WEB-INF/jsp/examinationResult", "sceneOrders", employeeOrders);
	}

}
