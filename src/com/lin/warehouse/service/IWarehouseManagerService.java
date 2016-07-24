package com.lin.warehouse.service;

import com.lin.warehouse.domain.WarehouseManager;

public interface IWarehouseManagerService extends IBaseService<WarehouseManager> {
	
	public WarehouseManager signin(String email,String password); 

}
