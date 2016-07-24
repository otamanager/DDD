package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.LossReport;

public interface LossReportMapper extends Mapper<LossReport> { 
	
	public LossReport readByCode(@Param(value="code")String code);

}
