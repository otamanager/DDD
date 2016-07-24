package com.lin.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.LossReportItem;

public interface LossReportItemMapper extends Mapper<LossReportItem> { 
	
	public List<LossReportItem> readByLossReportId(@Param(value="lossReport_id")int lossReport_id);

}
