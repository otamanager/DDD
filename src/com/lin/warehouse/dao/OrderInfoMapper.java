package com.lin.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.OrderInfo;

public interface OrderInfoMapper extends Mapper<OrderInfo> { 
	
	public OrderInfo readByCode(@Param(value="code") String code);
	
	public List<OrderInfo> readByOrderState(@Param(value="state")int state);
	
	public List<OrderInfo> readByOrderType(@Param(value="orderType")int orderType);

}
