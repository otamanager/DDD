package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人客户
 * 
 * @author lin
 *
 */
public class PersonalCustom implements Serializable {

	private static final long serialVersionUID = 203058550338833098L;
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 注册日志
	 */
	private Date registerDate;
	/**
	 * 客户编号，唯一值
	 */
	private String customCode;
	/**
	 * 备注
	 */
	private String description;
	/**
	 * 客户姓名
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 电话
	 */
	private String tel;
	
	/**
	 * 是否已经激活，1：激活	0：未激活，默认0
	 */
	private int actived;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getCustomCode() {
		return customCode;
	}

	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getActived() {
		return actived;
	}

	public void setActived(int actived) {
		this.actived = actived;
	}

	@Override
	public String toString() {
		return "PersonalCustom [id=" + id + ", registerDate=" + registerDate
				+ ", customCode=" + customCode + ", description=" + description
				+ ", name=" + name + ", email=" + email + ", password="
				+ password + ", tel=" + tel + ", actived=" + actived + "]";
	}
}
