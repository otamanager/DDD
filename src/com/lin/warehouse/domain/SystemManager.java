package com.lin.warehouse.domain;

import java.io.Serializable;

public class SystemManager implements Serializable {
	
	private static final long serialVersionUID = -8027381728656116448L;

	private int id;
	
	private String code; 
	
	private String pin;

	public SystemManager() {
	}

	public SystemManager(int id, String code, String pin) {
		this.id = id;
		this.code = code;
		this.pin = pin;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "SystemManager [id=" + id + ", code=" + code + ", pin=" + pin
				+ "]";
	}

}
