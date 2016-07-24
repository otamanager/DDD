package com.lin.warehouse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.WarehouseEmployee;
import com.lin.warehouse.service.IWarehouseService;

@Controller
public class CreateCommandController {
	
	@Autowired
	private IWarehouseService warehouseService;
	
	@RequestMapping(value="/createCommand",method=RequestMethod.POST)
	public ModelAndView createCommand(HttpServletRequest request,String name,String code,String warehouseCode,int commandType)
	{
		WarehouseEmployee warehouseEmployee = warehouseService.createCommand(name, code, warehouseCode);
		
		if(warehouseEmployee == null)
		{
			return new ModelAndView("/we_index", "info", "指令审核错误！");
		}
		else {
			HttpSession session = request.getSession();
			
			session.setAttribute("warehouseEmployee", warehouseEmployee);
			
			return commandType == 1 ? 
					new ModelAndView("/WEB-INF/jsp/createInCommand") : 
						new ModelAndView("/WEB-INF/jsp/createOutCommand");
		}
	}

}
