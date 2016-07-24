package com.lin.warehouse.listener;

import java.util.Date;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lin.warehouse.domain.SceneOrder;

/**
 * 加载现场入库/出库订单容器.
 * @author lin
 *
 */ 
public class LoadSceneOrderContainerListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		/**
		 * 保存容器中未审核的现场入库/出库单
		 */
		System.out.println("保存容器中未审核的现场入库/出库单");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		Queue<SceneOrder> sceneOrderQueue = new LinkedBlockingDeque<>();
		
		//用作测试的数据
		for(int i=0;i<10;i++)
		{
			SceneOrder sceneOrder = new SceneOrder();
			sceneOrder.setCode(UUID.randomUUID().toString());
			sceneOrder.setOrderCode("58822f66-e7d9-4181-a329-3169a4daab9f");
			sceneOrder.setCarrier("刘智");
			sceneOrder.setCreateDate(new Date());
			sceneOrder.setCreator("陈永仁");
			sceneOrder.setDescription("备注信息.");
			sceneOrder.setTackelNumber("粤A00001");
			sceneOrder.setTackelType("大型货柜车");
			sceneOrder.setSceneOrderType(1);
			
			sceneOrderQueue.add(sceneOrder);
		}
		
		//在servlet容器初始化的时候就创建现场单队列并注入servlet容器
		event.getServletContext().setAttribute("sceneOrderQueue", sceneOrderQueue);
	}

}
