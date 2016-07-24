package com.lin.warehouse.service.impl;

import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.dao.MaterialInfoMapper;
import com.lin.warehouse.dao.MaterialMapper;
import com.lin.warehouse.domain.Material;
import com.lin.warehouse.service.IMaterialService;

public class MaterialServiceImpl extends BaseServiceImpl<Material> implements IMaterialService {
	
	private MaterialMapper materialMapper;
	
	private MaterialInfoMapper materialInfoMapper;

	public MaterialMapper getMaterialMapper() {
		return materialMapper; 
	}

	public void setMaterialMapper(MaterialMapper materialMapper) {
		this.materialMapper = materialMapper;
	}

	public MaterialInfoMapper getMaterialInfoMapper() {
		return materialInfoMapper;
	}

	public void setMaterialInfoMapper(MaterialInfoMapper materialInfoMapper) {
		this.materialInfoMapper = materialInfoMapper;
	}

	public MaterialServiceImpl(Mapper<Material> mapper) {
		super(mapper);
		this.materialMapper = (MaterialMapper)mapper;
	}

}
