package com.lin.warehouse.domain;

import java.io.Serializable;

public class LossReportItem implements Serializable {

	private static final long serialVersionUID = 1645254405007801039L;
	
	private int id;
	 
	private String barCode;
	
	private String substance;
	
	private String warehouseCode;
	
	private String name;
	
	private String owner;
	
	private String lossReason;
	
	private LossReport lossReport;

	public LossReportItem() {
	}

	public LossReportItem(int id, String barCode, String substance,
			String warehouseCode, String name, String owner, String lossReason,
			LossReport lossReport) {
		this.id = id;
		this.barCode = barCode;
		this.substance = substance;
		this.warehouseCode = warehouseCode;
		this.name = name;
		this.owner = owner;
		this.lossReason = lossReason;
		this.lossReport = lossReport;
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

	public String getLossReason() {
		return lossReason;
	}

	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
	}

	public LossReport getLossReport() {
		return lossReport;
	}

	public void setLossReport(LossReport lossReport) {
		this.lossReport = lossReport;
	}

	@Override
	public String toString() {
		return "LossReportItem [id=" + id + ", barCode=" + barCode
				+ ", substance=" + substance + ", warehouseCode="
				+ warehouseCode + ", name=" + name + ", owner=" + owner
				+ ", lossReason=" + lossReason + ", lossReport=" + lossReport
				+ "]";
	}

}
