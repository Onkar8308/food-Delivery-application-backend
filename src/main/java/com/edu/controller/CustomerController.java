package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Customer;
import com.edu.error.GlobalException;
import com.edu.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 * @PostMapping("/saveCustomer") Customer saveCustomer(@RequestBody Customer
	 * customer) { return customerService.saveCustomer(customer);
	 * 
	 * }
	 */
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		
		Customer cus = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(cus,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()throws GlobalException {
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{custid}")
	String deleteCustomerById(@PathVariable("custid") Integer customerid) throws GlobalException {
		customerService.deleteCustomerById(customerid);
		return "Customer deleted";
	}
	
	@PutMapping("/updateCustomerById/{custid}")
	Customer updateCustomerById(@PathVariable("custid") Integer customerid ,@Valid @RequestBody Customer customer){
		return customerService.updateCustomerById(customerid,customer);
	}

}

	
