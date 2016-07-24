package com.lin.warehouse.domain;

import java.io.Serializable;

public class SceneOrderAndOrder implements Serializable{

	private static final long serialVersionUID = 5325331142272627380L;
	
	private SceneOrder sceneOrder;
	private OrderInfo orderInfo;
	
	public SceneOrderAndOrder() { 
	}

	public SceneOrderAndOrder(SceneOrder sceneOrder, OrderInfo orderInfo) {
		super();
		this.sceneOrder = sceneOrder;
		this.orderInfo = orderInfo;
	}

	public SceneOrder getSceneOrder() {
		return sceneOrder;
	}

	public void setSceneOrder(SceneOrder sceneOrder) {
		this.sceneOrder = sceneOrder;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
}
