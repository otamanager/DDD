package com.lin.warehouse.service;

import java.util.List;

import com.lin.warehouse.domain.InventoryReport;
import com.lin.warehouse.domain.InventoryReportItem;
import com.lin.warehouse.domain.LossReport;
import com.lin.warehouse.domain.LossReportItem;
import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.OrderItem;

public interface IOrderService extends IBaseService<OrderInfo> { 

	/**
	 * 添加订单项目.
	 * @param orderInfo 订单信息
	 * @param orderItems 订单项列表
	 */
	public void addOrderItems(OrderInfo orderInfo, List<OrderItem> orderItems);

	/**
	 * 通过订单编号查询订单.
	 * @param code 订单编号
	 * @return
	 */
	public OrderInfo getOrderInfoByCode(String code);

	/**
	 * 提交物资盘点单.
	 * @param orderInfo 订单
	 * @param inventoryReport 盘点单信息
	 * @param inventoryItems 盘点单物资项列表
	 */
	public void addInventoryReport(OrderInfo orderInfo,
			InventoryReport inventoryReport,List<InventoryReportItem> inventoryItems);
	
	/**
	 * 提交物资报损单.
	 * @param orderInfo 订单信息
	 * @param lossReport 报损单信息
	 * @param lossReportItems 报损单物资项列表
	 */
	public void addLossReport(OrderInfo orderInfo,
			LossReport lossReport,List<LossReportItem> lossReportItems);
	
	/**
	 * 获得未处理的订单
	 * @return
	 */
	public List<OrderInfo> getNotProcessOrders();
	
	/**
	 * 获取不同类型的订单.
	 * @param orderType
	 * @return
	 */
	public List<OrderInfo> getOrdersByType(int orderType);
	
	/**
	 * 获取订单的全部信息.
	 * @param id
	 * @return
	 */
	public OrderInfo getOrderDetails(int id);
	
	/**
	 * 创建订单.
	 * @param orderInfo 订单基本信息
	 * @param orderItems 订单物资项
	 */
	public void createOrder(OrderInfo orderInfo,List<OrderItem> orderItems);

}
