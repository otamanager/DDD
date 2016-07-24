package com.lin.warehouse.service;

import com.lin.warehouse.domain.CompanyCustom;

/**
 * 处理企业用户相关业务逻辑.
 * 
 * @author lin
 *
 */
public interface ICompanyCustomService extends IBaseService<CompanyCustom> {
	
	/**
	 * 企业用户登录.
	 * @param email
	 * @param password
	 * @return
	 */
	public CompanyCustom login(String email,String password);
	
	/**
	 * 企业用户注册.
	 * 
	 * @param personalCustom
	 * @return
	 */
	public String register(CompanyCustom companyCustom);
	
	/**
	 * 激活用户
	 * 
	 * @param email
	 */
	public CompanyCustom active(String email);

}
