package com.lin.warehouse.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContextFactory;

import com.lin.warehouse.dao.InventoryReportItemMapper;
import com.lin.warehouse.dao.InventoryReportMapper;
import com.lin.warehouse.dao.LossReportItemMapper;
import com.lin.warehouse.dao.LossReportMapper;
import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.dao.OrderInfoMapper;
import com.lin.warehouse.dao.OrderItemMapper;
import com.lin.warehouse.domain.InventoryReport;
import com.lin.warehouse.domain.InventoryReportItem;
import com.lin.warehouse.domain.LossReport;
import com.lin.warehouse.domain.LossReportItem;
import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.OrderItem;
import com.lin.warehouse.domain.SceneOrder;
import com.lin.warehouse.service.IOrderService;

public class OrderServiceImpl extends BaseServiceImpl<OrderInfo> implements IOrderService {
	
	private OrderInfoMapper orderInfoMapper;
	private OrderItemMapper orderItemMapper;
	
	private InventoryReportMapper inventoryReportMapper;
	private InventoryReportItemMapper inventoryReportItemMapper;
	
	private LossReportMapper lossReportMapper; 
	private LossReportItemMapper lossReportItemMapper;
	
	public static final int WAREHOUSE_IN_ORDER = 1;
	public static final int WAREHOUSE_OUT_ORDER = 2;
	public static final int WAREHOUSE_MOVE_ORDER = 3;
	public static final int WAREHOUSE_SEND_ORDER = 4;

	public OrderInfoMapper getOrderInfoMapper() {
		return orderInfoMapper;
	}

	public void setOrderInfoMapper(OrderInfoMapper orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
	}

	public InventoryReportMapper getInventoryReportMapper() {
		return inventoryReportMapper;
	}

	public void setInventoryReportMapper(InventoryReportMapper inventoryReportMapper) {
		this.inventoryReportMapper = inventoryReportMapper;
	}

	public InventoryReportItemMapper getInventoryReportItemMapper() {
		return inventoryReportItemMapper;
	}

	public void setInventoryReportItemMapper(
			InventoryReportItemMapper inventoryReportItemMapper) {
		this.inventoryReportItemMapper = inventoryReportItemMapper;
	}

	public LossReportMapper getLossReportMapper() {
		return lossReportMapper;
	}

	public void setLossReportMapper(LossReportMapper lossReportMapper) {
		this.lossReportMapper = lossReportMapper;
	}

	public OrderItemMapper getOrderItemMapper() {
		return orderItemMapper;
	}

	public void setOrderItemMapper(OrderItemMapper orderItemMapper) {
		this.orderItemMapper = orderItemMapper;
	}

	public LossReportItemMapper getLossReportItemMapper() {
		return lossReportItemMapper;
	}

	public void setLossReportItemMapper(LossReportItemMapper lossReportItemMapper) {
		this.lossReportItemMapper = lossReportItemMapper;
	}

	public OrderServiceImpl(Mapper<OrderInfo> mapper) {
		super(mapper);
		this.orderInfoMapper = (OrderInfoMapper)mapper; 
	}

	@Override
	public void addOrderItems(OrderInfo orderInfo,
			List<OrderItem> orderItems) {
		if(orderInfo != null && !orderItems.isEmpty())
		{
			for(OrderItem orderItem : orderItems)
			{
				orderItem.setOrderInfo(orderInfo);
				System.out.println("外键："+orderItem.getOrderInfo().getId());
				
				orderItemMapper.create(orderItem);
			}
		}
	}

	@Override
	public OrderInfo getOrderInfoByCode(String code) {
		
		if(code != null && code.length() != 0)
		{
			return orderInfoMapper.readByCode(code);
		}
		return null;
	}

	@Override
	public void addInventoryReport(OrderInfo orderInfo,
			InventoryReport inventoryReport,List<InventoryReportItem> inventoryItems) 
	{
		if(orderInfo != null && inventoryReport != null && !inventoryItems.isEmpty())
		{
			inventoryReport.setOrderInfo(orderInfo);
			inventoryReportMapper.create(inventoryReport);
			
			inventoryReport = inventoryReportMapper.readByCode(inventoryReport.getCode());
			
			for(InventoryReportItem inventoryReportItem : inventoryItems)
			{
				inventoryReportItem.setInventoryReport(inventoryReport);
				inventoryReportItemMapper.create(inventoryReportItem);
			}
		}
	}

