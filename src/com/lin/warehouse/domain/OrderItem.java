package com.lin.warehouse.domain;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = -2164773203905078746L;
	
	private int id; 
	
	private String name;
	
	private int count;
	
	private double materialValue;
	
	private OrderInfo orderInfo;

	public OrderItem() {
	}

	public OrderItem(int id, String name, int count, double materialValue,
			OrderInfo orderInfo) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.materialValue = materialValue;
		this.orderInfo = orderInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getMaterialValue() {
		return materialValue;
	}

	public void setMaterialValue(double materialValue) {
		this.materialValue = materialValue;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", name=" + name + ", count=" + count
				+ ", materialValue=" + materialValue + ", orderInfo="
				+ orderInfo + "]";
	}

}
