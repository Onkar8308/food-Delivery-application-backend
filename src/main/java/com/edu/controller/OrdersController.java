package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Orders;
import com.edu.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService; 
	
	@PostMapping("/enterOrder")
	public Orders enterOrder(@RequestBody Orders orders) {
		return ordersService.enterOrder(orders);
	}
}
