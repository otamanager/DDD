package com.lin.warehouse.domain;

import java.io.Serializable;

public class InventoryReportItem implements Serializable {

	private static final long serialVersionUID = 2342423843403167385L;
	
	private int id; 
	
	private String barCode;
	
	private String substance;
	
	private String warehouseCode;
	
	private String name;
	
	private String owner;
	
	private double materialValue;
	
	private InventoryReport inventoryReport;

	public InventoryReportItem() {
	}

	public InventoryReportItem(int id, String barCode, String substance,
			String warehouseCode, String name, String owner,
			double materialValue, InventoryReport inventoryReport) {
		super();
		this.id = id;
		this.barCode = barCode;
		this.substance = substance;
		this.warehouseCode = warehouseCode;
		this.name = name;
		this.owner = owner;
		this.materialValue = materialValue;
		this.inventoryReport = inventoryReport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getSubstance() {
		return substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public InventoryReport getInventoryReport() {
		return inventoryReport;
	}

	public void setInventoryReport(InventoryReport inventoryReport) {
		this.inventoryReport = inventoryReport;
	}

	public double getMaterialValue() {
		return materialValue;
	}

	public void setMaterialValue(double materialValue) {
		this.materialValue = materialValue;
	}

	@Override
	public String toString() {
		return "InventoryReportItem [id=" + id + ", barCode=" + barCode
				+ ", substance=" + substance + ", warehouseCode="
				+ warehouseCode + ", name=" + name + ", owner=" + owner
				+ ", materialValue=" + materialValue + ", inventoryReport="
				+ inventoryReport + "]";
	}
}
