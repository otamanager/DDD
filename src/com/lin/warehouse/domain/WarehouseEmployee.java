package com.lin.warehouse.domain;

import java.io.Serializable;

public class WarehouseEmployee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name; 
	
	private String tel;
	
	private String address;
	
	private String code;
	
	private Warehouse warehouse;

	public WarehouseEmployee() {
	}

	public WarehouseEmployee(int id, String name, String tel, String address,
			String code, Warehouse warehouse) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.code = code;
		this.warehouse = warehouse;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "WarehouseEmployee [id=" + id + ", name=" + name + ", tel="
				+ tel + ", address=" + address + ", code=" + code
				+ ", warehouse=" + warehouse + "]";
	}

}
