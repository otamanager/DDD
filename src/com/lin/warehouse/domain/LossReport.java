package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LossReport implements Serializable {

	private static final long serialVersionUID = 7832441040198196197L;
	
	private int id; 
	
	private String code;
	
	private Date createDate;
	
	private String description;
	
	private String warehouseCode;
	
	private String employee;
	
	private List<LossReportItem> lossReportItems = new ArrayList<>();
	
	private OrderInfo orderInfo;

	public LossReport() {
	}

	public LossReport(int id, String code, Date createDate, String description,
			String warehouseCode, String employee,
			List<LossReportItem> lossReportItems, OrderInfo orderInfo) {
		super();
		this.id = id;
		this.code = code;
		this.createDate = createDate;
		this.description = description;
		this.warehouseCode = warehouseCode;
		this.employee = employee;
		this.lossReportItems = lossReportItems;
		this.orderInfo = orderInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public List<LossReportItem> getLossReportItems() {
		return lossReportItems;
	}

	public void setLossReportItems(List<LossReportItem> lossReportItems) {
		this.lossReportItems = lossReportItems;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String toString() {
		return "LossReport [id=" + id + ", code=" + code + ", createDate="
				+ createDate + ", description=" + description
				+ ", warehouseCode=" + warehouseCode + ", employee=" + employee
				+ ", lossReportItems=" + lossReportItems + ", orderInfo="
				+ orderInfo + "]";
	}

}
