package com.lin.warehouse.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.CompanyCustom;
import com.lin.warehouse.domain.PersonalCustom;
import com.lin.warehouse.domain.WarehouseManager;
import com.lin.warehouse.service.ICompanyCustomService;
import com.lin.warehouse.service.IOrderService;
import com.lin.warehouse.service.IPersonalCustomService;
import com.lin.warehouse.service.IWarehouseManagerService;

@Controller
public class SigninController {
 
	@Autowired
	private IWarehouseManagerService warehouseManagerService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IPersonalCustomService personalCustomService;
	
	@Autowired
	private ICompanyCustomService companyCustomService;

	public IWarehouseManagerService getWarehouseManagerService() {
		return warehouseManagerService;
	}

	public void setWarehouseManagerService(
			IWarehouseManagerService warehouseManagerService) {
		this.warehouseManagerService = warehouseManagerService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 仓库管理员用户登录.
	 * @param email
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wmSignin", method = RequestMethod.POST)
	public ModelAndView wmSignin(String email, String password,
			HttpServletRequest request) 
	{
		WarehouseManager warehouseManager = warehouseManagerService.signin(
				email, password);
		if(warehouseManager == null)
		{
			ModelAndView modelAndView = new ModelAndView("wm_index", "info",
					"登录错误");
			return modelAndView;
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("warehouseManager", warehouseManager);
			
			return new ModelAndView("redirect:/getNoProcessOrders");
		}
	}
	
	/**
	 * 用户登录选择.
	 * @param email
	 * @param password
	 * @param customType
	 * @return
	 */
	@RequestMapping(value="/customLogin",method=RequestMethod.POST)
	public ModelAndView customLogin(HttpServletRequest request,String email,String password,int customType)
	{
		Object custom = null;
		if(customType == 1)//个人用户
		{
			custom = personalCustomLogin(email,password);
		}
		if(customType == 2)//企业用户
		{
			custom = companyCustomLogin(email,password);
		}
		if(custom != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("custom", custom);
			
			return new ModelAndView("WEB-INF/jsp/customHome");
		}
		return new ModelAndView("WEB-INF/jsp/customLogin","info", "登录错误");
	}
	
	/**
	 * 个人用户登录.
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */
	private PersonalCustom personalCustomLogin(String email,String password)
	{
		if(email != null && password != null && email.length() != 0 && password.length() != 0)
		{
			PersonalCustom personalCustom = personalCustomService.login(email, password);
			if(personalCustom != null && personalCustom.getActived() == 0)//未激活登录失败
			{
				return null;
			}
			return personalCustom;
		}
		return null;
	}
	
	/**
	 * 企业用户登录.
	 * @param request
	 * @param email
	 * @param password
	 * @return
	 */
	private CompanyCustom companyCustomLogin(String email,String password)
	{
		if(email != null && password != null && email.length() != 0 && password.length() != 0)
		{
			CompanyCustom companyCustom = companyCustomService.login(email, password);
			if(companyCustom != null && companyCustom.getActived() == 0)//未激活登录失败
			{
				return null;
			}
			return companyCustom;
		}
		return null;
	}
}
