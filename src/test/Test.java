package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lin.warehouse.dao.MaterialInfoMapper;
import com.lin.warehouse.domain.InventoryReport;
import com.lin.warehouse.domain.InventoryReportItem;
import com.lin.warehouse.domain.LossReport;
import com.lin.warehouse.domain.LossReportItem;
import com.lin.warehouse.domain.Material;
import com.lin.warehouse.domain.MaterialInfo;
import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.domain.OrderItem;
import com.lin.warehouse.domain.PersonalCustom;
import com.lin.warehouse.domain.Warehouse;
import com.lin.warehouse.domain.WarehouseEmployee;
import com.lin.warehouse.domain.WarehouseManager;
import com.lin.warehouse.service.IOrderService;
import com.lin.warehouse.service.IPersonalCustomService;
import com.lin.warehouse.service.IWarehouseManagerService;
import com.lin.warehouse.service.IWarehouseService;
import com.lin.warehouse.service.impl.PersonalCustomServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml","classpath*:applicationContext-*.xml"})
public class Test {
	
	@Resource(name="warehouseManagerService")
	private IWarehouseManagerService warehouseManagerService;
	
	@Resource(name="warehouseService") 
	private IWarehouseService warehouseService;
	
	@Resource(name="orderService")
	private IOrderService orderService;
	
	@Resource(name="materialInfoMapper")
	private MaterialInfoMapper materialInfoMapper;
	
	@Resource(name="personalCustomService")
	private IPersonalCustomService personalCustomService;

	@org.junit.Test
	public void testSignin()
	{
		WarehouseManager warehouseManager = warehouseManagerService.signin("1", "1");
		System.out.println(warehouseManager.toString());
	}
	
	@org.junit.Test
	public void testAddWarehouse()
	{
		Warehouse warehouse = new Warehouse();
//		warehouse.setCapacity(10000);
//		warehouse.setCode("A-0001");
//		warehouse.setLatitude(33.5f);
//		warehouse.setLocation("中国广东省广州市白云区");
//		warehouse.setLongitude(48.9f);
		
		warehouse.setCapacity(10000);
		warehouse.setCode("A-0002");
		warehouse.setLatitude(33.5f);
		warehouse.setLocation("中国广东省深圳市南山区");
		warehouse.setLongitude(48.9f);
		
		warehouseService.create(warehouse);
		
	}
	
	@org.junit.Test
	public void testAddWarehouseEmployee()
	{
		Warehouse warehouse = warehouseService.read(2);
		
//		WarehouseEmployee warehouseEmployee = new WarehouseEmployee();
//		warehouseEmployee.setAddress("广东省广州市天河区");
//		warehouseEmployee.setCode("00001");
//		warehouseEmployee.setName("陈永仁");
//		warehouseEmployee.setTel("18820691730");
		WarehouseEmployee warehouseEmployee = new WarehouseEmployee();
		warehouseEmployee.setAddress("广东省珠海市香洲区");
		warehouseEmployee.setCode("00002");
		warehouseEmployee.setName("吴好缇");
		warehouseEmployee.setTel("18723197437");
		warehouseEmployee.setWarehouse(warehouse);
		
		warehouseService.addWarehouseEmployee(warehouse, warehouseEmployee);
	}
	
	@org.junit.Test
	public void testAddOrderInfo()
	{
		for(int i=1;i<20;i++)
		{
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setCode("AAAX"+i);
			orderInfo.setComeDate(new Date());
			orderInfo.setCompany("华南理工大学");
			orderInfo.setDescription("备注：这是华南理工大学的物资");
			//orderInfo.setDestinationLocation("广东海洋大学");
			//orderInfo.setFromWarehouseCode("A-0001");
			orderInfo.setToWarehouseCode("A-0002");
			orderInfo.setIsSpread(0);
			orderInfo.setOrderType(1);
			orderInfo.setPriority(1);
			orderInfo.setSignature("吴广德");
			orderInfo.setSourceLocation("华南理工大学");
			orderInfo.setState(0);
			orderInfo.setTackel("汽车");
			orderInfo.setTel("18820691730");
			
			orderService.create(orderInfo);
		}
	}
	
