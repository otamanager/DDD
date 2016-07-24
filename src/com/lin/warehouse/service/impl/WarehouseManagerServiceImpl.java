package com.lin.warehouse.service.impl;

import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.dao.WarehouseManagerMapper;
import com.lin.warehouse.domain.WarehouseManager;
import com.lin.warehouse.service.IWarehouseManagerService;

public class WarehouseManagerServiceImpl extends BaseServiceImpl<WarehouseManager> implements IWarehouseManagerService {

	private WarehouseManagerMapper warehouseManagerMapper;
	
	public WarehouseManagerServiceImpl(Mapper<WarehouseManager> mapper) {
		super(mapper);
		this.warehouseManagerMapper = (WarehouseManagerMapper)mapper; 
	}

	public WarehouseManagerMapper getWarehouseManagerMapper() {
		return warehouseManagerMapper;
	}

	public void setWarehouseManagerMapper(
			WarehouseManagerMapper warehouseManagerMapper) {
		this.warehouseManagerMapper = warehouseManagerMapper;
	}

	@Override
	public WarehouseManager signin(String email, String password) {
		
		return warehouseManagerMapper.selectByEmialAndPassword(email, password);
	}

}
