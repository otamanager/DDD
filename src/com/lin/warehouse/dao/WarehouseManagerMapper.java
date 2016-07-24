package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.WarehouseManager;

public interface WarehouseManagerMapper extends Mapper<WarehouseManager> {
	
	public WarehouseManager selectByEmialAndPassword(@Param(value = "email") String email,@Param(value="password") String password);
 
}