	@org.junit.Test
	public void testAddOrderItem()
	{
		for(int i=4;i<=22;i++)
		{
			OrderInfo orderInfo = orderService.read(i);
			
			OrderItem orderItem1 = new OrderItem();
			orderItem1.setCount(10);
			orderItem1.setMaterialValue(06000.0);
			orderItem1.setName("微型计算机");
			
			OrderItem orderItem2 = new OrderItem();
			orderItem2.setCount(10);
			orderItem2.setMaterialValue(124000.0);
			orderItem2.setName("实验服务器");
			
			OrderItem orderItem3 = new OrderItem();
			orderItem3.setCount(10);
			orderItem3.setMaterialValue(4000.0);
			orderItem3.setName("实验室办公桌");
			
			List<OrderItem> orderItems = new ArrayList<>();
			orderItems.add(orderItem1);orderItems.add(orderItem2);orderItems.add(orderItem3);
			
			orderService.addOrderItems(orderInfo, orderItems);
		}
	}
	
	@org.junit.Test
	public void testAddInventoryReport()
	{
		String code = UUID.randomUUID().toString();
		InventoryReport inventoryReport = new InventoryReport();
		inventoryReport.setCode(code);
		inventoryReport.setCreateDate(new Date());
		inventoryReport.setDescription("这是一个物资盘点单");
		inventoryReport.setEmployeeCode("00002");
		inventoryReport.setEmployeeName("吴好缇");
		inventoryReport.setWarehouseCode("A-0002");
		
		InventoryReportItem inventoryReportItem1 = new InventoryReportItem();
		inventoryReportItem1.setBarCode(UUID.randomUUID().toString());
		inventoryReportItem1.setName("微型计算机");
		inventoryReportItem1.setOwner("华南理工大学");
		inventoryReportItem1.setSubstance("个人计算机");
		inventoryReportItem1.setWarehouseCode("A-0002");
		inventoryReportItem1.setMaterialValue(4000.0);
		
		InventoryReportItem inventoryReportItem2 = new InventoryReportItem();
		inventoryReportItem2.setBarCode(UUID.randomUUID().toString());
		inventoryReportItem2.setName("微型计算机");
		inventoryReportItem2.setOwner("华南理工大学");
		inventoryReportItem2.setSubstance("个人计算机");
		inventoryReportItem2.setWarehouseCode("A-0002");
		inventoryReportItem2.setMaterialValue(4000.0);
		
		InventoryReportItem inventoryReportItem3 = new InventoryReportItem();
		inventoryReportItem3.setBarCode(UUID.randomUUID().toString());
		inventoryReportItem3.setName("微型计算机");
		inventoryReportItem3.setOwner("华南理工大学");
		inventoryReportItem3.setSubstance("个人计算机");
		inventoryReportItem3.setWarehouseCode("A-0002");
		inventoryReportItem3.setMaterialValue(4000.0);
		
		List<InventoryReportItem> items = new ArrayList<>();
		items.add(inventoryReportItem1);items.add(inventoryReportItem2);items.add(inventoryReportItem3);
		
		OrderInfo orderInfo = orderService.getOrderInfoByCode("AAAX0");
		
		orderService.addInventoryReport(orderInfo, inventoryReport, items);
	}
	
