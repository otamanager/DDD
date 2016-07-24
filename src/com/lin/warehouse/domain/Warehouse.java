package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Serializable {
	
	private static final long serialVersionUID = -2660058008822310259L;

	private int id;
	
	private String code; 
	
	private int capacity;
	
	private String location;
	
	private float longitude;
	
	private float latitude;
	
	private List<Material> materials = new ArrayList<Material>();
	
	private List<WarehouseEmployee> warehouseEmployees = new ArrayList<WarehouseEmployee>();

	public Warehouse() {
	}

	public Warehouse(int id, String code, int capacity, String location,
			float longitude, float latitude) {
		this.id = id;
		this.code = code;
		this.capacity = capacity;
		this.location = location;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public List<WarehouseEmployee> getWarehouseEmployees() {
		return warehouseEmployees;
	}

	public void setWarehouseEmployees(List<WarehouseEmployee> warehouseEmployees) {
		this.warehouseEmployees = warehouseEmployees;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", code=" + code + ", capacity="
				+ capacity + ", location=" + location + ", longitude="
				+ longitude + ", latitude=" + latitude + ", materials="
				+ materials + ", warehouseEmployees=" + warehouseEmployees
				+ "]";
	}
}
