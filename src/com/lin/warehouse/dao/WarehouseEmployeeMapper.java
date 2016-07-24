package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.WarehouseEmployee;

public interface WarehouseEmployeeMapper extends Mapper<WarehouseEmployee> { 
	
	public WarehouseEmployee readByCode(@Param(value="code")String code);

}