	@org.junit.Test
	public void testAddLossReport()
	{
		String code = UUID.randomUUID().toString();
		LossReport lossReport = new LossReport();
		lossReport.setCode(code);
		lossReport.setCreateDate(new Date());
		lossReport.setDescription("这是一个物资报损单");
		lossReport.setEmployee("吴好缇");
		lossReport.setWarehouseCode("A-0002");
		
		LossReportItem lossReportItem1 = new LossReportItem();
		lossReportItem1.setBarCode(UUID.randomUUID().toString());
		lossReportItem1.setLossReason("受潮");
		lossReportItem1.setName("实验服务器");
		lossReportItem1.setOwner("华南理工大学");
		lossReportItem1.setSubstance("服务器");
		lossReportItem1.setWarehouseCode("A-0002");
		
		LossReportItem lossReportItem2 = new LossReportItem();
		lossReportItem2.setBarCode(UUID.randomUUID().toString());
		lossReportItem2.setLossReason("外壳破裂");
		lossReportItem2.setName("实验服务器");
		lossReportItem2.setOwner("华南理工大学");
		lossReportItem2.setSubstance("服务器");
		lossReportItem2.setWarehouseCode("A-0002");
		
		LossReportItem lossReportItem3 = new LossReportItem();
		lossReportItem3.setBarCode(UUID.randomUUID().toString());
		lossReportItem3.setLossReason("短路故障");
		lossReportItem3.setName("实验服务器");
		lossReportItem3.setOwner("华南理工大学");
		lossReportItem3.setSubstance("服务器");
		lossReportItem3.setWarehouseCode("A-0002");
		
		List<LossReportItem> lossReportItems = new ArrayList<>();
		lossReportItems.add(lossReportItem1);
		lossReportItems.add(lossReportItem2);
		lossReportItems.add(lossReportItem3);
		
		OrderInfo orderInfo = orderService.getOrderInfoByCode("AAAX0");
		
		orderService.addLossReport(orderInfo, lossReport, lossReportItems);
	}
	
	@org.junit.Test
	public void testEnterWarehouse()
	{
		OrderInfo orderInfo = orderService.read(1);//当前入库订单
		Warehouse warehouse = warehouseService.readByCode("A-0002");
		
		warehouseService.enterWarehouse(orderInfo, warehouse);
	}
	
	@org.junit.Test
	public void testAddMaterialInfo()
	{
		Material material = new Material();
		material.setId(9);
		for(int i=0;i<10;i++)
		{
			MaterialInfo materialInfo = new MaterialInfo();
			materialInfo.setBarCode(UUID.randomUUID().toString());
			materialInfo.setMaterialValue(35000.0);
			materialInfo.setX(new Random().nextInt(10000));
			materialInfo.setY(new Random().nextInt(10000));
			materialInfo.setZ(new Random().nextInt(10000));
			materialInfo.setMaterial(material);
			
			materialInfoMapper.create(materialInfo);
		}
	}
	
	@org.junit.Test
	public void testAddPersonalCustom()
	{
		PersonalCustom personalCustom = new PersonalCustom();
		personalCustom.setCustomCode(UUID.randomUUID().toString());
		personalCustom.setDescription("这是一个个人用户");
		personalCustom.setEmail("linsfile@163.com");
		personalCustom.setName("林金智");
		personalCustom.setPassword("zhi19940306");
		personalCustom.setRegisterDate(new Date());
		personalCustom.setTel("18820691730");
		
		personalCustomService.create(personalCustom);
	}
	
	@org.junit.Test
	public void testPersonalCustomLogin()
	{
		PersonalCustom personalCustom = personalCustomService.login("linsfile@163.com", "zhi19940306");
		System.out.println(personalCustom.toString());
	}
	
	@org.junit.Test
	public void testPersonalCustomRegister()
	{
		PersonalCustom personalCustom = new PersonalCustom();
		personalCustom.setCustomCode(UUID.randomUUID().toString());
		personalCustom.setDescription("这是一个个人用户");
		personalCustom.setEmail("linsfile@163.com");
		personalCustom.setName("陈永仁");
		personalCustom.setPassword("zhi19940306");
		personalCustom.setRegisterDate(new Date());
		personalCustom.setTel("18723349263");
		
		String email = personalCustomService.register(personalCustom);
		System.out.println("email:"+email);
	}

}


