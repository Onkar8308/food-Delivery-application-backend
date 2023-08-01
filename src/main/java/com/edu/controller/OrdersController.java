package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edu.service.OrdersServiceImpl;

@RestController
public class OrdersController {

	@Autowired
	private OrdersServiceImpl ordersServiceImpl;
	
	
	@GetMapping("/saveOrder/customerid/{custid}/restid/{restid}/itemid/{itemid}/cartid/{cartid}/")
	public String saveOrder(@PathVariable Integer custid,@PathVariable Integer restid,@PathVariable Integer itemid,@PathVariable Integer cartid) {
		
		ordersServiceImpl.saveOrder(custid,restid,itemid,cartid);
		return null;
	}
}
