package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

public class LockReport implements Serializable {

	private static final long serialVersionUID = -3386352119354884023L;
	
	private int id; 
	
	private Date lockDate;
	
	private String warehouseCode;
	
	private String description;

	public LockReport() {
	}

	public LockReport(int id, Date lockDate, String warehouseCode,
			String description) {
		this.id = id;
		this.lockDate = lockDate;
		this.warehouseCode = warehouseCode;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLockDate() {
		return lockDate;
	}

	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LockReport [id=" + id + ", lockDate=" + lockDate
				+ ", warehouseCode=" + warehouseCode + ", description="
				+ description + "]";
	}

}
