package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.Material;

public interface MaterialMapper extends Mapper<Material> { 
	
	public Material readByCode(@Param(value="code")String code);

}
