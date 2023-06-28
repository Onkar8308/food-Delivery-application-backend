package com.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Orders;
import com.edu.repository.OrdersRepository;

@Service
public class OrdersSerivceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders enterOrder(Orders orders) {
		// TODO Auto-generated method stub
		return ordersRepository.save(orders);
	}

	
}
