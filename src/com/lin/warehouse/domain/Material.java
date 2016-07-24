package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Material implements Serializable {
	
	private static final long serialVersionUID = 745556743453651629L;

	private int id; 
	
	private String substance;
	
	private String code;
	
	private String owner;
	
	private String name;
	
	private List<MaterialInfo> materialInfos = new ArrayList<>();
	
	private Warehouse warehouse;

	public Material() {
	}

	public Material(int id, String substance, String code, String owner,
			String name, Warehouse warehouse) {
		this.id = id;
		this.substance = substance;
		this.code = code;
		this.owner = owner;
		this.name = name;
		this.warehouse = warehouse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubstance() {
		return substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<MaterialInfo> getMaterialInfos() {
		return materialInfos;
	}

	public void setMaterialInfos(List<MaterialInfo> materialInfos) {
		this.materialInfos = materialInfos;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", substance=" + substance + ", code="
				+ code + ", owner=" + owner + ", name=" + name + ", warehouse="
				+ warehouse + "]";
	}

}