	@Override
	public void addLossReport(OrderInfo orderInfo, LossReport lossReport,
			List<LossReportItem> lossReportItems) {
		
		if(orderInfo != null && lossReport != null && !lossReportItems.isEmpty())
		{
			lossReport.setOrderInfo(orderInfo);
			lossReportMapper.create(lossReport);
			
			lossReport = lossReportMapper.readByCode(lossReport.getCode());
			
			for(LossReportItem lossReportItem : lossReportItems)
			{
				lossReportItem.setLossReport(lossReport);
				lossReportItemMapper.create(lossReportItem);
			}
		}
	}

	@Override
	public List<OrderInfo> getNotProcessOrders() {
		
		return orderInfoMapper.readByOrderState(0);
	}

	@Override
	public List<OrderInfo> getOrdersByType(int orderType) {
		
		return orderInfoMapper.readByOrderType(orderType);
	}

	@Override
	public OrderInfo getOrderDetails(int id) {
		
		OrderInfo orderInfo = read(id);
		
		List<InventoryReportItem> inventoryReportItems =
				inventoryReportItemMapper.readByInventoryReportId(orderInfo.getInventoryReport().getId());
		
		List<LossReportItem> lossReportItems = 
				lossReportItemMapper.readByLossReportId(orderInfo.getLossReport().getId());
		
		orderInfo.getInventoryReport().setInventoryReportItems(inventoryReportItems);
		orderInfo.getLossReport().setLossReportItems(lossReportItems);
		
		return orderInfo;
	}
	
	/**
	 * 添加一项订单物资.<br/>
	 * 注意，该方法由DWR调用，否则WebContextFactory等API无效.
	 * @param itemName 物资名称
	 * @param itemCount 物资数量
	 * @param itemValue 物资价值
	 */
	public void addItem(String itemName,int itemCount,double itemValue)
	{
		OrderItem orderItem = new OrderItem();
		orderItem.setName(itemName);
		orderItem.setCount(itemCount);
		orderItem.setMaterialValue(itemValue);
		
		HttpSession session = WebContextFactory.get().getSession();//获取当前请求的Session
		
		@SuppressWarnings("unchecked")
		LinkedList<OrderItem> items = (LinkedList<OrderItem>)session.getAttribute("orderItems");
		if(items == null)
		{
			items = new LinkedList<OrderItem>();
		}
		items.addLast(orderItem);
		session.setAttribute("orderItems",items);
	}
	
	/**
	 * 删除物资项，删除队列中的最后一项.<br/>
	 * 注意，该方法由DWR调用，否则WebContextFactory等API无效.
	 */
	public void deleteItem()
	{
		HttpSession session = WebContextFactory.get().getSession();
		
		@SuppressWarnings("unchecked")
		LinkedList<OrderItem> orderItems = (LinkedList<OrderItem>)session.getAttribute("orderItems");
		OrderItem orderItem = orderItems.removeLast();
		System.out.println(orderItem);
		session.setAttribute("orderItems",orderItems);
	}

	@Override
	public void createOrder(OrderInfo orderInfo, List<OrderItem> orderItems) {
		
		if(orderInfo != null && orderItems != null && !orderItems.isEmpty())
		{
			orderInfo.setCode(UUID.randomUUID().toString());
			orderInfo.setComeDate(new Date());
			orderInfo.setState(0);
			create(orderInfo);
			
			orderInfo = orderInfoMapper.readByCode(orderInfo.getCode());
			
			addOrderItems(orderInfo, orderItems);
		}
	}
	
	/**
	 * 查询现场未审核的物资单.
	 * 注意，该方法由DWR调用，否则WebContextFactory等API无效.
	 * @return
	 */
	public int getSceneOrderCount()
	{
		ServletContext servletContext = WebContextFactory.get().getServletContext();
		Queue<SceneOrder> sceneOrders = 
				(LinkedBlockingDeque<SceneOrder>) servletContext.getAttribute("sceneOrderQueue");
		
		int count = 0;
		
		for(SceneOrder order : sceneOrders)
		{
			if(order.getIsPass() == 0)
			{
				count++;
			}
		}
		return count;
	}

}
