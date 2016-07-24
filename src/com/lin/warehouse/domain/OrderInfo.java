package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 3462642514777685958L;
	
	private int id; 
	
	private String code;
	
	private Date comeDate;
	
	private int isSpread;//是否分批�?：是	0：否
	
	private String signature;
	
	private String tackel;
	
	private int state;//订单状�?�?：待处理	1：已配�?	2：进�?出库�?3：已完成
	
	private String company;
	
	private String sourceLocation;
	
	private String destinationLocation;
	
	private int priority;//紧�?等级�?�?0
	
	private String tel;
	
	private String description;
	
	private int orderType;//订单类型�?：入库订�?	2：出库订�?	3：移仓订�?	4：配送订�?
	private String fromWarehouseCode;
	
	private String toWarehouseCode;
	
	private List<OrderItem> orderItems = new ArrayList<>();
	
	private InventoryReport inventoryReport;
	
	private LossReport lossReport;

	public OrderInfo() {
	}

	public OrderInfo(int id, String code, Date comeDate, int isSpread,
			String signature, String tackel, int state, String company,
			String sourceLocation, String destinationLocation, int priority,
			String tel, String description, int orderType,
			String fromWarehouseCode, String toWarehouseCode,
			List<OrderItem> orderItems, InventoryReport inventoryReport,
			LossReport lossReport) {
		this.id = id;
		this.code = code;
		this.comeDate = comeDate;
		this.isSpread = isSpread;
		this.signature = signature;
		this.tackel = tackel;
		this.state = state;
		this.company = company;
		this.sourceLocation = sourceLocation;
		this.destinationLocation = destinationLocation;
		this.priority = priority;
		this.tel = tel;
		this.description = description;
		this.orderType = orderType;
		this.fromWarehouseCode = fromWarehouseCode;
		this.toWarehouseCode = toWarehouseCode;
		this.orderItems = orderItems;
		this.inventoryReport = inventoryReport;
		this.lossReport = lossReport;
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

	public Date getComeDate() {
		return comeDate;
	}

	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}

	public int getIsSpread() {
		return isSpread;
	}

	public void setIsSpread(int isSpread) {
		this.isSpread = isSpread;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTackel() {
		return tackel;
	}

	public void setTackel(String tackel) {
		this.tackel = tackel;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getFromWarehouseCode() {
		return fromWarehouseCode;
	}

	public void setFromWarehouseCode(String fromWarehouseCode) {
		this.fromWarehouseCode = fromWarehouseCode;
	}

	public String getToWarehouseCode() {
		return toWarehouseCode;
	}

	public void setToWarehouseCode(String toWarehouseCode) {
		this.toWarehouseCode = toWarehouseCode;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public InventoryReport getInventoryReport() {
		return inventoryReport;
	}

	public void setInventoryReport(InventoryReport inventoryReport) {
		this.inventoryReport = inventoryReport;
	}

	public LossReport getLossReport() {
		return lossReport;
	}

	public void setLossReport(LossReport lossReport) {
		this.lossReport = lossReport;
	}

	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", code=" + code + ", comeDate="
				+ comeDate + ", isSpread=" + isSpread + ", signature="
				+ signature + ", tackel=" + tackel + ", state=" + state
				+ ", company=" + company + ", sourceLocation=" + sourceLocation
				+ ", destinationLocation=" + destinationLocation
				+ ", priority=" + priority + ", tel=" + tel + ", description="
				+ description + ", orderType=" + orderType
				+ ", fromWarehouseCode=" + fromWarehouseCode
				+ ", toWarehouseCode=" + toWarehouseCode + ", orderItems="
				+ orderItems + ", inventoryReport=" + inventoryReport
				+ ", lossReport=" + lossReport + "]";
	}
}
