package com.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.repository.OrdersRepository;

@Service
public class OrdersServiceImpl {

	@Autowired
	private OrdersRepository ordersRepository;

	public void saveOrder(Integer custid, Integer restid, Integer itemid, Integer cartid) {
		// TODO Auto-generated method stub
		ordersRepository.saveOrder(custid,restid,itemid,cartid);
		
	}
	
}
