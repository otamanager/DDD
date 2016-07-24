package com.lin.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.Material;
import com.lin.warehouse.domain.Warehouse;
import com.lin.warehouse.service.IMaterialService;
import com.lin.warehouse.service.IWarehouseService;

@Controller
public class WarehouseController { 
	
	@Autowired
	private IWarehouseService warehouseService;
	
	@Autowired
	private IMaterialService materialService;
	
	@RequestMapping(value="/warehouses",method=RequestMethod.GET)
	public ModelAndView getWarehouses()
	{
		List<Warehouse> warehouses = warehouseService.readAll();
		
		return new ModelAndView("/WEB-INF/jsp/warehouses", "warehouses", warehouses);
	}
	
	@RequestMapping(value="/warehouseDetails",method=RequestMethod.GET)
	public ModelAndView warehouseDetails(int id)
	{
		Warehouse warehouse = warehouseService.read(id);
		
		return new ModelAndView("/WEB-INF/jsp/warehouseDetails", "warehouse",warehouse);
	}
	
	@RequestMapping(value="/materialDetails",method=RequestMethod.GET)
	public ModelAndView materialDetails(int id)
	{
		Material material = materialService.read(id);
		
		return new ModelAndView("/WEB-INF/jsp/materialDetails", "material", material);
	}

}
