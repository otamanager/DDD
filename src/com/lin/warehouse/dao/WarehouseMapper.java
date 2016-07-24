package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.Warehouse;

public interface WarehouseMapper extends Mapper<Warehouse> {
	
	public Warehouse readByCode(@Param(value="code")String code);

}
 