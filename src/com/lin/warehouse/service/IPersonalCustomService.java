package com.lin.warehouse.service;

import com.lin.warehouse.domain.PersonalCustom;

/**
 * 处理个人用户相关业务
 * 
 * @author lin
 *
 */
public interface IPersonalCustomService extends IBaseService<PersonalCustom> {
	
	/**
	 * 用户登录
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public PersonalCustom login(String email,String password);
	
	/**
	 * 用户注册
	 * 
	 * @param personalCustom
	 * @return
	 */
	public String register(PersonalCustom personalCustom);
	
	/**
	 * 激活用户
	 * 
	 * @param email
	 */
	public PersonalCustom active(String email);

}
