package com.lin.warehouse.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 现场入库/出库�? * @author lin
 *
 */
public class SceneOrder implements Serializable { 

	private static final long serialVersionUID = 9131643412358974326L;
	
	private String code;
	
	private String orderCode;
	
	private String tackelType;
	
	private String tackelNumber;
	
	private String carrier;
	
	private String description;
	
	private String creator;
	
	private Date createDate;
	
	private int sceneOrderType;
	
	private int isPass;//是否审核通过 0：未审核 1：已通过 2：未通过

	public SceneOrder() {
	}

	public SceneOrder(String code, String orderCode, String tackelType,
			String tackelNumber, String carrier, String description,
			String creator, Date createDate, int sceneOrderType, int isPass) {
		super();
		this.code = code;
		this.orderCode = orderCode;
		this.tackelType = tackelType;
		this.tackelNumber = tackelNumber;
		this.carrier = carrier;
		this.description = description;
		this.creator = creator;
		this.createDate = createDate;
		this.sceneOrderType = sceneOrderType;
		this.isPass = isPass;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTackelType() {
		return tackelType;
	}

	public void setTackelType(String tackelType) {
		this.tackelType = tackelType;
	}

	public String getTackelNumber() {
		return tackelNumber;
	}

	public void setTackelNumber(String tackelNumber) {
		this.tackelNumber = tackelNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSceneOrderType() {
		return sceneOrderType;
	}

	public void setSceneOrderType(int sceneOrderType) {
		this.sceneOrderType = sceneOrderType;
	}

	@Override
	public String toString() {
		return "SceneOrder [code=" + code + ", orderCode=" + orderCode
				+ ", tackelType=" + tackelType + ", tackelNumber="
				+ tackelNumber + ", carrier=" + carrier + ", description="
				+ description + ", creator=" + creator + ", createDate="
				+ createDate + ", sceneOrderType=" + sceneOrderType
				+ ", isPass=" + isPass + "]";
	}
}
