package com.lin.warehouse.service;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.Warehouse;
import com.lin.warehouse.domain.WarehouseEmployee;

public interface IWarehouseService extends IBaseService<Warehouse> {
	
	/**
	 * 添加仓库值班人员.
	 * @param warehouse 仓库信息.
	 * @param warehouseEmployee 值班人员信息. 
	 */
	public void addWarehouseEmployee(Warehouse warehouse,WarehouseEmployee warehouseEmployee);
	
	/**
	 * 根据仓库编号查询仓库信息.
	 * @param warehosueCode 仓库编号
	 * @return
	 */
	public Warehouse readByCode(String warehosueCode);
	
	/**
	 * 物资入库.
	 * @param orderInfo 入库订单信息
	 */
	public void enterWarehouse(OrderInfo orderInfo,Warehouse warehouse);
	
	/**
	 * 创建入库/出库指令
	 * @param name 值班人员姓名
	 * @param code 值班人员编号
	 * @param warehouseCode 指令来源仓库编号
	 * @return 
	 */
	public WarehouseEmployee createCommand(String name,String code,String warehouseCode);

}
