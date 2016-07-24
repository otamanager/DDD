package com.lin.warehouse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lin.warehouse.domain.OrderInfo;
import com.lin.warehouse.service.IOrderService;
import com.lin.warehouse.service.IWarehouseService;

@RestController
@RequestMapping(value="/rest")
public class InventoryRESTController { 
	
	@Autowired
	private IWarehouseService warehouseService;
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="/order/all",method=RequestMethod.GET)
    public List<OrderInfo> getAllUser()
    {
        List<OrderInfo> orders = orderService.readAll();
        
        return orders;
    }
	
//	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET, 
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<OrderInfo> getUserById(@PathVariable int id)
//    {
//        OrderInfo orderInfo = orderService.read(id);
//        
//        return new ResponseEntity<OrderInfo>(orderInfo, HttpStatus.OK);
//    }
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public OrderInfo getUserById(@PathVariable int id)
    {
        OrderInfo orderInfo = orderService.read(id);
        
        //return new ResponseEntity<OrderInfo>(orderInfo, HttpStatus.OK);
        
        return orderInfo;
    }

}
