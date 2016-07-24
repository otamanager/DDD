package com.lin.warehouse.domain;

import java.io.Serializable;

public class MaterialInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id; 
	
	private String barCode;
	
	private double materialValue;
	
	private int x;
	
	private int y;
	
	private int z;
	
	private Material material;

	public MaterialInfo() {
	}
	
	

	public MaterialInfo(int id, String barCode, double materialValue, int x,
			int y, int z, Material material) {
		super();
		this.id = id;
		this.barCode = barCode;
		this.materialValue = materialValue;
		this.x = x;
		this.y = y;
		this.z = z;
		this.material = material;
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



	public double getMaterialValue() {
		return materialValue;
	}

	public void setMaterialValue(double materialValue) {
		this.materialValue = materialValue;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "MaterialInfo [id=" + id + ", barCode=" + barCode
				+ ", materialValue=" + materialValue + ", x=" + x + ", y=" + y
				+ ", z=" + z + ", material=" + material + "]";
	}

}
