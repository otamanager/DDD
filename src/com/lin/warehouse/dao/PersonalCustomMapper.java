package com.lin.warehouse.dao;

import org.apache.ibatis.annotations.Param;

import com.lin.warehouse.domain.PersonalCustom;

public interface PersonalCustomMapper extends Mapper<PersonalCustom> {
	
	/**
	 * 根据用户邮箱获取用户.
	 * @param email
	 * @return
	 */
	public PersonalCustom readByEmail(@Param("email")String email);
	
	/**
	 * 根据用户邮箱和密码获取用户.
	 * @param email
	 * @param password
	 * @return
	 */
	public PersonalCustom readByEmailAndPassword(@Param("email")String email,@Param("password")String password);

}
