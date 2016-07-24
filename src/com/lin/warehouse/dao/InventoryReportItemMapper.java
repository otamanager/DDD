package com.lin.warehouse.dao;

import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.InventoryReportItem;

public interface InventoryReportItemMapper extends Mapper<InventoryReportItem> {
	
	public List<InventoryReportItem> readByInventoryReportId(@Param(value="inventoryReport_id")int inventoryReport_id);

}
