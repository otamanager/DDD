package com.lin.warehouse.domain;

import java.io.Serializable;

public class WarehouseManager implements Serializable {
	
	private static final long serialVersionUID = 4906035978201506408L;

	private int id;
	
	private String code; 
	
	private String email;
	
	private String password;

	public WarehouseManager() {
	}

	public WarehouseManager(int id, String code, String email, String password) {
		this.id = id;
		this.code = code;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "WarehouseManager [id=" + id + ", code=" + code + ", email="
				+ email + ", password=" + password + "]";
	}

}
