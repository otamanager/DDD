package com.lin.warehouse.dao;

import com.lin.warehouse.domain.InventoryReport; 

public interface InventoryReportMapper extends Mapper<InventoryReport> {
	
	public InventoryReport readByCode(String code);

}
