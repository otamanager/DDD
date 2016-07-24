package com.lin.warehouse.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.lin.warehouse.dao.InventoryReportItemMapper;
import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.dao.MaterialInfoMapper;
import com.lin.warehouse.dao.MaterialMapper;
import com.lin.warehouse.dao.OrderInfoMapper;
import com.lin.warehouse.dao.WarehouseEmployeeMapper;
import com.lin.warehouse.dao.WarehouseMapper;
import com.lin.warehouse.domain.InventoryReport;
import com.lin.warehouse.domain.InventoryReportItem;
import com.lin.warehouse.domain.Material;
import com.lin.warehouse.domain.MaterialInfo;
import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.Warehouse;
import com.lin.warehouse.domain.WarehouseEmployee;
import com.lin.warehouse.service.IWarehouseService;

public class WarehouseServiceImpl extends BaseServiceImpl<Warehouse> implements IWarehouseService {
	
	private WarehouseMapper warehouseMapper;
	
	private WarehouseEmployeeMapper warehouseEmployeeMapper;
	
	private InventoryReportItemMapper inventoryReportItemMapper;
	
	private OrderInfoMapper orderInfoMapper; 
	
	private MaterialMapper materialMapper;
	private MaterialInfoMapper materialInfoMapper;

	public WarehouseMapper getWarehouseMapper() {
		return warehouseMapper;
	}

	public void setWarehouseMapper(WarehouseMapper warehouseMapper) {
		this.warehouseMapper = warehouseMapper;
	}

	public WarehouseEmployeeMapper getWarehouseEmployeeMapper() {
		return warehouseEmployeeMapper;
	}

	public void setWarehouseEmployeeMapper(
			WarehouseEmployeeMapper warehouseEmployeeMapper) {
		this.warehouseEmployeeMapper = warehouseEmployeeMapper;
	}

	public InventoryReportItemMapper getInventoryReportItemMapper() {
		return inventoryReportItemMapper;
	}

	public void setInventoryReportItemMapper(
			InventoryReportItemMapper inventoryReportItemMapper) {
		this.inventoryReportItemMapper = inventoryReportItemMapper;
	}

	public OrderInfoMapper getOrderInfoMapper() {
		return orderInfoMapper;
	}

	public void setOrderInfoMapper(OrderInfoMapper orderInfoMapper) {
		this.orderInfoMapper = orderInfoMapper;
	}

	public MaterialMapper getMaterialMapper() {
		return materialMapper;
	}

	public void setMaterialMapper(MaterialMapper materialMapper) {
		this.materialMapper = materialMapper;
	}

	public MaterialInfoMapper getMaterialInfoMapper() {
		return materialInfoMapper;
	}

	public void setMaterialInfoMapper(MaterialInfoMapper materialInfoMapper) {
		this.materialInfoMapper = materialInfoMapper;
	}

	public WarehouseServiceImpl(Mapper<Warehouse> mapper) {
		super(mapper);
		this.warehouseMapper = (WarehouseMapper)mapper;
	}

	@Override
	public void addWarehouseEmployee(Warehouse warehouse,WarehouseEmployee warehouseEmployee) {
		
		warehouseEmployee.setWarehouse(warehouse);
		warehouseEmployeeMapper.create(warehouseEmployee);
	}

	@Override
	public void enterWarehouse(OrderInfo orderInfo,Warehouse warehouse) {
		
		InventoryReport inventoryReport = orderInfo.getInventoryReport();
		
		Map<Material, List<MaterialInfo>> materialMap = inventoryReport2Materials(inventoryReport);
		
		saveMaterials(materialMap,warehouse);
	}

	@Override
	public Warehouse readByCode(String warehosueCode) {
		
		if(warehosueCode != null && warehosueCode.length() != 0)
		{
			return warehouseMapper.readByCode(warehosueCode);
		}
		return null;
	}
	
	/**
	 * 盘点单转换成仓库物资列表.
	 * @param inventoryReport
	 * @return
	 */
	private Map<Material, List<MaterialInfo>> inventoryReport2Materials(InventoryReport inventoryReport)
	{
		if(inventoryReport != null)
		{
			List<InventoryReportItem> inventoryReportItems = 
					inventoryReportItemMapper.readByInventoryReportId(inventoryReport.getId());
			
			Map<Material, List<MaterialInfo>> materialMap = new HashMap<Material, List<MaterialInfo>>();
			
			List<MaterialInfo> materialInfos = null;
			
			for(InventoryReportItem inventoryReportItem : inventoryReportItems)
			{
				//根据盘点单物资项创建仓库物资项信息
				MaterialInfo materialInfo = new MaterialInfo();
				materialInfo.setBarCode(UUID.randomUUID().toString());
				//该物资在仓库中的坐标。未解决
				materialInfo.setX(new Random().nextInt(10000));
				materialInfo.setY(new Random().nextInt(10000));
				materialInfo.setZ(new Random().nextInt(10000));
				
				materialInfo.setMaterialValue(inventoryReportItem.getMaterialValue());
				
				//创建物资信息
				Material material = new Material();
				material.setCode(UUID.randomUUID().toString());
				material.setName(inventoryReportItem.getName());
				material.setOwner(inventoryReportItem.getOwner());
				material.setSubstance(inventoryReportItem.getSubstance());
				
				if(materialMap.containsKey(material))//还是当前物资
				{
					materialMap.get(material).add(materialInfo);
				}
				else {
					materialInfos = new ArrayList<>();
					materialInfos.add(materialInfo);
					materialMap.put(material, materialInfos);
				}
			}
			return materialMap;
		}
		return null;
	}
	
	/**
	 * 保存仓库物资列表.
	 * @param materialMap
	 * @param warehouse
	 */
	private void saveMaterials(Map<Material, List<MaterialInfo>> materialMap,Warehouse warehouse)
	{
		Set<Map.Entry<Material, List<MaterialInfo>>> materials = materialMap.entrySet();
		
		for(Map.Entry<Material, List<MaterialInfo>> materialEntry : materials)
		{
			Material material = materialEntry.getKey();
			material.setWarehouse(warehouse);
			
			materialMapper.create(material);
			
			material = materialMapper.readByCode(material.getCode());
			
			List<MaterialInfo> materialInfos = materialEntry.getValue();
			
			for(MaterialInfo materialInfo : materialInfos)
			{
				System.out.println(material);
				materialInfo.setMaterial(material);
				materialInfoMapper.create(materialInfo);
			}
		}
	}

	@Override
	public WarehouseEmployee createCommand(String name, String code,
			String warehouseCode) {
		
		WarehouseEmployee warehouseEmployee = warehouseEmployeeMapper.readByCode(code);
		if(warehouseEmployee != null && warehouseEmployee.getName().equals(name) && 
				warehouseEmployee.getWarehouse().getCode().equals(warehouseCode))
		{
			return warehouseEmployee;
		}
		
		return null;
	}

}
