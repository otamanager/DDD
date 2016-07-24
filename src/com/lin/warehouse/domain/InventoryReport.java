package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryReport implements Serializable {

	private static final long serialVersionUID = -7156786525344324203L;
	
	private int id; 
	
	private String code;
	
	private Date createDate;
	
	private String description;
	
	private String employeeName;
	
	private String warehouseCode;
	
	private String employeeCode;
	
	private List<InventoryReportItem> inventoryReportItems = new ArrayList<>();
	
	private OrderInfo orderInfo;

	public InventoryReport() {
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public List<InventoryReportItem> getInventoryReportItems() {
		return inventoryReportItems;
	}

	public void setInventoryReportItems(
			List<InventoryReportItem> inventoryReportItems) {
		this.inventoryReportItems = inventoryReportItems;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String toString() {
		return "InventoryReport [id=" + id + ", code=" + code + ", createDate="
				+ createDate + ", description=" + description
				+ ", employeeName=" + employeeName + ", warehouseCode="
				+ warehouseCode + ", employeeCode=" + employeeCode
				+ ", inventoryReportItems=" + inventoryReportItems
				+ ", orderInfo=" + orderInfo + "]";
	}
}
