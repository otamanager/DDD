package com.lin.warehouse.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lin.warehouse.domain.CompanyCustom;
import com.lin.warehouse.domain.PersonalCustom;
import com.lin.warehouse.service.ICompanyCustomService;
import com.lin.warehouse.service.IPersonalCustomService;

@Controller
public class RegisterController {
	
	@Autowired
	private IPersonalCustomService personalCustomService;
	
	@Autowired
	private ICompanyCustomService companyCustomService;
	
	/**
	 * 个人用户注册信息提交.
	 * @param personalCustom
	 * @return
	 */
	@RequestMapping(value="/personalRegister",method=RequestMethod.POST)
	public ModelAndView personalRegister(@ModelAttribute("personalCustom")PersonalCustom personalCustom)
	{
		personalCustom.setCustomCode(UUID.randomUUID().toString());
		personalCustom.setRegisterDate(new Date());
		
		String emailType = personalCustomService.register(personalCustom);
		
		return new ModelAndView("WEB-INF/jsp/registerTemp1", "emailType",emailType);
	}
	
	/**
	 * 企业用户注册信息提交.
	 * @param companyCustom
	 * @return
	 */
	@RequestMapping(value="/companyRegister",method=RequestMethod.POST)
	public ModelAndView companyRegister(@ModelAttribute("companyCustom")CompanyCustom companyCustom)
	{
		companyCustom.setCustomCode(UUID.randomUUID().toString());
		companyCustom.setRegisterDate(new Date());
		
		String emailType = companyCustomService.register(companyCustom);
		
		return new ModelAndView("WEB-INF/jsp/registerTemp1","emailType",emailType);
	}
	
	/**
	 * 客户账号激活.
	 * @param request
	 * @param email
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/customActive",method=RequestMethod.GET)
	public String customActive(HttpServletRequest request,String email,int type)
	{
		Object custom = null;
		
		if(type == 1)
		{
			custom = personalCustomService.active(email);//个人用户户激活
		}
		if(type == 2)
		{
			custom = companyCustomService.active(email);//企业用户激活
		}
		
		HttpSession session = request.getSession();
		if(custom instanceof PersonalCustom)//激活的是个人用户
		{
			session.setAttribute("custom",(PersonalCustom)custom);
		}
		if(custom instanceof CompanyCustom)//激活的是企业用户
		{
			session.setAttribute("custom", (CompanyCustom)custom);
		}
		return "WEB-INF/jsp/registerTemp2";
	}

}
